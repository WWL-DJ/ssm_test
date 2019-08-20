package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    /**
     * 查询所有
     */
    @Select("select * from product")
    public List<Product> findAll(Integer pageNo,Integer rows);

    /**
     * 添加商品数据
     */
    @Insert("insert into product values (sys_guid(),#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void add(Product product);

    @Select("select * from product where id = #{id}")
    public Product findById(String id);
}
