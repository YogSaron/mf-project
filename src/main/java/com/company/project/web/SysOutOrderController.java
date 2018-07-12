package com.company.project.web;

import com.alibaba.fastjson.JSON;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysOutOrder;
import com.company.project.model.SysOutOrderDetail;
import com.company.project.service.SysOutOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/sys/out/order")
public class SysOutOrderController {
    @Resource
    private SysOutOrderService sysOutOrderService;

    @PostMapping("/add")
    public Result add(SysOutOrder sysOutOrder) {
        sysOutOrderService.save(sysOutOrder);
        return ResultGenerator.genSuccessResult();
    }

    //保存订单和订单详情
    @PostMapping("/orderSave")
    public Result orderSave(String goodsList, SysOutOrder sysOutOrder) {
        System.out.println(goodsList+sysOutOrder);
        Short flag = 1;
        sysOutOrder.setFlag(flag);
        sysOutOrder.setOrderDate(new Timestamp(new Date().getTime()));
        List<SysOutOrderDetail> list = JSON.parseArray(goodsList, SysOutOrderDetail.class);
        sysOutOrderService.orderSave(sysOutOrder,list);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysOutOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysOutOrder sysOutOrder) {
        sysOutOrderService.update(sysOutOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysOutOrder sysOutOrder = sysOutOrderService.findById(id);
        return ResultGenerator.genSuccessResult(sysOutOrder);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysOutOrder> list = sysOutOrderService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
