package com.code.generator.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Order implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer orderuserid;

    private String bussinessid;

    private String storesid;

    private String paypassword;

    private String verificationcode;

    private BigDecimal amount;

    private BigDecimal totalamount;

    private BigDecimal price;

    private BigDecimal totalprice;

    private Integer paytype;

    private String ordernumber;

    private String serialnumber;

    private Date orderdate;

    private Integer state;

    private Integer ordertype;

    private Integer type;

    private Integer source;

    private Integer ispaypassword;

    private Integer isrebate;

    private BigDecimal businessrebate;

    private BigDecimal userrebate;

    private Date createdatetime;

    private Boolean checkState;

    private String orderdetail;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderuserid() {
        return orderuserid;
    }

    public void setOrderuserid(Integer orderuserid) {
        this.orderuserid = orderuserid;
    }

    public String getBussinessid() {
        return bussinessid;
    }

    public void setBussinessid(String bussinessid) {
        this.bussinessid = bussinessid == null ? null : bussinessid.trim();
    }

    public String getStoresid() {
        return storesid;
    }

    public void setStoresid(String storesid) {
        this.storesid = storesid == null ? null : storesid.trim();
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword == null ? null : paypassword.trim();
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode == null ? null : verificationcode.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getIspaypassword() {
        return ispaypassword;
    }

    public void setIspaypassword(Integer ispaypassword) {
        this.ispaypassword = ispaypassword;
    }

    public Integer getIsrebate() {
        return isrebate;
    }

    public void setIsrebate(Integer isrebate) {
        this.isrebate = isrebate;
    }

    public BigDecimal getBusinessrebate() {
        return businessrebate;
    }

    public void setBusinessrebate(BigDecimal businessrebate) {
        this.businessrebate = businessrebate;
    }

    public BigDecimal getUserrebate() {
        return userrebate;
    }

    public void setUserrebate(BigDecimal userrebate) {
        this.userrebate = userrebate;
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Boolean getCheckState() {
        return checkState;
    }

    public void setCheckState(Boolean checkState) {
        this.checkState = checkState;
    }

    public String getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(String orderdetail) {
        this.orderdetail = orderdetail == null ? null : orderdetail.trim();
    }
}