package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.Cart;
import com.handsome.shop.dao.CartDao;
import com.wangrj.java_lib.hibernate.HibernateDao;
import com.wangrj.java_lib.hibernate.Where;

/**
 * by wangrongjun on 2017/6/16.
 */
public class ShopCarDaoImpl extends HibernateDao<Cart> implements CartDao {

    @Override
    public long queryCountByCustomerId(int customerId) {
        return queryCount(Where.eq("customer", customerId + ""));
    }

}
