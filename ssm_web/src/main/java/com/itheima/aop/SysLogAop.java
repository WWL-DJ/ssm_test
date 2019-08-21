package com.itheima.aop;

import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class SysLogAop {

    Date startTime;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //前置增强
    public void beforLog(){
        //记录用户开始执行时间
        startTime = new Date();
    }

    //后置增强
    public void afterReturningLog(JoinPoint joinPoint){
        //方法执行完的时间
        Date endTime = new Date();

        //获取当前de访问用户
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        //获取用户的远程地址
        String addr = request.getRemoteAddr();
        //获取请求资源URL
        String uri = request.getRequestURI();
        //获取方法的执行时间
        long millis = endTime.getTime() - startTime.getTime();
        //获取访问的方法名称
        String methodName = joinPoint.getSignature().getName();

        //将搜集的数据封装到对象中
        SysLog sysLog = new SysLog();
        sysLog.setVisitTime(startTime);
        sysLog.setUsername(userName);
        sysLog.setIp(addr);
        sysLog.setUrl(uri);
        sysLog.setExecutionTime(millis);
        sysLog.setMethod(methodName);

        //调用业务层将数据存入数据库
        sysLogService.add(sysLog);


    }
}
