package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.GoodsType;
import com.handsome.shop.dao.GoodsTypeDao;
import com.handsome.shop.framework.hibernate.HibernateDao;
import com.handsome.shop.framework.hibernate.Q;

import java.util.List;

/**
 * by wangrongjun on 2017/6/18.
 */
public class GoodsTypeDaoImpl extends HibernateDao<GoodsType> implements GoodsTypeDao {

    @Override
    public List<GoodsType> queryAll() {
        return query(new Q().orderBy("goodsTypeId"));
    }

}
