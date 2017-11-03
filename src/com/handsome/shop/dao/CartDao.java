package com.handsome.shop.dao;

import com.handsome.shop.bean.Cart;
import com.wangrj.java_lib.hibernate.Dao;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface CartDao extends Dao<Cart> {

    long queryCountByCustomerId(int customerId);

}
