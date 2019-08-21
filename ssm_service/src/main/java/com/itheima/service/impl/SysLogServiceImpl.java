package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.SysLogMapper;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void add(SysLog sysLog) {
        sysLogMapper.add(sysLog);
    }


    //分页查询所有数据
    @Override
    public List<SysLog> findByPage(Integer pageNo, Integer rows) {
        //开启分页查询
        PageHelper.startPage(pageNo,rows);

        return sysLogMapper.findByPage(pageNo,rows);
    }
}
