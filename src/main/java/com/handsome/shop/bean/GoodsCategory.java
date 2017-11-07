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
    @OneToMany
    private List<GoodsCategory> children;// 下级分类列表

    public GoodsCategory() {
    }

    public GoodsCategory(Integer categoryId) {
        this.categoryId = categoryId;
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

    public List<GoodsCategory> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsCategory> children) {
        this.children = children;
    }
}
