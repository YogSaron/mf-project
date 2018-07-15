package com.company.project.service;
import com.company.project.model.SysInOrder;
import com.company.project.core.Service;
import com.company.project.model.SysInOrderDetail;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
public interface SysInOrderService extends Service<SysInOrder> {

    public void orderSave(SysInOrder sysInOrder, List<SysInOrderDetail> list);

    public void orderUpdate(SysInOrder sysInOrder, List<SysInOrderDetail> list);
}
