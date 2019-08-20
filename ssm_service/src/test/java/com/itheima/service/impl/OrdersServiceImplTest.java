package com.itheima.service.impl;

import com.itheima.domain.Orders;
import com.itheima.domain.UserInfo;
import com.itheima.service.OrdersService;
import com.itheima.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-service.xml")
public class OrdersServiceImplTest {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void findById() {
        Orders byId = ordersService.findById("2FF351C4AC744E2092DCF08CFD314420");
        System.out.println(byId);
    }
    @Test
    public void test1(){
        Orders byId = ordersService.findById("84F5F966791A40649C34FA14A202DC7C");
        System.out.println(byId);
    }

    @Test
    public void test01(){
        UserInfo detail = userInfoService.findDetail("84F5F966791A40649C34FA14A202DC7C");
        System.out.println(detail);
    }

}