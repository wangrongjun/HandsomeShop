package com.handsome.shop.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * by wangrongjun on 2017/6/16.
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Integer carId;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Goods goods;
    private Integer count;

    public Cart() {
    }

    public Cart(Customer customer, Goods goods, Integer count) {
        this.customer = customer;
        this.goods = goods;
        this.count = count;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
