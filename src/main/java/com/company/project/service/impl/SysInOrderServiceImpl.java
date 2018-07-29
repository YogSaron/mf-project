package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.SysInOrderDetailMapper;
import com.company.project.dao.SysInOrderMapper;
import com.company.project.model.SysInOrder;
import com.company.project.model.SysInOrderDetail;
import com.company.project.service.SysInOrderDetailService;
import com.company.project.service.SysInOrderService;
import com.company.project.utils.beans.InOrderList;
import com.company.project.utils.beans.OrderList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public void deleteOneEntireOrder(Integer id) {
        deleteById(id);
        Condition condition = new Condition(SysInOrderDetail.class);
        condition.createCriteria().andEqualTo("orderId",id);
        sysInOrderDetailMapper.deleteByCondition(condition);
    }

    @Override
    public BigDecimal getPayable(String sd, String ed, Integer customerId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal tl = new BigDecimal(0);
        Date startDate = null;
        Date endDate = null;
        if (customerId < 0) {
            customerId = null;
        }
        try {
            if(StringUtils.isNotBlank(sd)){
                startDate= format.parse(sd);
            }
            if(StringUtils.isNotBlank(ed)){
                endDate = format.parse(ed);
            }
            tl = sysInOrderMapper.getPayable(startDate,endDate,customerId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tl;
    }

    @Override
    public List<InOrderList> getEntireList(Date startDate, Date endDate, Integer customerId) {
        List<InOrderList> list = sysInOrderMapper.getEntireList(startDate, endDate, customerId);
        return list;
    }
}
