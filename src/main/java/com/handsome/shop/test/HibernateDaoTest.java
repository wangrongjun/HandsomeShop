package com.handsome.shop.test;

import com.handsome.shop.bean.Customer;
import com.handsome.shop.dao.CustomerDao;
import com.handsome.shop.dao.impl_h.CustomerDaoHImpl;
import com.handsome.shop.framework.HibernateDao;
import com.wangrg.java_util.GsonUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * by wangrongjun on 2017/7/12.
 */
public class HibernateDaoTest {

    private CustomerDao customerDao;

    @Test
    public void testGuiMeiDao() {
        Customer 王荣俊 = new Customer("15521302230", "123", "王荣俊", "英俊", 1, "admin/img/customer_1.jpg");
        Customer 沫沫 = new Customer("13023796942", "123", "沫沫", "沫宝儿", 0, "admin/img/customer_2.jpg");

        customerDao.insert(王荣俊);
        customerDao.insert(沫沫);
        GsonUtil.printFormatJson(customerDao.query("15521302230", "123"));
        GsonUtil.printFormatJson(customerDao.queryById(2));
        GsonUtil.printFormatJson(customerDao.queryAll());
    }

    @Test
    public void testDelete() {
        GsonUtil.printFormatJson(customerDao.queryAll());
    }

    @Before
    public void init() {
        customerDao = new CustomerDaoHImpl();
    }

    @After
    public void close() {
        HibernateDao.closeSessionFactory();
    }

}
