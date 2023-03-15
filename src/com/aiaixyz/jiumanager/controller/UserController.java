package com.aiaixyz.jiumanager.controller;

import com.aiaixyz.jiumanager.entity.po.User;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.UserService;
import com.aiaixyz.jiumanager.service.impl.UserServiceImpl;
import com.aiaixyz.jiumanager.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/10
 */
@WebServlet("/UserController")
public class UserController extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 获取请求转换为User对象
     * @param id 赋予User对象的Id值
     * @param permit 配置权限
     * @return 完整User对象
     */
    public User getUser(HttpServletRequest req,Integer id,Integer permit){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String realname = req.getParameter("realname");
        return new User(id,username,password,realname,permit);
    }

    /**
     * 用户注册接口
     * @return 返回RespBean结果
     */
    protected RespBean Register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return userService.addBean(getUser(req,null,1));
    }

    /**
     * 登录接口
     * 如果登陆成功则清除session中的id后重新写入新的id
     * @return RespBean回应 用户不存在/密码错误/登陆成功
     */
    protected RespBean Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        RespBean respBean = userService.login(username, password);
        if (respBean.getStatus() == 200){
            User user = (User)respBean.getData();
            req.getSession().removeAttribute("id");
            req.getSession().removeAttribute("realname");
            req.getSession().setAttribute("id",user.getuId());
            req.getSession().setAttribute("realname",user.getuRealname());
            return RespBean.respSuccess("登录成功",null);
        }
        return RespBean.respSuccess("登录失败",null);
    }

    /**
     * 通过用户名获取用户Id
     * @return RespBean回应 用户已存在/用户不存在 , data返回用户int类型用户id
     */
    protected RespBean GetIdByUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        return userService.getIdByUsername(username);
    }

    /**
     * 修改用户资料接口
     * @return RespBean修改结果 成功/失败
     */
    protected RespBean UpdateBeanById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return userService.updateBeanById(getUser(req,Integer.parseInt(req.getParameter("id")),1));
    }

    /**
     * 获取所有用户信息
     * @return UserBo类型的List集合
     */
    protected RespBean GetList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return userService.getList();
    }

    protected RespBean getUsernameBySessionId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return userService.getUsernameById((Integer) req.getSession().getAttribute("id"));
    }
}
