package com.bdqn.service;

import com.bdqn.entity.Floor;
import com.bdqn.vo.FloorVo;

import java.util.List;

public interface FloorService {
    /**
     * 查询楼层列表
     * @param floorVo
     * @return
     */
    List<Floor> findFloorList(FloorVo floorVo);

    /**
     * 添加楼层
     * @param floor
     * @return
     */
    int addFloor(Floor floor);

    /**
     * 修改楼层
     * @param floor
     * @return
     */
    int updateFloor(Floor floor);

    /**
     * 删除楼层
     * @param id
     * @return
     */
    int deleteById(Integer id);
}
