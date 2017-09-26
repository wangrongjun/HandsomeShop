package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.Customer;
import com.handsome.shop.dao.CustomerDao;
import com.handsome.shop.framework.GuiMeiDao;
import com.wangrg.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class CustomerDaoImpl extends GuiMeiDao<Customer> implements CustomerDao {
    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public Customer query(String phone, String password) {
        List<Customer> list = query(new Where().equal("phone", phone).and().equal("password", password));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean queryExists(String phone) {
        return queryCount(Where.build("phone", phone)) > 0;
    }

    @Override
    public boolean updateHeadUrl(int customerId, String headUrl) {
        Customer customer = queryById(customerId);
        customer.setHeadUrl(headUrl);
        return update(customer);
    }

}
