package com.itheima.service;

import com.itheima.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> findAll(Integer pageNo, Integer rows);


    UserInfo findDetail(String id);

    void add(UserInfo userInfo);
}
