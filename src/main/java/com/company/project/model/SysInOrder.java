package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_in_order")
public class SysInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "receipt_address")
    private String receiptAddress;

    @Column(name = "receipt_date")
    private Date receiptDate;

    @Column(name = "material_type")
    private String materialType;

    @Column(name = "account_payable")
    private BigDecimal accountPayable;

    @Column(name = "account_paid")
    private BigDecimal accountPaid;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    private String remark;

    @Column(name = "order_date")
    private Date orderDate;

    private Short flag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return customer_id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @return customer_name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return receipt_address
     */
    public String getReceiptAddress() {
        return receiptAddress;
    }

    /**
     * @param receiptAddress
     */
    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    /**
     * @return receipt_date
     */
    public Date getReceiptDate() {
        return receiptDate;
    }

    /**
     * @param receiptDate
     */
    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    /**
     * @return material_type
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * @param materialType
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    /**
     * @return account_payable
     */
    public BigDecimal getAccountPayable() {
        return accountPayable;
    }

    /**
     * @param accountPayable
     */
    public void setAccountPayable(BigDecimal accountPayable) {
        this.accountPayable = accountPayable;
    }

    /**
     * @return account_paid
     */
    public BigDecimal getAccountPaid() {
        return accountPaid;
    }

    /**
     * @param accountPaid
     */
    public void setAccountPaid(BigDecimal accountPaid) {
        this.accountPaid = accountPaid;
    }

    /**
     * @return total_amount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return order_date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return flag
     */
    public Short getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Short flag) {
        this.flag = flag;
    }
}