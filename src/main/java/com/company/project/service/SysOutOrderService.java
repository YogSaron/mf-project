package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.SysOutOrder;
import com.company.project.model.SysOutOrderDetail;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
public interface SysOutOrderService extends Service<SysOutOrder> {
    public void orderSave(SysOutOrder sysOutOrder,List<SysOutOrderDetail> list);
    public void orderUpdate(SysOutOrder sysOutOrder,List<SysOutOrderDetail> list);

    public void deleteOneEntireOrder(Integer id);//根据id 删除订单以及订单详情

    public BigDecimal getPayable(String startDate, String endDate,Integer customerId);
//    public OrderBean getEntireOrder(Integer id);//根据id找到整个order
    public List<Map> sumTotalByMonth(Integer customerId, String targetYear);
}
