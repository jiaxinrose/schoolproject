package com.bdqn.service.impl;

import com.bdqn.dao.OrdersMapper;
import com.bdqn.dao.RoomMapper;
import com.bdqn.dao.RoomTypeMapper;
import com.bdqn.entity.Orders;
import com.bdqn.entity.Room;
import com.bdqn.entity.RoomType;
import com.bdqn.service.OrdersService;
import com.bdqn.utils.UUIDUtils;
import com.bdqn.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomTypeMapper roomTypeMapper;
    /**
     * 添加订单
     *
     * @param orders
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int addOrders(Orders orders) {
        orders.setOrdersno(UUIDUtils.randomUUID());
        orders.setStatus(1);
        orders.setReservedate(new Date());
        int ordersAddRes = ordersMapper.addOrders(orders);
        if (ordersAddRes > 0) {
            // 房间状态改变为已预订(1)
            Room room = new Room();
            room.setId(orders.getRoomid());
            room.setStatus(1);
            int roomUpdateRes = roomMapper.updateRoom(room);

            // 改变房型数据：可用房间-1 预定房间+1
            RoomType roomType = roomTypeMapper.findById(orders.getRoomtypeid());
            roomType.setAvilablenum((roomType.getAvilablenum() - 1));
            roomType.setReservednum((roomType.getReservednum() + 1));
            int roomTypeUpdateRes = roomTypeMapper.updateRoomType(roomType);
        }
        return ordersAddRes;
    }

    public List<Orders> findOrdersList(OrdersVo ordersVo) {
        return ordersMapper.findOrdersList(ordersVo);
    }

    public int updateOrders(Orders orders) {
        return ordersMapper.updateOrders(orders);
    }
}
