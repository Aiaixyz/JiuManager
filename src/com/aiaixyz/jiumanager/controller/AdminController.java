package com.aiaixyz.jiumanager.controller;

import com.aiaixyz.jiumanager.entity.po.User;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.AdminService;
import com.aiaixyz.jiumanager.service.impl.AdminServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
@WebServlet("/AdminController")
public class AdminController {
    AdminService adminService = new AdminServiceImpl();
    protected RespBean register(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        return adminService.register(new User(null,username,password,realName,null));
    }
}
