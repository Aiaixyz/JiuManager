package com.aiaixyz.jiumanager.controller;

import com.aiaixyz.jiumanager.entity.po.User;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.AdminService;
import com.aiaixyz.jiumanager.service.impl.AdminServiceImpl;
import com.aiaixyz.jiumanager.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
@WebServlet("/AdminController")
public class AdminController extends BaseServlet {
    AdminService adminService = new AdminServiceImpl();

    /**
     * 管理员注册接口
     * @param req 接受前端
     * @param resp 返回后端
     * @return 返回RespBean结果
     */
    protected RespBean register(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String realName = req.getParameter("realName");
        Integer permit = 0;
        return adminService.addBean(new User(null,username,password,realName,permit));

    }

    protected RespBean Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        return adminService.login(username,password);
    }

}
