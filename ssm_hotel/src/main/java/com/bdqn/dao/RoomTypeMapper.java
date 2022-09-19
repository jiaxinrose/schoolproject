package com.bdqn.dao;

import com.bdqn.entity.RoomType;
import com.bdqn.vo.RoomTypeVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomTypeMapper {
    /**
     * 查询房型列表
     * @param roomTypeVo
     * @return
     */
    List<RoomType> findRoomTypeList(RoomTypeVo roomTypeVo);

    /**
     * 添加房型
     * @param roomType
     * @return
     */
    int addRoomType(RoomType roomType);
    /**
     * 修改房型
     * @param roomType
     * @return
     */
    int updateRoomType(RoomType roomType);

    /**
     * 根据房型Id查询该房型下的房间数量
     * @param roomTypeId
     * @return
     */
   int getRoomCountByRoomTypeId(Integer roomTypeId);
    /**
     * 删除房型
     * @param id
     * @return
     */
    int deleteById(Integer id);


    /**
     * 根据房型ID查询房型信息
     * @param roomtypeid
     * @return
     */

    RoomType findById(Integer roomtypeid);
}


