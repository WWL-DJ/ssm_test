package com.itheima.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserInfoMapper {


    /**
     * 根据用户名查询用户信息及用户的角色信息
     * @param username
     * @return
     */
    @Select("select * from USERINFO where username = #{username}")
    @Results({
            @Result(id = true , property = "id" ,column = "ID"),
            @Result(property = "username" ,column = "USERNAME"),
            @Result(property = "email" ,column = "EMAIL"),
            @Result(property = "password" ,column = "PASSWORD"),
            @Result(property = "phoneNum" ,column = "PHONENUM"),
            @Result(property = "status" ,column = "STATUS"),
            @Result(property = "roles" ,column = "ID" ,many = @Many(select = "com.itheima.dao.RoleMapper.findByUserId")),

    })
    public UserInfo findByUsername(String username);

    /**
     * 分页查询所有用户数据
     * @return
     */
    @Select("select * from USERINFO")
    List<UserInfo> findAll();


    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Select("select * from USERINFO where  id = #{id}")
    @Results({
            @Result(id = true , property = "id" ,column = "ID"),
            @Result(property = "username" ,column = "USERNAME"),
            @Result(property = "email" ,column = "EMAIL"),
            @Result(property = "password" ,column = "PASSWORD"),
            @Result(property = "phoneNum" ,column = "PHONENUM"),
            @Result(property = "status" ,column = "STATUS"),
            @Result(property = "roles" ,column = "ID" ,many = @Many(select = "com.itheima.dao.RoleMapper.findByUserId")),

    })
    UserInfo findById(String id);


    /**
     * 保存用户信息到数据库
     * @param userInfo
     */
    @Insert("insert into USERINFO values(sys_guid(),#{email},#{username},#{password},#{phoneNum},#{status})")
    void add(UserInfo userInfo);
}
