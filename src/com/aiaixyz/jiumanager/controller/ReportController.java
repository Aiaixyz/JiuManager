package com.aiaixyz.jiumanager.controller;

import com.aiaixyz.jiumanager.entity.po.Report;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.ReportService;
import com.aiaixyz.jiumanager.service.impl.ReportServiceImpl;
import com.aiaixyz.jiumanager.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */

@WebServlet("/ReportController")
public class ReportController extends BaseServlet {
    ReportService reportService = new ReportServiceImpl();

    /**
     * 获取请求中的对象
     * @return Report对象
     */
    public Report getReportObj(HttpServletRequest req,Integer rid){
        String operation = req.getParameter("Operation");
        String note = req.getParameter("Note");
        Integer uid = Integer.parseInt(req.getParameter("uid"));
        Integer sku = Integer.parseInt(req.getParameter("sku"));
        return new Report(rid,operation,note,uid,sku);
    }

    //添加Report
    protected RespBean addReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return reportService.addReport(getReportObj(req,null));
    }

    //删除Report
    protected RespBean deleteReportById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return reportService.deleteReportById(Integer.parseInt(req.getParameter("rid")));
    }

    //修改Report
    protected RespBean updateReportById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return reportService.updateReportById(getReportObj(req,Integer.parseInt(req.getParameter("rid"))));
    }

    //使用rId获取Report
    protected RespBean getReportByRId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return reportService.getReportByRId(Integer.parseInt(req.getParameter("rid")));
    }

    //使用uId获取Report
    protected RespBean getReportByUId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return reportService.getReportByUId(Integer.parseInt(req.getParameter("uid")));
    }

    //获取所有Report
    protected RespBean getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return reportService.getList();
    }
}
