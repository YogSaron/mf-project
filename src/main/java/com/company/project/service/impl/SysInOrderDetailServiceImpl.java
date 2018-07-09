package com.company.project.service.impl;

import com.company.project.dao.SysInOrderDetailMapper;
import com.company.project.model.SysInOrderDetail;
import com.company.project.service.SysInOrderDetailService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class SysInOrderDetailServiceImpl extends AbstractService<SysInOrderDetail> implements SysInOrderDetailService {
    @Resource
    private SysInOrderDetailMapper sysInOrderDetailMapper;

}
