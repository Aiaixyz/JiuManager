package com.aiaixyz.jiumanager.dao.impl;

import com.aiaixyz.jiumanager.dao.ReportDao;
import com.aiaixyz.jiumanager.entity.po.Report;
import com.aiaixyz.jiumanager.utils.DBManager;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
public class ReportDaoImpl implements ReportDao {
    @Override
    public int addReport(Report report){
        return DBManager.commonUpdate(
                "INSERT INTO r_report(r_operation,r_note,u_id,s_sku) VALUES(?,?,?,?)",
                report.getROperation(),report.getRNote(),report.getUId(),report.getSSku()
        );
    }
    @Override
    public int deleteReportById(int rID){
        return DBManager.commonUpdate(
                "UPDATE r_report SET is_delete = 0 WHERE is_delete = 1 AND r_id = ?",
        rID);
    }
    @Override
    public int updateReportById(Report report){
        return DBManager.commonUpdate(
                "UPDATE r_report SET r_operation = ? ,r_note = ?,u_id = ?,s_sku = ? WHERE r_id = ?;",
                report.getROperation(),report.getRNote(),report.getUId(),report.getSSku(),report.getRId()
        );
    }

    @Override
    public List<Report> getReportByRId(int rId) {
        return DBManager.commonQuery(
                "Select r_id,r_date,r_operation,r_note,u_id,s_sku where is_delete = 1 and r_id = ?",
                Report.class,rId
        );
    }

    @Override
    public List<Report> getReportByUId(int uId) {
        return DBManager.commonQuery(
                "Select r_id,r_date,r_operation,r_note,u_id,s_sku where is_delete = 1 and u_id = ?",
                Report.class,uId
        );
    }

    @Override
    public List<Report> getList() {
        return DBManager.commonQuery(
                "Select r_id,r_date,r_operation,r_note,u_id,s_sku where is_delete = 1",
                Report.class
        );
    }


}
