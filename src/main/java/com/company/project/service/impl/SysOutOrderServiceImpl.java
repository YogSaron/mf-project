package com.company.project.service.impl;

import com.company.project.dao.SysOutOrderMapper;
import com.company.project.model.SysOutOrder;
import com.company.project.model.SysOutOrderDetail;
import com.company.project.service.SysOutOrderDetailService;
import com.company.project.service.SysOutOrderService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class SysOutOrderServiceImpl extends AbstractService<SysOutOrder> implements SysOutOrderService {
    @Resource
    private SysOutOrderMapper sysOutOrderMapper;

    @Resource
    private SysOutOrderDetailService sysOutOrderDetailService;

    @Override
    public void orderSave(SysOutOrder sysOutOrder, List<SysOutOrderDetail> list) {
        save(sysOutOrder);
        System.out.println("id:"+sysOutOrder.getId());
        Integer id = sysOutOrder.getId();
        for(SysOutOrderDetail sysOutOrderDetail:list){
            sysOutOrderDetail.setOrderId(id);
        }
        sysOutOrderDetailService.save(list);
    }
}
