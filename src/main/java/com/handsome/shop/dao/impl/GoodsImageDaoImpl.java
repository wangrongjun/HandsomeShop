package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.GoodsImage;
import com.handsome.shop.dao.GoodsImageDao;
import com.handsome.shop.framework.hibernate.HibernateDao;
import com.handsome.shop.framework.hibernate.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class GoodsImageDaoImpl extends HibernateDao<GoodsImage> implements GoodsImageDao {

    @Override
    public List<GoodsImage> queryByGoodsId(int goodsId) {
        return query(Where.eq("goods.id", String.valueOf(goodsId)));
    }

}
