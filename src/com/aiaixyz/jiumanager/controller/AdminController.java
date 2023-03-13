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
    UserController userController = new UserController();

    /**
     * 管理员注册接口
     * @param req 接受前端
     * @param resp 返回后端
     * @return 返回RespBean结果
     */
    protected RespBean register(HttpServletRequest req, HttpServletResponse resp) {
        return adminService.addBean(userController.getUser(req,null,0));

    }

    protected RespBean Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        return adminService.login(username,password);
    }

    protected RespBean getIdByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        return adminService.getIdByUsername(username);
    }

    /**
     * 修改管理员资料接口
     * @return RespBean修改结果 成功/失败
     */
    protected RespBean updateBeanById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        return adminService.updateBeanById(userController.getUser(req,id,0));
    }

}
