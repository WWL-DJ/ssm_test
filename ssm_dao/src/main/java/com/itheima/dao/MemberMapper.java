package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {

    @Select("select * from member where id = #{id}")
    public Member findById(String id);
}
