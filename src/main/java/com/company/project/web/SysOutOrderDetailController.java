package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysOutOrderDetail;
import com.company.project.service.SysOutOrderDetailService;
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
@RequestMapping("/sys/out/order/detail")
public class SysOutOrderDetailController {
    @Resource
    private SysOutOrderDetailService sysOutOrderDetailService;

    @PostMapping("/add")
    public Result add(SysOutOrderDetail sysOutOrderDetail) {
        sysOutOrderDetailService.save(sysOutOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysOutOrderDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysOutOrderDetail sysOutOrderDetail) {
        sysOutOrderDetailService.update(sysOutOrderDetail);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysOutOrderDetail sysOutOrderDetail = sysOutOrderDetailService.findById(id);
        return ResultGenerator.genSuccessResult(sysOutOrderDetail);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysOutOrderDetail> list = sysOutOrderDetailService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
