package com.company.project.service.impl;

import com.company.project.dao.SysInOrderMapper;
import com.company.project.model.SysInOrder;
import com.company.project.service.SysInOrderService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class SysInOrderServiceImpl extends AbstractService<SysInOrder> implements SysInOrderService {
    @Resource
    private SysInOrderMapper sysInOrderMapper;

}
