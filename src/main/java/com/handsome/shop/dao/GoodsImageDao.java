package com.handsome.shop.dao;

import com.handsome.shop.bean.GoodsImage;
import com.wangrg.db2.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface GoodsImageDao extends Dao<GoodsImage> {

    List<GoodsImage> queryByGoodsId(int goodsId);//查询某个商品的所有图片

}
