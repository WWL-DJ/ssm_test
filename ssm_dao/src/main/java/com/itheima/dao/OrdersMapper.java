package com.itheima.dao;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface OrdersMapper {


    @Select("select * from orders")
    @Results({
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "orderNum" , column = "ORDERNUM"),
            @Result(property = "orderTime" , column = "ORDERTIME"),
            @Result(property = "orderStatus" , column = "ORDERSTATUS"),
            @Result(property = "peopleCount" , column = "PEOPLECOUNT"),
            @Result(property = "payType" , column = "PAYTYPE"),
            @Result(property = "orderDesc" , column = "ORDERDESC"),
            @Result(property = "product" , column = "PRODUCTID",one = @One(select = "com.itheima.dao.ProductMapper.findById")),
    })
    public List<Orders> findAll();

    /**
     *查询详情
     * 多表操作
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "orderNum" , column = "ORDERNUM"),
            @Result(property = "orderTime" , column = "ORDERTIME"),
            @Result(property = "orderStatus" , column = "ORDERSTATUS"),
            @Result(property = "peopleCount" , column = "PEOPLECOUNT"),
            @Result(property = "payType" , column = "PAYTYPE"),
            @Result(property = "orderDesc" , column = "ORDERDESC"),
            @Result(property = "product" ,
                    column = "PRODUCTID",
                    one = @One(select = "com.itheima.dao.ProductMapper.findById")),
            @Result(property = "member",
                    column = "MEMBERID" ,
                    one = @One(select = "com.itheima.dao.MemberMapper.findById")),
            @Result(property = "travellers",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.dao.TravellerMapper.findByOrdersId"))
    })
    Orders findById(String id);


}
