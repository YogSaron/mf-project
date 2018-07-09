package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysUser;
import com.company.project.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Logan on 2018/7/8.
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return ResultGenerator.genFailResult("用户名或密码不能为空！");
        }
        SysUser sysUser = sysUserService.findBy("username", username);

        if( !(sysUser.getUsername().equals(username)) ){
            return ResultGenerator.genFailResult("用户名不存在");
        }
        String pwd = new String(sysUser.getPassword());
        if( !(pwd.equals(password)) ) {
            return ResultGenerator.genFailResult("密码错误");
        }
        return ResultGenerator.genSuccessResult();
    }
}
