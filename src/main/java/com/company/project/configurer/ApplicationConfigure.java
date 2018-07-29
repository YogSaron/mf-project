package com.company.project.configurer;

import com.company.project.dao.SysUserMapper;
import com.company.project.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Logan on 2018/7/20.
 */
public class ApplicationConfigure implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SysUserMapper sysUserMapper;

    public  static HashMap<Integer,SysUser> userHashMap=new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {



        //把初始化参数保存redis
        System.out.println("基本参数初始化完毕");

        List<SysUser> authUsers = sysUserMapper.selectAll();
        authUsers.forEach((e)->{
            userHashMap.put(Integer.valueOf(e.getUserId()+""),e);
        });
    }
}
