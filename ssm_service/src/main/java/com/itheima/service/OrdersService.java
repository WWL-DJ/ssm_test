package com.itheima.service;

import com.itheima.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrdersService {
    /*
    分页查询订单信息
     */
    List<Orders> findByPage(Integer pageNo, Integer rows);

    Orders findById(String id);

    /**
     * 查询订单详情
     */
}
