package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 分页查询
     */
    @RequestMapping("/findByPage")
    public String findByPage(Model model, @RequestParam(name = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(name = "rows",defaultValue = "3") Integer rows){
        //调用业务层查询数据
        List<Orders> ordersList = ordersService.findByPage(pageNo,rows);
        //创建分页对象
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(ordersList);
        //将数据存储到model中
        model.addAttribute("pageInfo",pageInfo);
        return "orders-list";
    }

    /**
     * 查询详情信息
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        //调用service层查询数据
        Orders orders = ordersService.findById(id);
        // 创建视图存储数据
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");

        return modelAndView;
    }
}
