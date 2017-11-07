package com.handsome.shop.dao;

import com.wangrj.java_lib.mybatis.MybatisDao;
import com.handsome.shop.bean.Orders;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@MapperScan
@Repository
public interface OrdersDao extends MybatisDao<Orders> {

}
