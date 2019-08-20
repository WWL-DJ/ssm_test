package com.itheima.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 王磊
 * @Date 2019/8/13/013
 */
public class Product {

    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime; // 出发时间  2019-08-13 11:50
    private String departureTimeStr ;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr ;

    /**
     * 出发时间 的逻辑视图
     * @return
     */
    public String getProductStatusStr() {
        productStatusStr = "";
        if(productStatus==0){
            productStatusStr = "关闭";
        }

        if(productStatus==1){
            productStatusStr = "开启";
        }

        return productStatusStr;
    }

    /**
     * 出发时间 的逻辑视图
     * @return
     */
    public String getDepartureTimeStr() {
        departureTimeStr = "" ;
        if(departureTime!=null){
            departureTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(departureTime);
        }

        return departureTimeStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
}
