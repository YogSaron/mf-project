package com.company.project.utils.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Logan on 2018/7/18.
 */
public class sumBean implements Serializable {
    private Integer numIndex;
    private BigDecimal totalAmount;

    public Integer getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(Integer numIndex) {
        this.numIndex = numIndex;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
