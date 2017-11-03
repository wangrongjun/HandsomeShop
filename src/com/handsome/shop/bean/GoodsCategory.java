package com.handsome.shop.bean;

import javax.persistence.*;

/**
 * by wangrongjun on 2017/6/18.
 */
@Entity
public class GoodsCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    private GoodsCategory superCategory;// 上级分类

    public GoodsCategory() {
    }

    public GoodsCategory(String name, GoodsCategory superCategory) {
        this.name = name;
        this.superCategory = superCategory;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer goodsTypeId) {
        this.categoryId = goodsTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoodsCategory getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(GoodsCategory superCategory) {
        this.superCategory = superCategory;
    }
}
