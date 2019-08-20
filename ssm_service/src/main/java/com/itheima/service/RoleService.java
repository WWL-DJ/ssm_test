package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();


    Role findById(String id);

    void add(Role role);
}
