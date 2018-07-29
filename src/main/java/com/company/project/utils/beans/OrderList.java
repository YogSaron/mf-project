package com.company.project.utils.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Logan on 2018/7/28.
 */
public class OrderList implements Serializable{

    private Integer id;

    private Integer customerId;

    private String customerName;

    private Date deliveryDate;

    private String deliveryAddress;

    private BigDecimal accountPayable;

    private BigDecimal accountPaid;

    private BigDecimal totalAmount;

    private String remark;

    private Date orderDate;

    private Short flag;


    private Integer orderId;

    private String model;

    private String packaging;

    private String quantity;

    private BigDecimal unitPrice;

    private BigDecimal aggregate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public BigDecimal getAccountPayable() {
        return accountPayable;
    }

    public void setAccountPayable(BigDecimal accountPayable) {
        this.accountPayable = accountPayable;
    }

    public BigDecimal getAccountPaid() {
        return accountPaid;
    }

    public void setAccountPaid(BigDecimal accountPaid) {
        this.accountPaid = accountPaid;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAggregate() {
        return aggregate;
    }

    public void setAggregate(BigDecimal aggregate) {
        this.aggregate = aggregate;
    }
}
