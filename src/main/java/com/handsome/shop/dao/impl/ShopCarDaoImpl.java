package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.ShopCar;
import com.handsome.shop.dao.ShopCarDao;
import com.handsome.shop.framework.GuiMeiDao;
import com.wangrg.db2.Where;

/**
 * by wangrongjun on 2017/6/16.
 */
public class ShopCarDaoImpl extends GuiMeiDao<ShopCar> implements ShopCarDao {
    @Override
    protected Class<ShopCar> getEntityClass() {
        return ShopCar.class;
    }

    @Override
    public long queryCountByCustomerId(int customerId) {
        return queryCount(Where.build("customer", customerId + ""));
    }
}
