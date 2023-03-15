package com.aiaixyz.jiumanager.controller;

import com.aiaixyz.jiumanager.entity.po.Vendors;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.VendorsService;
import com.aiaixyz.jiumanager.service.impl.VendorsServiceImpl;
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

@WebServlet("/VendorsController")
public class VendorsController extends BaseServlet {
    //Service方法列表:addBean,getIdByName,deleteBeanById,updateBeanById,getBeanById,getBeanByName,getList,getPhoneByName,getAddressByName
    VendorsService vendorsService = new VendorsServiceImpl();

    public Vendors getVendorsObj(HttpServletRequest req,Integer id){
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        return new Vendors(id,name,phone,address);
    }

    protected RespBean addBean(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.addBean(getVendorsObj(req,null));
    }

    protected RespBean getIdByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.getIdByName(req.getParameter("name"));
    }

    protected RespBean deleteBeanById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.deleteBeanById(Integer.parseInt(req.getParameter("id")));
    }

    protected RespBean updateBeanById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.updateBeanById(getVendorsObj(req,Integer.parseInt(req.getParameter("id"))));
    }

    protected RespBean getBeanById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.getBeanById(Integer.parseInt(req.getParameter("id")));
    }

    protected RespBean getBeanByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.getBeanByName(req.getParameter("name"));
    }

    protected RespBean getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.getList();
    }

    protected RespBean getPhoneByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.getPhoneByName(req.getParameter("name"));
    }

    protected RespBean getAddressByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return vendorsService.getAddressByName(req.getParameter("name"));
    }

}
