package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.GoodsCategory;
import com.handsome.shop.dao.GoodsCategoryDao;
import com.wangrj.java_lib.hibernate.HibernateDao;
import com.wangrj.java_lib.hibernate.Q;

import java.util.List;

/**
 * by wangrongjun on 2017/6/18.
 */
public class GoodsTypeDaoImpl extends HibernateDao<GoodsCategory> implements GoodsCategoryDao {

    @Override
    public List<GoodsCategory> queryAll() {
        return query(new Q().orderBy("goodsTypeId"));
    }

}
