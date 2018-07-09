package com.company.project.service.impl;

import com.company.project.dao.SysCustomerMapper;
import com.company.project.model.SysCustomer;
import com.company.project.service.SysCustomerService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class SysCustomerServiceImpl extends AbstractService<SysCustomer> implements SysCustomerService {
    @Resource
    private SysCustomerMapper sysCustomerMapper;

}
