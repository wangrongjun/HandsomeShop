package com.handsome.shop.dao;

import com.handsome.shop.bean.Customer;
import com.wangrg.db2.Dao;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface CustomerDao extends Dao<Customer> {

    Customer query(String phone, String password);

    boolean queryExists(String phone);

    boolean updateHeadUrl(int customerId, String headUrl);

}
