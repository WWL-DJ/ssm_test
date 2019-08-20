package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerMapper {

    @Select("select * from traveller where id in (select TRAVELLERID from ORDER_TRAVELLER where ORDERID=#{id})")
    public List<Traveller> findByOrdersId(String id);
}
