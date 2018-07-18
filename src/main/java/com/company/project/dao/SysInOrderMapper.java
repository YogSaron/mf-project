package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.SysInOrder;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;

public interface SysInOrderMapper extends Mapper<SysInOrder> {
    public BigDecimal getPayable(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("customerId")Integer customerId);

}