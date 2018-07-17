package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.SysOutOrder;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;

public interface SysOutOrderMapper extends Mapper<SysOutOrder> {
    public BigDecimal getPayable(@Param("startDate")Date startDate, @Param("endDate")Date endDate,@Param("customerId")Integer customerId);
}