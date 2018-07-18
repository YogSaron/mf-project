package com.company.project.utils.beans;

import java.io.Serializable;

/**
 * Created by Logan on 2018/7/13.
 */
public class OrderBean implements Serializable
{
    private String goodsList;
    private String Order;

    public String getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = goodsList;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }
}
