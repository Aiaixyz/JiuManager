package com.aiaixyz.jiumanager.service;

import com.aiaixyz.jiumanager.entity.po.Report;
import com.aiaixyz.jiumanager.entity.vo.RespBean;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
public interface ReportService {
    RespBean addReport(Report report);

    RespBean deleteReportById(int rID);

    RespBean updateReportById(Report report);

    RespBean getReportByRId(int rId);
    RespBean getReportByUId(int uId);
    RespBean getList();
}
