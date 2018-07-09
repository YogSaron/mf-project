package com.company.project.service.impl;

import com.company.project.dao.SysOutCusProductMapper;
import com.company.project.model.SysOutCusProduct;
import com.company.project.service.SysOutCusProductService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/07/07.
 */
@Service
@Transactional
public class SysOutCusProductServiceImpl extends AbstractService<SysOutCusProduct> implements SysOutCusProductService {
    @Resource
    private SysOutCusProductMapper sysOutCusProductMapper;

}
