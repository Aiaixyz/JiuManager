package com.aiaixyz.jiumanager.dao;

import com.aiaixyz.jiumanager.entity.po.Report;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
public interface ReportDao {

    int addReport(Report report);

    int deleteReportById(int rID);

    int updateReportById(Report report);

    List<Report> getReportByRId(int rId);
    List<Report> getReportByUId(int uId);
    List<Report> getList();
}
