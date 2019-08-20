package com.itheima.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {

    private String id;
    private String orderNum;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;

    private int peopleCount;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    //建立实体之间的映射关系
    private Product product;
    private Member member;
    private List<Traveller> travellers;

    //逻辑视图
    public String getPayTypeStr() {
        payTypeStr = "";
        if (payType == 0){
            payTypeStr = "支付宝";
        }
        if (payType == 1){
            payTypeStr = "微信";
        }
        return payTypeStr;
    }

    public String getOrderTimeStr() {
        orderTimeStr = "";
        if (orderTime!=null){
            orderTimeStr = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(orderTime);
        }
        return orderTimeStr;
    }

    public String getOrderStatusStr() {
        orderStatusStr = "";
        if (orderStatus == 1){
            orderStatusStr = "正常";
        }
        if (orderStatus == 0){
            orderStatusStr = "关闭";
        }
        return orderStatusStr;
    }

    public Member getMember() {
        return member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Product getProduct() {
        return product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }


    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }


    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", product=" + product +
                ", member=" + member +
                ", travellers=" + travellers +
                '}';
    }
}
