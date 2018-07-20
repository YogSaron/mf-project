package com.company.project.web;

import com.alibaba.fastjson.JSON;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysOutOrder;
import com.company.project.model.SysOutOrderDetail;
import com.company.project.service.SysOutOrderDetailService;
import com.company.project.service.SysOutOrderService;
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
import java.util.Map;

/**
* Created by CodeGenerator on 2018/07/07.
*/
@RestController
@RequestMapping("/sys/out/order")
public class SysOutOrderController {
    @Resource
    private SysOutOrderService sysOutOrderService;

    @Resource
    private SysOutOrderDetailService sysOutOrderDetailService;

    @PostMapping("/add")
    public Result add(SysOutOrder sysOutOrder) {
        sysOutOrderService.save(sysOutOrder);
        return ResultGenerator.genSuccessResult();
    }

    //保存订单和订单详情
    @PostMapping("/orderSave")
    public Result orderSave(String goodsList, String sysOutOrder) {
        SysOutOrder order = JSON.parseObject(sysOutOrder, SysOutOrder.class);
        Short flag = 1;
        order.setFlag(flag);
        order.setOrderDate(new Timestamp(new Date().getTime()));
        List<SysOutOrderDetail> list = JSON.parseArray(goodsList, SysOutOrderDetail.class);
        sysOutOrderService.orderSave(order,list);
        return ResultGenerator.genSuccessResult();
    }


    //出货付款
    @PostMapping("/paymentSave")
    public Result paymentSave(SysOutOrder sysOutOrder) {
        Short flag = 2;
        sysOutOrder.setFlag(flag);
        sysOutOrder.setOrderDate(new Timestamp(new Date().getTime()));
        sysOutOrderService.save(sysOutOrder);
        return ResultGenerator.genSuccessResult();
    }



    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysOutOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    //删除订单所有数据
    @PostMapping("/deleteOneOrder")
    public Result deleteOneOrder(@RequestParam Integer id) {
        sysOutOrderService.deleteOneEntireOrder(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/orderUpdate")
    public Result update(String goodsList, String sysOutOrder) {
        SysOutOrder order = JSON.parseObject(sysOutOrder, SysOutOrder.class);
        Short flag = 1;
        order.setFlag(flag);
        order.setOrderDate(new Timestamp(new Date().getTime()));
        List<SysOutOrderDetail> list = JSON.parseArray(goodsList, SysOutOrderDetail.class);
        sysOutOrderService.orderUpdate(order,list);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysOutOrder sysOutOrder = sysOutOrderService.findById(id);
        return ResultGenerator.genSuccessResult(sysOutOrder);
    }
    //根据id查找订单
    @GetMapping("/detailById")
    public Result detailById(@RequestParam Integer id) {
        SysOutOrder sysOutOrder = sysOutOrderService.findById(id);
        Condition condition = new Condition(SysOutOrderDetail.class);
        condition.createCriteria().andEqualTo("orderId",id);
        List<SysOutOrderDetail> list = sysOutOrderDetailService.findByCondition(condition);
        OrderBean orderBean = new OrderBean();
        orderBean.setGoodsList(JSON.toJSONString(list));
        orderBean.setOrder(JSON.toJSONString(sysOutOrder));
        return ResultGenerator.genSuccessResult(orderBean);
    }

    //根据客户id查找订单列表
    @GetMapping("/detailByCustomerId")
    public Result detailByCustomerId(@RequestParam Integer customerId,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,String flag, String startDate,String endDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        PageHelper.startPage(page, size);
        Condition condition = new Condition(SysOutOrder.class);
        Example.Criteria criteria = condition.createCriteria();
        if(customerId >= 0){
            criteria.andEqualTo("customerId",customerId);
        }

        try {
            if(StringUtils.isNotBlank(startDate)) {
                Date sd = format.parse(startDate);
                criteria.andGreaterThan("deliveryDate",sd);
            }
            if(StringUtils.isNotBlank(endDate)) {
                Date ed = format.parse(endDate);
                criteria.andLessThanOrEqualTo("deliveryDate",ed);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(StringUtils.isNotBlank(flag)) {
            criteria.andEqualTo("flag",Short.valueOf(flag));
        }
        condition.setOrderByClause("delivery_date DESC");
        List<SysOutOrder> list = sysOutOrderService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,String flag) {
        PageHelper.startPage(page, size);
        Condition condition = new Condition(SysOutOrder.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("flag",Short.valueOf(flag));
        condition.setOrderByClause("order_date DESC");
        List<SysOutOrder> list = sysOutOrderService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/getSumAmount")
    public Result getSum(String startDate,String endDate,Integer customerId) {
        BigDecimal bg = sysOutOrderService.getPayable(startDate,endDate,customerId);
        return ResultGenerator.genSuccessResult(bg);
    }

    @PostMapping("/sumByMonth")
    public Result sumByMonth(Integer customerId,String targetYear) {
        List<Map> list = sysOutOrderService.sumTotalByMonth(customerId,targetYear);
        return ResultGenerator.genSuccessResult(list);
    }
}
