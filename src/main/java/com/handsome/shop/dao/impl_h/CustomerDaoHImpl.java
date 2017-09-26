package com.handsome.shop.dao.impl_h;

import com.handsome.shop.bean.Customer;
import com.handsome.shop.dao.CustomerDao;
import com.handsome.shop.framework.HibernateDao;
import com.wangrg.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/7/12.
 */
public class CustomerDaoHImpl extends HibernateDao<Customer> implements CustomerDao {

    @Override
    public Customer query(String phone, String password) {
        List<Customer> customerList = query(Where.build("phone", phone).equal("password", password));
        if (customerList != null && customerList.size() > 0) {
            return customerList.get(0);
        }
        return null;
    }

    @Override
    public boolean queryExists(String phone) {
        List<Customer> customerList = query(Where.build("phone", phone));
        return customerList != null && customerList.size() > 0;
    }

    @Override
    public boolean updateHeadUrl(int customerId, String headUrl) {
        Customer customer = queryById(customerId);
        customer.setHeadUrl(headUrl);
        return update(customer);
    }

}
