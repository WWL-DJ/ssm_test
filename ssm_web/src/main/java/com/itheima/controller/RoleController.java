package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(path = "findAll")
    public String findAll(Model model){
        //调用业务层查询数据
        List<Role> roles = roleService.findAll();
        // 存储到模块
        model.addAttribute("roles",roles);
        return "role-list";
    }

    /**
     *
     * @param model
     * @param id
     */
    @RequestMapping(path = "findById")
    public String findById (Model model,String id){
        //调用业务层查询数据
        Role role = roleService.findById(id);
        // 存储到模块
        model.addAttribute("role",role);
        return "role-show";
    }

    /**
     *  新建 添加角色
     */
    @RequestMapping(path = "add")
    public String add(Role role){
        roleService.add(role);

        return "redirect:/role/findAll";
    }

    /**
     * 根据userId查询角色信息
     */
    @RequestMapping(path = "findByUserToId")
    public String findByUserToId(Model model,String userId){
        //调用service层查询数据
        List<Role> roles = roleService.findByUserToId(userId);
        //将数据存储到model
        model.addAttribute("roles",roles);
        model.addAttribute("userId",userId);

        return "user-role-add";
    }

    /**
     * 根据userId查询角色
     */
    @RequestMapping(path = "userAddRole")
    public String userAddRole(String userId,String[] ids){
        //调用service层添加角色
        roleService.userAddRole(userId,ids);

        return "redirect:/user/findAll";
    }
}
