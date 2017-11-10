package com.handsome.shop.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * by wangrongjun on 2017/8/31.
 */
@Entity
public class AttrComb {

    @Id
    @GeneratedValue
    private Integer attrCombId;
    @ManyToOne
    private Goods goods;
    private Double price;
    private Integer remainCount;// 库存
    @ManyToOne
    private AttrValue attrValue1;
    @ManyToOne
    private AttrValue attrValue2;
    @ManyToOne
    private AttrValue attrValue3;
    @ManyToOne
    private AttrValue attrValue4;
    @ManyToOne
    private AttrValue attrValue5;
    @ManyToOne
    private AttrValue attrValue6;
    @ManyToOne
    private AttrValue attrValue7;
    @ManyToOne
    private AttrValue attrValue8;
    @ManyToOne
    private AttrValue attrValue9;

    public AttrComb() {
    }

    public AttrComb(Goods goods, Double price, Integer remainCount,
                    AttrValue attrValue1, AttrValue attrValue2, AttrValue attrValue3) {
        this.goods = goods;
        this.price = price;
        this.remainCount = remainCount;
        this.attrValue1 = attrValue1;
        this.attrValue2 = attrValue2;
        this.attrValue3 = attrValue3;
    }

    public AttrComb(Goods goods, Double price, Integer remainCount,
                    AttrValue attrValue1, AttrValue attrValue2, AttrValue attrValue3,
                    AttrValue attrValue4, AttrValue attrValue5, AttrValue attrValue6,
                    AttrValue attrValue7, AttrValue attrValue8, AttrValue attrValue9) {
        this.goods = goods;
        this.price = price;
        this.remainCount = remainCount;
        this.attrValue1 = attrValue1;
        this.attrValue2 = attrValue2;
        this.attrValue3 = attrValue3;
        this.attrValue4 = attrValue4;
        this.attrValue5 = attrValue5;
        this.attrValue6 = attrValue6;
        this.attrValue7 = attrValue7;
        this.attrValue8 = attrValue8;
        this.attrValue9 = attrValue9;
    }

    public Integer getAttrCombId() {
        return attrCombId;
    }

    public void setAttrCombId(Integer attrCombId) {
        this.attrCombId = attrCombId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }

    public AttrValue getAttrValue1() {
        return attrValue1;
    }

    public void setAttrValue1(AttrValue attrValue1) {
        this.attrValue1 = attrValue1;
    }

    public AttrValue getAttrValue2() {
        return attrValue2;
    }

    public void setAttrValue2(AttrValue attrValue2) {
        this.attrValue2 = attrValue2;
    }

    public AttrValue getAttrValue3() {
        return attrValue3;
    }

    public void setAttrValue3(AttrValue attrValue3) {
        this.attrValue3 = attrValue3;
    }

    public AttrValue getAttrValue4() {
        return attrValue4;
    }

    public void setAttrValue4(AttrValue attrValue4) {
        this.attrValue4 = attrValue4;
    }

    public AttrValue getAttrValue5() {
        return attrValue5;
    }

    public void setAttrValue5(AttrValue attrValue5) {
        this.attrValue5 = attrValue5;
    }

    public AttrValue getAttrValue6() {
        return attrValue6;
    }

    public void setAttrValue6(AttrValue attrValue6) {
        this.attrValue6 = attrValue6;
    }

    public AttrValue getAttrValue7() {
        return attrValue7;
    }

    public void setAttrValue7(AttrValue attrValue7) {
        this.attrValue7 = attrValue7;
    }

    public AttrValue getAttrValue8() {
        return attrValue8;
    }

    public void setAttrValue8(AttrValue attrValue8) {
        this.attrValue8 = attrValue8;
    }

    public AttrValue getAttrValue9() {
        return attrValue9;
    }

    public void setAttrValue9(AttrValue attrValue9) {
        this.attrValue9 = attrValue9;
    }
}
