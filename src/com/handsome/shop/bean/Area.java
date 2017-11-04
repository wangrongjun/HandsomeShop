package com.handsome.shop.bean;

import javax.persistence.*;
import java.util.List;

/**
 * by wangrongjun on 2017/11/3.
 */
@Entity
public class Area {

    @Id
    @GeneratedValue
    private Integer areaId;
    private String areaName;
    @ManyToOne
    private Area parent;
    @OneToMany
    private List<Area> childrenList;

    public Area() {
    }

    public Area(Integer areaId) {
        this.areaId = areaId;
    }

    public Area(String areaName, Area parent) {
        this.areaName = areaName;
        this.parent = parent;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    public List<Area> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Area> childrenList) {
        this.childrenList = childrenList;
    }
}
