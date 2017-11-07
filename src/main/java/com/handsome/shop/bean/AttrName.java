package com.handsome.shop.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * by wangrongjun on 2017/8/31.
 */
@Entity
public class AttrName {

    @Id
    @GeneratedValue
    private Integer attrNameId;
    private String attrName;
    @ManyToOne
    private Goods goods;

    public AttrName() {
    }

    public AttrName(String attrName, Goods goods) {
        this.attrName = attrName;
        this.goods = goods;
    }

    public Integer getAttrNameId() {
        return attrNameId;
    }

    public void setAttrNameId(Integer attrNameId) {
        this.attrNameId = attrNameId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
