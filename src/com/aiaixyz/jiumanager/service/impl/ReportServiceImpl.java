package com.aiaixyz.jiumanager.service.impl;

import com.aiaixyz.jiumanager.dao.ReportDao;
import com.aiaixyz.jiumanager.dao.impl.ReportDaoImpl;
import com.aiaixyz.jiumanager.entity.po.Report;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.ReportService;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
public class ReportServiceImpl implements ReportService {
    ReportDao reportDao = new ReportDaoImpl();
    @Override
    public RespBean addReport(Report report) {
        if (reportDao.addReport(report)!=1){
            return RespBean.respError("添加失败",null);
        }return RespBean.respError("添加成功",null);
    }

    @Override
    public RespBean deleteReportById(int rID) {
        if (reportDao.deleteReportById(rID)!=1){
            return RespBean.respError("删除失败",null);
        }return RespBean.respSuccess("删除成功",null);
    }

    @Override
    public RespBean updateReportById(Report report) {
        if (reportDao.updateReportById(report)!=1){
            return RespBean.respError("修改失败",null);
        }return RespBean.respSuccess("添加成功",null);
    }

    @Override
    public RespBean getReportByRId(int rId) {
        List<Report> list = reportDao.getReportByRId(rId);
        if (!list.isEmpty()){
            if (list.get(0).getRId()>0){
                return RespBean.respSuccess("获取成功",list.get(0));
            }
        }return RespBean.respError("获取失败",null);
    }

    @Override
    public RespBean getReportByUId(int uId) {
        List<Report> list = reportDao.getReportByUId(uId);
        if (!list.isEmpty()){
            if (list.get(0).getRId()>0){
                return RespBean.respSuccess("获取成功",list.get(0));
            }
        }return RespBean.respError("获取失败",null);
    }

    @Override
    public RespBean getList() {
        List<Report> list = reportDao.getList();
        if (!list.isEmpty()){
                return RespBean.respSuccess("获取成功",list);
        }return RespBean.respError("获取失败",null);
    }
}
