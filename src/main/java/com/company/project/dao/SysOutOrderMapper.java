package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.SysOutOrder;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysOutOrderMapper extends Mapper<SysOutOrder> {
    public BigDecimal getPayable(@Param("startDate")Date startDate, @Param("endDate")Date endDate,@Param("customerId")Integer customerId);

    public List<Map> sumByMonth(@Param("customerId") Integer customerId, @Param("targetYear") String targetYear);

    public List<Map> getAmounInfo(@Param("year") String year);
}