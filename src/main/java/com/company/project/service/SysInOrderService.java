package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.SysInOrder;
import com.company.project.model.SysInOrderDetail;
import com.company.project.utils.beans.InOrderList;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
public interface SysInOrderService extends Service<SysInOrder> {

    public void orderSave(SysInOrder sysInOrder, List<SysInOrderDetail> list);

    public void orderUpdate(SysInOrder sysInOrder, List<SysInOrderDetail> list);

    public void deleteOneEntireOrder(Integer id);

    public BigDecimal getPayable(String startDate,String endDate,Integer customerId);

    public List<InOrderList> getEntireList(Date startDate, Date endDate, Integer customerId);

}
