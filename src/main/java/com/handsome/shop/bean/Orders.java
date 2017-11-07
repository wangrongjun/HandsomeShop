package com.handsome.shop.bean;


import javax.persistence.*;
import java.util.Date;

/**
 * by wangrongjun on 2017/6/16.
 */
@Entity
public class Orders {

    @Transient
    public static final int STATE_CONTINUE = 0;// 交易中
    @Transient
    public static final int STATE_SUCCEED = 1;// 交易成功
    @Transient
    public static final int STATE_FAILED = 2;// 交易失败

    @Id
    @GeneratedValue
    private Integer ordersId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    private Double totalPrice;//该订单的总价格（打折后，含运费）
    private Double freight;// 运费
    private String note;// 顾客备注信息
    private String receiverPhone;//收货人的联系电话
    private String receiverName;//收货人的姓名
    private String address;//收货人的收货地址（不使用外键，避免下单后客户修改收货地址导致出错）
    private Date createTime;//订单创建时间，格式：”yyyy-MM-dd HH:mm:ss”
    private Integer state;//订单状态，进行中，关闭，成功

    public Orders() {
    }

    public Orders(Customer customer, Double totalPrice, String note, String receiverPhone, String receiverName, String address, Date createTime, Integer state) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.note = note;
        this.receiverPhone = receiverPhone;
        this.receiverName = receiverName;
        this.address = address;
        this.createTime = createTime;
        this.state = state;
    }

    public static int getStateContinue() {
        return STATE_CONTINUE;
    }

    public static int getStateSucceed() {
        return STATE_SUCCEED;
    }

    public static int getStateFailed() {
        return STATE_FAILED;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }
}
