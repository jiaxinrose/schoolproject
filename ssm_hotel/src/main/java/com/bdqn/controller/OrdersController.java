package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Orders;

import com.bdqn.service.OrdersService;
import com.bdqn.utils.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
   private OrdersService ordersService;

    @RequestMapping("/addOrders")
    @ResponseBody
    public String addOrders(Orders orders) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (ordersService.addOrders(orders) > 0) {
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"预定成功!");
        }else{
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"预定失败!");
        }
        return JSON.toJSONString(map);
    }


}


