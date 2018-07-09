package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.SysUserMapper;
import com.company.project.model.SysUser;
import com.company.project.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Logan on 2018/7/8.
 */
@Service
@Transactional
public class LoginServiceImpl extends AbstractService<SysUser>  implements LoginService{

    @Autowired
    private SysUserMapper sysUserMapper;
}
