package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysCustomer;
import com.company.project.service.SysCustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/sys/customer")
public class SysCustomerController {
    @Resource
    private SysCustomerService sysCustomerService;

    @PostMapping("/add")
    public Result add(SysCustomer sysCustomer) {
        Timestamp t = new Timestamp(new Date().getTime());
        sysCustomer.setCreateTime(t);
        sysCustomerService.save(sysCustomer);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysCustomerService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysCustomer sysCustomer) {
        sysCustomerService.update(sysCustomer);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysCustomer sysCustomer = sysCustomerService.findById(id);
        return ResultGenerator.genSuccessResult(sysCustomer);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysCustomer> list = sysCustomerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/type/list")
    public  Result listByType(Integer type) {
        Condition condition = new Condition(SysCustomer.class);
        condition.createCriteria().andEqualTo("type",type);
        condition.setOrderByClause("customer_name ASC");
        List<SysCustomer> list = sysCustomerService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
