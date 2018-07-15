package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.SysOutOrder;

import java.math.BigDecimal;
import java.util.Date;

public interface SysOutOrderMapper extends Mapper<SysOutOrder> {
    public BigDecimal getPayable(Date startDate, Date endDate);
}