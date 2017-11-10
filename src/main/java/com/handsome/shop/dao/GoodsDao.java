package com.handsome.shop.dao;

import com.wangrj.java_lib.mybatis.MybatisDao;
import com.handsome.shop.bean.Goods;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan
@Repository
public interface GoodsDao extends MybatisDao<Goods> {

    List<Goods> queryByCategoryId(@Param("categoryName") String categoryName);

}
