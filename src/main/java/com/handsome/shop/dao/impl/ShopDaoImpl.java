package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.Shop;
import com.handsome.shop.dao.ShopDao;
import com.handsome.shop.framework.GuiMeiDao;

/**
 * by wangrongjun on 2017/6/17.
 */
public class ShopDaoImpl extends GuiMeiDao<Shop> implements ShopDao {
    @Override
    protected Class<Shop> getEntityClass() {
        return Shop.class;
    }
}
