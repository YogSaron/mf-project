package com.company.project.service;
import com.company.project.model.SysOutOrder;
import com.company.project.core.Service;
import com.company.project.model.SysOutOrderDetail;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
public interface SysOutOrderService extends Service<SysOutOrder> {
    public void orderSave(SysOutOrder sysOutOrder,List<SysOutOrderDetail> list);
}
