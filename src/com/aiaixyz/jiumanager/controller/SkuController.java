package com.aiaixyz.jiumanager.controller;

import com.aiaixyz.jiumanager.entity.po.Sku;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.ReportService;
import com.aiaixyz.jiumanager.service.SkuService;
import com.aiaixyz.jiumanager.service.impl.ReportServiceImpl;
import com.aiaixyz.jiumanager.service.impl.SkuServiceImpl;
import com.aiaixyz.jiumanager.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/14
 */
//getBeanBySku,countName,updateBeanBySku,deleteBeanBySku,addBean,getList
@WebServlet("/SkuController")
public class SkuController extends BaseServlet {
    public Sku getSkuObj(HttpServletRequest req){
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int dId = Integer.parseInt(req.getParameter("dId"));
        int vId = Integer.parseInt(req.getParameter("vId"));
        return new Sku(name,quantity,dId,vId);
    }

    SkuService<Sku> skuService = new SkuServiceImpl();
    ReportService reportService = new ReportServiceImpl();

    protected RespBean getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return skuService.getList();
    }

    protected RespBean countName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        return skuService.countName(name);
    }

    protected RespBean updateBeanBySku(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return skuService.updateBeanBySku(getSkuObj(req));
    }

    protected RespBean deleteBeanBySku(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return skuService.deleteBeanBySku(Integer.parseInt(req.getParameter("sku")));
    }

    protected RespBean addBean(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return skuService.addBean(getSkuObj(req));
    }

    protected RespBean getBeanBySku(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return skuService.getBeanBySku(Integer.parseInt(req.getParameter("sku")));
    }

    protected RespBean inSkuQuantity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return skuService.inSkuQuantity(Integer.parseInt(req.getParameter("sku")),Integer.parseInt(req.getParameter("num")));
    }

    protected RespBean outSkuQuantity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return skuService.outSkuQuantity(Integer.parseInt(req.getParameter("sku")),Integer.parseInt(req.getParameter("num")));
    }

}
