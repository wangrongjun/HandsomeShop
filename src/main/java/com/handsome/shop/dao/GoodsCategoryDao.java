package com.handsome.shop.dao;

import com.wangrj.java_lib.mybatis.MybatisDao;
import com.handsome.shop.bean.GoodsCategory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan
@Repository
public interface GoodsCategoryDao extends MybatisDao<GoodsCategory> {

    List<GoodsCategory> queryWithChildrenById(int categoryId);

}
