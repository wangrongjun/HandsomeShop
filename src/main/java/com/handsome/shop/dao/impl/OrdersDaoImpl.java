package com.handsome.shop.dao.impl;

import com.handsome.shop.bean.GoodsImage;
import com.handsome.shop.bean.Orders;
import com.handsome.shop.dao.DaoFactory;
import com.handsome.shop.dao.GoodsImageDao;
import com.handsome.shop.dao.OrdersDao;
import com.handsome.shop.framework.GuiMeiDao;
import com.wangrg.db2.Query;
import com.wangrg.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class OrdersDaoImpl extends GuiMeiDao<Orders> implements OrdersDao {
    @Override
    protected Class<Orders> getEntityClass() {
        return Orders.class;
    }

    @Override
    public List<Orders> queryByCustomerId(int customerId) {
        List<Orders> ordersList = query(Query.build(Where.build("customer", customerId + "")).
                maxQueryForeignKeyLevel(2).
                ignore("customer").
                orderBy("-createTime")
        );

        GoodsImageDao goodsImageDao = DaoFactory.getGoodsImageDao();
        for (Orders orders : ordersList) {
            List<GoodsImage> goodsImageList = goodsImageDao.queryByGoodsId(orders.getGoods().getGoodsId());
            orders.getGoods().setGoodsImageList(goodsImageList);
        }

        return ordersList;
    }

    @Override
    public int queryCountByCustomerId(int customerId) {
        long count = queryCount(Where.build("customer", customerId + ""));
        return (int) count;
    }

    @Override
    public int queryCountByGoodsId(int goodsId) {
        long count = queryCount(Where.build("goods", goodsId + ""));
        return (int) count;
    }
}
