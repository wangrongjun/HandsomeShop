package com.handsome.shop.bean;


import javax.persistence.*;
import java.util.List;

/**
 * by wangrongjun on 2017/6/16.
 */
@Entity
public class Goods {

    @Transient
    private Integer sellCount;

    @Id
    @GeneratedValue
    private Integer goodsId;
    private String goodsName;
    private String description;
    private Integer remainCount;// 库存
    @ManyToOne(fetch = FetchType.LAZY)
    private GoodsCategory goodsCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;//Shop外键，所属的商店
    @OneToMany
    private List<GoodsImage> goodsImageList;
    private Double price;
    @OneToMany
    private List<AttrName> attrNameList;
    @OneToMany
    private List<AttrComb> attrCombList;

    void a() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public Goods() {
    }

    public Goods(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Goods(String goodsName, String description, Integer remainCount, GoodsCategory goodsCategory, Shop shop, Double price) {
        this.goodsName = goodsName;
        this.description = description;
        this.remainCount = remainCount;
        this.goodsCategory = goodsCategory;
        this.shop = shop;
        this.price = price;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<GoodsImage> getGoodsImageList() {
        return goodsImageList;
    }

    public void setGoodsImageList(List<GoodsImage> goodsImageList) {
        this.goodsImageList = goodsImageList;
    }

    public GoodsCategory getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(GoodsCategory goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public List<AttrName> getAttrNameList() {
        return attrNameList;
    }

    public void setAttrNameList(List<AttrName> attrNameList) {
        this.attrNameList = attrNameList;
    }

    public List<AttrComb> getAttrCombList() {
        return attrCombList;
    }

    public void setAttrCombList(List<AttrComb> attrCombList) {
        this.attrCombList = attrCombList;
    }

}
