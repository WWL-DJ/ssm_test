package com.itheima.dao;

import com.itheima.domain.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class OrdersMapperTest {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void test1(){
        Orders orders = ordersMapper.findById("0E7231DC797C486290E8713CA3C6ECCC");
        System.out.println(orders);
    }

}