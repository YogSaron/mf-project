package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.SysOutOrderDetailMapper;
import com.company.project.dao.SysOutOrderMapper;
import com.company.project.model.SysOutOrder;
import com.company.project.model.SysOutOrderDetail;
import com.company.project.service.SysOutOrderDetailService;
import com.company.project.service.SysOutOrderService;
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
public class SysOutOrderServiceImpl extends AbstractService<SysOutOrder> implements SysOutOrderService {
    @Resource
    private SysOutOrderMapper sysOutOrderMapper;
    @Resource
    private SysOutOrderDetailMapper sysOutOrderDetailMapper;

    @Resource
    private SysOutOrderDetailService sysOutOrderDetailService;

    @Override
    public void orderSave(SysOutOrder sysOutOrder, List<SysOutOrderDetail> list) {
        save(sysOutOrder);
        Integer id = sysOutOrder.getId();
        for(SysOutOrderDetail sysOutOrderDetail:list){
            sysOutOrderDetail.setOrderId(id);
        }
        sysOutOrderDetailService.save(list);
    }
    @Override
    public void orderUpdate(SysOutOrder sysOutOrder, List<SysOutOrderDetail> list) {
        update(sysOutOrder);
        Integer id = sysOutOrder.getId();
        Condition condition = new Condition(SysOutOrderDetail.class);
        condition.createCriteria().andEqualTo("orderId", id);
        sysOutOrderDetailMapper.deleteByCondition(condition);
        for(SysOutOrderDetail sysOutOrderDetail:list){
            sysOutOrderDetail.setOrderId(id);
        }
        sysOutOrderDetailService.save(list);
    }

    @Override
    public void deleteOneEntireOrder(Integer id) {

        Condition condition = new Condition(SysOutOrderDetail.class);
        condition.createCriteria().andEqualTo("orderId",id);
        deleteById(id);
        sysOutOrderDetailMapper.deleteByCondition(condition);
    }

    @Override
    public BigDecimal getPayable(String sd, String ed) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal tl = new BigDecimal(0);
        try {
            Date startDate = format.parse(sd);
            Date endDate = format.parse(ed);
            tl = sysOutOrderMapper.getPayable(startDate,endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tl;
    }
}
