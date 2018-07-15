package com.company.project.service.impl;

import com.company.project.dao.SysInOrderDetailMapper;
import com.company.project.dao.SysInOrderMapper;
import com.company.project.model.SysInOrder;
import com.company.project.model.SysInOrderDetail;
import com.company.project.service.SysInOrderDetailService;
import com.company.project.service.SysInOrderService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class SysInOrderServiceImpl extends AbstractService<SysInOrder> implements SysInOrderService {
    @Resource
    private SysInOrderMapper sysInOrderMapper;

    @Resource
    private SysInOrderDetailMapper sysInOrderDetailMapper;

    @Resource
    private SysInOrderDetailService sysInOrderDetailService;

    @Override
    public void orderSave(SysInOrder sysInOrder, List<SysInOrderDetail> list) {
        save(sysInOrder);
        int thisId = sysInOrder.getId();
        for (SysInOrderDetail sysInOrderDetail : list) {
            sysInOrderDetail.setOrderId(thisId);
        }
        sysInOrderDetailService.save(list);
    }

    @Override
    public void orderUpdate(SysInOrder sysInOrder, List<SysInOrderDetail> list) {
        update(sysInOrder);
        int thisId = sysInOrder.getId();
        Condition condition = new Condition(SysInOrderDetail.class);
        condition.createCriteria().andEqualTo("orderId",thisId);
        sysInOrderDetailMapper.deleteByCondition(condition);
        for (SysInOrderDetail sysInOrderDetail:list) {
            sysInOrderDetail.setOrderId(thisId);
        }
        sysInOrderDetailService.save(list);
    }
}
