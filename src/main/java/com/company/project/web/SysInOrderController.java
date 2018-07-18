package com.company.project.web;

import com.alibaba.fastjson.JSON;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysInOrder;
import com.company.project.model.SysInOrderDetail;
import com.company.project.service.SysInOrderDetailService;
import com.company.project.service.SysInOrderService;
import com.company.project.utils.beans.OrderBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/sys/in/order")
public class SysInOrderController {
    @Resource
    private SysInOrderService sysInOrderService;

    @Resource
    private SysInOrderDetailService sysInOrderDetailService;

    @PostMapping("/add")
    public Result add(SysInOrder sysInOrder) {
        sysInOrderService.save(sysInOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysInOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysInOrder sysInOrder) {
        sysInOrderService.update(sysInOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysInOrder sysInOrder = sysInOrderService.findById(id);
        return ResultGenerator.genSuccessResult(sysInOrder);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysInOrder> list = sysInOrderService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    //保存订单和订单详情
    @PostMapping("/orderSave")
    public Result orderSave(String goodsList, String sysInOrder) {
        SysInOrder order = JSON.parseObject(sysInOrder, SysInOrder.class);
        Short flag = 1;
        order.setFlag(flag);
        String str = order.getMaterialType();
        String origi = str.substring(1,str.length()-1).replace("\"","");
        order.setMaterialType(origi);
        order.setOrderDate(new Timestamp(new Date().getTime()));
        List<SysInOrderDetail> list = JSON.parseArray(goodsList, SysInOrderDetail.class);
        sysInOrderService.orderSave(order,list);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/orderUpdate")
    public Result update(String goodsList, String sysInOrder) {
        SysInOrder order = JSON.parseObject(sysInOrder, SysInOrder.class);
        Short flag = 1;
        order.setFlag(flag);
        order.setOrderDate(new Timestamp(new Date().getTime()));
        List<SysInOrderDetail> list = JSON.parseArray(goodsList, SysInOrderDetail.class);
        sysInOrderService.orderUpdate(order,list);
        return ResultGenerator.genSuccessResult();
    }

    //根据客户id查找订单列表
    @GetMapping("/detailByCustomerId")
    public Result detailByCustomerId(@RequestParam Integer customerId,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,String flag, String startDate,String endDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        PageHelper.startPage(page, size);
        Condition condition = new Condition(SysInOrder.class);
        Example.Criteria criteria = condition.createCriteria();
        if(customerId >= 0){
            criteria.andEqualTo("customerId",customerId);
        }

        try {
            if(StringUtils.isNotBlank(startDate)) {
                Date sd = format.parse(startDate);
                criteria.andGreaterThan("receiptDate",sd);
            }
            if(StringUtils.isNotBlank(endDate)) {
                Date ed = format.parse(endDate);
                criteria.andLessThanOrEqualTo("receiptDate",ed);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isNotBlank(flag)) {
            criteria.andEqualTo("flag",Short.valueOf(flag));
        }
        condition.setOrderByClause("receipt_date DESC");
        List<SysInOrder> list = sysInOrderService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/detailById")
    public Result detailById(@RequestParam Integer id) {
        SysInOrder sysInOrder = sysInOrderService.findById(id);
        Condition condition = new Condition(SysInOrderDetail.class);
        condition.createCriteria().andEqualTo("orderId",id);
        List<SysInOrderDetail> list = sysInOrderDetailService.findByCondition(condition);
        OrderBean orderBean = new OrderBean();
        orderBean.setGoodsList(JSON.toJSONString(list));
        orderBean.setOrder(JSON.toJSONString(sysInOrder));
        return ResultGenerator.genSuccessResult(orderBean);
    }

    //删除订单所有数据
    @PostMapping("/deleteOneOrder")
    public Result deleteOneOrder(@RequestParam Integer id) {
        sysInOrderService.deleteOneEntireOrder(id);
        return ResultGenerator.genSuccessResult();
    }


    @PostMapping("/getSumAmount")
    public Result getSum(String startDate,String endDate,Integer customerId) {
        BigDecimal bg = sysInOrderService.getPayable(startDate,endDate,customerId);
        return ResultGenerator.genSuccessResult(bg);
    }

    //出货付款
    @PostMapping("/paymentSave")
    public Result paymentSave(SysInOrder sysInOrder) {
        Short flag = 2;
        sysInOrder.setFlag(flag);
        sysInOrder.setOrderDate(new Timestamp(new Date().getTime()));
        sysInOrderService.save(sysInOrder);
        return ResultGenerator.genSuccessResult();
    }
}
