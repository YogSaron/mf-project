package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysOutCusProduct;
import com.company.project.service.SysOutCusProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/sys/out/cus/product")
public class SysOutCusProductController {
    @Resource
    private SysOutCusProductService sysOutCusProductService;

    @PostMapping("/add")
    public Result add(SysOutCusProduct sysOutCusProduct) {
        sysOutCusProductService.save(sysOutCusProduct);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysOutCusProductService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysOutCusProduct sysOutCusProduct) {
        sysOutCusProductService.update(sysOutCusProduct);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysOutCusProduct sysOutCusProduct = sysOutCusProductService.findById(id);
        return ResultGenerator.genSuccessResult(sysOutCusProduct);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysOutCusProduct> list = sysOutCusProductService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }



    @GetMapping("/listByParentId")
    public Result listByParentId(@RequestParam Integer parentId){
        Condition condition = new Condition(SysOutCusProduct.class);
        condition.createCriteria().andEqualTo("parentId", parentId);
        List<SysOutCusProduct> list = sysOutCusProductService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
