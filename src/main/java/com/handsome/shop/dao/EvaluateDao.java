package com.handsome.shop.dao;

import com.wangrj.java_lib.mybatis.MybatisDao;
import com.handsome.shop.bean.Evaluate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan
@Repository
public interface EvaluateDao extends MybatisDao<Evaluate> {

    List<Evaluate> queryByGoodsId(int goodsId);

}
