package com.handsome.shop.bean;


import javax.persistence.*;

/**
 * by wangrongjun on 2017/6/16.
 */
@Entity
public class Customer {

    @Transient
    public static final int GENDER_WOMAN = 0;
    @Transient
    public static final int GENDER_MAN = 1;

    @Id
    @GeneratedValue
    private Integer customerId;
    private String phone;
    private String password;
    private String realName;
    private String nickname;
    private Integer gender;
    private String headUrl;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", headUrl='" + headUrl + '\'' +
                '}';
    }

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(String phone, String password, String realName, String nickname,
                    Integer gender, String headUrl) {
        this.phone = phone;
        this.password = password;
        this.realName = realName;
        this.nickname = nickname;
        this.gender = gender;
        this.headUrl = headUrl;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
