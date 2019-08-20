package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(path = "findAll")
    public String findAll(Model model){
        //调用Service层查询数据
        List<Permission> permissions = permissionService.findAll();
        //存储数据到model
        model.addAttribute("permissions",permissions);
        return "permission-list";
    }

    /**
     * 添加权限数据
     */
    @RequestMapping(path = "add")
    public String add(Permission permission){
        permissionService.add(permission);

        return "redirect:/permission/findAll";
    }

    @RequestMapping(path = "delete")
    public String del(String id){
        // 调用service层删除数据
        permissionService.del(id);

        return "redirect:/permission/findAll";
    }

}
