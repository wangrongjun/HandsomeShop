package com.handsome.shop.bean;

import javax.persistence.*;
import java.util.List;

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
    private String categoryPath;// 路径，例如当前分类是食品下的饮料，就是 "/食品id/饮料id/"
    private Integer categoryDepth;// 深度，从1开始

    public GoodsCategory() {
    }

    public GoodsCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public GoodsCategory(String name, GoodsCategory superCategory, String categoryPath, Integer categoryDepth) {
        this.name = name;
        this.superCategory = superCategory;
        this.categoryPath = categoryPath;
        this.categoryDepth = categoryDepth;
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

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public Integer getCategoryDepth() {
        return categoryDepth;
    }

    public void setCategoryDepth(Integer categoryDepth) {
        this.categoryDepth = categoryDepth;
    }
}
