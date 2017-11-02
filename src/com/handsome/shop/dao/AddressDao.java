package com.handsome.shop.dao;

import com.handsome.shop.bean.Address;
import com.wangrj.java_lib.hibernate.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/6/19.
 */
public interface AddressDao extends Dao<Address> {

    List<Address> queryByCustomerId(int customerId);

}