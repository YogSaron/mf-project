package com.company.project.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "sys_in_order_detail")
public class SysInOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    private String model;

    private String quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    private BigDecimal aggregate;

    private String backup1;

    private String backup2;

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
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return unit_price
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return aggregate
     */
    public BigDecimal getAggregate() {
        return aggregate;
    }

    /**
     * @param aggregate
     */
    public void setAggregate(BigDecimal aggregate) {
        this.aggregate = aggregate;
    }

    /**
     * @return backup1
     */
    public String getBackup1() {
        return backup1;
    }

    /**
     * @param backup1
     */
    public void setBackup1(String backup1) {
        this.backup1 = backup1;
    }

    /**
     * @return backup2
     */
    public String getBackup2() {
        return backup2;
    }

    /**
     * @param backup2
     */
    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }
}