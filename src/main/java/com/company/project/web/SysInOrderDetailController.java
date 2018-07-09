package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysInOrderDetail;
import com.company.project.service.SysInOrderDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/sys/in/order/detail")
public class SysInOrderDetailController {
    @Resource
    private SysInOrderDetailService sysInOrderDetailService;

    @PostMapping("/add")
    public Result add(SysInOrderDetail sysInOrderDetail) {
        sysInOrderDetailService.save(sysInOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysInOrderDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysInOrderDetail sysInOrderDetail) {
        sysInOrderDetailService.update(sysInOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysInOrderDetail sysInOrderDetail = sysInOrderDetailService.findById(id);
        return ResultGenerator.genSuccessResult(sysInOrderDetail);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysInOrderDetail> list = sysInOrderDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
