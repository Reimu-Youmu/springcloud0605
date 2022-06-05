package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：xuxiao
 * @date ：Created in 22/2/21 21:00
 */
@Mapper
public interface UserDetailDao {

    List<?> queryUserDetailsList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
