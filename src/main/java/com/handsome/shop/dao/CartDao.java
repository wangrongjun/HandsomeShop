package com.handsome.shop.dao;

import com.wangrj.java_lib.mybatis.MybatisDao;
import com.handsome.shop.bean.Cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@MapperScan
@Repository
public interface CartDao extends MybatisDao<Cart> {

}
