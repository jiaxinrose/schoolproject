package com.bdqn.controller.admin;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Floor;
import com.bdqn.service.FloorService;
import com.bdqn.utils.DataGridViewResult;
import com.bdqn.utils.SystemConstant;
import com.bdqn.vo.FloorVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/floor")
public class FloorController {
    @Resource
    private FloorService floorService;

    /**
     * 查询楼层列表
     * @param floorVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(FloorVo floorVo){
        //设置分页信息
        PageHelper.startPage(floorVo.getPage(),floorVo.getLimit());
        //调用查询楼层列表的方法
        List<Floor> floorList = floorService.findFloorList(floorVo);
        //创建分页对象
        PageInfo<Floor> pageInfo = new PageInfo<Floor>(floorList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加楼层
     * @param floor
     * @return
     */
    @RequestMapping("/addFloor")
    public String addFloor(Floor floor){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用添加楼层的方法
        if(floorService.addFloor(floor)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"添加成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }
    /**
     * 修改楼层
     * @param floor
     * @return
     */
    @RequestMapping("/updateFloor")
    public String updateFloor(Floor floor){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用修改楼层的方法
        if(floorService.updateFloor(floor)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 删除楼层
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用删除部门的方法
        if(floorService.deleteById(id)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 查询所有楼层
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(){
        return JSON.toJSONString(floorService.findFloorList(null));
    }


}
