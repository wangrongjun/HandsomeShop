package com.handsome.shop.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * by wangrongjun on 2017/8/31.
 */
@Entity
public class AttrValue {

    @Id
    @GeneratedValue
    private Integer attrValueId;
    private String attrValue;
    @ManyToOne
    private AttrName attrName;

    public AttrValue() {
    }

    public AttrValue(String attrValue, AttrName attrName) {
        this.attrValue = attrValue;
        this.attrName = attrName;
    }

    public Integer getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Integer attrValueId) {
        this.attrValueId = attrValueId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public AttrName getAttrName() {
        return attrName;
    }

    public void setAttrName(AttrName attrName) {
        this.attrName = attrName;
    }
}
