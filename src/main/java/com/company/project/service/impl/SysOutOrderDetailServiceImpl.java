package com.company.project.service.impl;

import com.company.project.dao.SysOutOrderDetailMapper;
import com.company.project.model.SysOutOrderDetail;
import com.company.project.service.SysOutOrderDetailService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class SysOutOrderDetailServiceImpl extends AbstractService<SysOutOrderDetail> implements SysOutOrderDetailService {
    @Resource
    private SysOutOrderDetailMapper sysOutOrderDetailMapper;

}
