package com.handsome.shop.dao;

import com.handsome.shop.bean.Seller;
import com.wangrg.db2.Dao;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface SellerDao extends Dao<Seller> {

    Seller query(String phone, String password);

    boolean queryExists(String phone);
}
