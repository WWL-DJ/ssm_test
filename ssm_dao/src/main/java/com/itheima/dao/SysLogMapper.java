package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogMapper {

    /**
     *保存数据到数据库
     * @param sysLog
     */
    @Insert("insert into SYSLOG values(sys_guid(),#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void add(SysLog sysLog);


    /**
     * 分页查询所有数据
     * @return
     */
    @Select("select * from SYSLOG")
    List<SysLog> findByPage(Integer pageNo, Integer rows);
}
