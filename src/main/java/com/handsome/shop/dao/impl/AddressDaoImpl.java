package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.Address;
import com.handsome.shop.dao.AddressDao;
import com.handsome.shop.framework.GuiMeiDao;
import com.wangrg.db2.Query;
import com.wangrg.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/19.
 */
public class AddressDaoImpl extends GuiMeiDao<Address> implements AddressDao {
    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    public List<Address> queryByCustomerId(int customerId) {
        return query(Query.build(Where.build("customer", customerId + "")).maxQueryForeignKeyLevel(0));
    }
}
