package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


    @RequestMapping(path = "findByPage")
    public String findByPage(Model model, @RequestParam(name = "pageNo",defaultValue = "1") Integer pageNo,@RequestParam(name = "rows",defaultValue = "8") Integer rows){
        //调用service查询数据
        List<SysLog> sysLogs = sysLogService.findByPage(pageNo,rows);
        //创建分页对象
        PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(sysLogs);

        // 存储数据到model
        model.addAttribute("pageInfo",pageInfo);

        return "syslog-list";
    }
}
