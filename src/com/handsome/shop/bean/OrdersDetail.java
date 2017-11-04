package com.handsome.shop.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * by wangrongjun on 2017/11/3.
 */
@Entity
public class OrdersDetail {

    @Id
    @GeneratedValue
    private Integer detailId;
    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Goods goods;
    private String goodsName;//购买时的商品名称（避免下单后商家修改或删除商品导致无法显示商品名称）
    private Integer goodsCount;
    private Double goodsPrice;// 商品单价

    public OrdersDetail() {
    }

    public OrdersDetail(Orders orders, Goods goods, String goodsName, Integer goodsCount, Double goodsPrice) {
        this.orders = orders;
        this.goods = goods;
        this.goodsName = goodsName;
        this.goodsCount = goodsCount;
        this.goodsPrice = goodsPrice;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
