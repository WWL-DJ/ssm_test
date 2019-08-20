package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionsMapper permissionsMapper;


    @Test
    public void test1(){
        UserInfo byId = userInfoMapper.findById("84F5F966791A40649C34FA14A202DC7C");
        //System.out.println(byId);//com.itheima.domain.UserInfo@5c45d770
        List<Role> byUserId = roleMapper.findByUserId("84F5F966791A40649C34FA14A202DC7C");
        //System.out.println(byUserId);
        List<Permission> byRoleId = permissionsMapper.findByRoleId("251F37D51E9A453EBE7F5D3A8736F403");
        System.out.println(byRoleId);

    }


}