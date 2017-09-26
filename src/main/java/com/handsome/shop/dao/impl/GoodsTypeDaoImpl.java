package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.GoodsType;
import com.handsome.shop.dao.GoodsTypeDao;
import com.handsome.shop.framework.GuiMeiDao;
import com.wangrg.db2.Query;

import java.util.List;

/**
 * by wangrongjun on 2017/6/18.
 */
public class GoodsTypeDaoImpl extends GuiMeiDao<GoodsType> implements GoodsTypeDao {
    @Override
    protected Class<GoodsType> getEntityClass() {
        return GoodsType.class;
    }

    @Override
    public List<GoodsType> queryAll() {
        return query(Query.build(null).orderBy("goodsTypeId"));
    }
}
