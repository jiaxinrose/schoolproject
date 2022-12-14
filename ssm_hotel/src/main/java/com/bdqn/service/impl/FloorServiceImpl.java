package com.bdqn.service.impl;

import com.bdqn.dao.FloorMapper;
import com.bdqn.entity.Floor;
import com.bdqn.service.FloorService;
import com.bdqn.vo.FloorVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class FloorServiceImpl implements FloorService {
    @Resource
    private FloorMapper floorMapper;

    /**
     * 查询楼层列表
     *
     * @param floorVo
     * @return
     */
    public List<Floor> findFloorList(FloorVo floorVo) {
        return floorMapper.findFloorList(floorVo);
    }

    public int addFloor(Floor floor) {
        return floorMapper.addFloor(floor);
    }

    public int updateFloor(Floor floor) {
       return floorMapper.updateFloor(floor);
   }
    public int deleteById(Integer id) {
        return floorMapper.deleteById(id);
    }
}
