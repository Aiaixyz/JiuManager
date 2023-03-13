package com.aiaixyz.jiumanager.controller;

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
     * 管理员注册
     * @param req 接受前端
     * @param resp 返回后端
     * @return 返回RespBean结果
     */
    protected RespBean Register(HttpServletRequest req, HttpServletResponse resp) {
        return adminService.addBean(userController.getUser(req,null,0));

    }
    /**
     * 管理员登录
     * @return RespBean 用户不存在/密码错误/登录成功
     */
    protected RespBean Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        return adminService.login(username,password);
    }

    /**
     * 通过管理员用户名获取管理员Id
     * @return RespBean回应 用户已存在/用户不存在 , data返回用户int类型用户id
     */
    protected RespBean GetIdByUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        return adminService.getIdByUsername(username);
    }

    /**
     * 修改管理员资料
     * @return RespBean修改结果 成功/失败
     */
    protected RespBean UpdateBeanById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        return adminService.updateBeanById(userController.getUser(req,id,0));
    }

    /**
     * 获取所有用户和管理员信息
     * @return UserBo类型的List集合
     */
    protected RespBean GetList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return adminService.getList();
    }

}
