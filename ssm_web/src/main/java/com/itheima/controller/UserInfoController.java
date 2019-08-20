package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(path = "findAll")
    public String findAll(Model model, @RequestParam(name = "pageNo",defaultValue = "1")Integer pageNo, @RequestParam(name = "rows",defaultValue = "3") Integer rows){
        // 调用业务层查询数据
        List<UserInfo> userInfos = userInfoService.findAll(pageNo,rows);

        // 创建分页对象
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos);
        // 存储到model中
        model.addAttribute("pageInfo",pageInfo);
        // 跳转页面
        return "user-list";
    }

   /* @RequestMapping(path = "findById")
    public String  findById( Model model,String id){
        //调用service业务层查询数据
        UserInfo userInfo = userInfoService.findById(id);
        //存储数据到model
        model.addAttribute("userInfo",userInfo);
        return "user-show";
    }*/
    /**
     * 查询用户详情
     * @return
     */
    @RequestMapping(path = "/findDetail")
    public String findDetail(Model model , String id){
        //调用业务层查询数据
        UserInfo userInfo = userInfoService.findDetail(id);
        //将查询到的数据存入到Model中
        model.addAttribute("userInfo",userInfo);
        //跳转视图
        return "user-show";
    }

    /**
     * 添加User用户
     */
    @RequestMapping(path = "add")
    public String add(UserInfo userInfo){
        //调用service层添加数据
        userInfoService.add(userInfo);

        return "redirect:/user/findAll";
    }
}
