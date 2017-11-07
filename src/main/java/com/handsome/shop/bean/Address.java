package com.handsome.shop.bean;


import javax.persistence.*;

/**
 * by wangrongjun on 2017/6/19.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer addressId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToOne
    private Area area;
    private String street;

    public Address() {
    }

    public Address(Customer customer, Area area, String street) {
        this.customer = customer;
        this.area = area;
        this.street = street;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
