package com.handsome.shop.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * by wangrongjun on 2017/6/16.
 */
@Entity
public class Evaluate {

    @Transient
    public static final int LEVEL_BAD = 0;
    @Transient
    public static final int LEVEL_NORMAL = 1;
    @Transient
    public static final int LEVEL_GOOD = 2;

    @Id
    @GeneratedValue
    private Integer evaluateId;
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdersDetail ordersDetail;//对某次购物（即一个订单明细）的评价
    private String content;//评价内容
    private Integer evaluateLevel;//评价，好评，中评，差评
    private Date createTime;//评价时间，格式：”yyyy-MM-dd HH:mm:ss”

    public Evaluate() {
    }

    public Evaluate(OrdersDetail ordersDetail, String content, Integer evaluateLevel, Date createTime) {
        this.ordersDetail = ordersDetail;
        this.content = content;
        this.evaluateLevel = evaluateLevel;
        this.createTime = createTime;
    }

    public static int getLevelBad() {
        return LEVEL_BAD;
    }

    public static int getLevelNormal() {
        return LEVEL_NORMAL;
    }

    public static int getLevelGood() {
        return LEVEL_GOOD;
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public OrdersDetail getOrdersDetail() {
        return ordersDetail;
    }

    public void setOrdersDetail(OrdersDetail ordersDetail) {
        this.ordersDetail = ordersDetail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getEvaluateLevel() {
        return evaluateLevel;
    }

    public void setEvaluateLevel(Integer evaluateLevel) {
        this.evaluateLevel = evaluateLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
