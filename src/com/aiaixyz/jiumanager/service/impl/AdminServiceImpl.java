package com.aiaixyz.jiumanager.service.impl;

import com.aiaixyz.jiumanager.dao.AdminDao;
import com.aiaixyz.jiumanager.dao.UserDao;
import com.aiaixyz.jiumanager.dao.impl.AdminDaoImpl;
import com.aiaixyz.jiumanager.dao.impl.UserDaoImpl;
import com.aiaixyz.jiumanager.entity.po.User;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.AdminService;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    UserDao userDao = new UserDaoImpl();
    UserServiceImpl userService = new UserServiceImpl();

    /**
     * 添加管理员
     * @param user 对象
     * @return RespBean msg 成功/失败
     */
    @Override
    public RespBean addBean(User user) {
        int rSet = userDao.addBean(user);
        if(rSet != 1){
            return RespBean.respError("注册失败",null);
        }
        return RespBean.respSuccess("注册成功",null);
    }

    @Override
    public RespBean deleteBeanById(int id) {
        return null;
    }

    /**
     * 通过Id修改用户信息
     * @param user 传入的用户对象
     * @return RespBean 修改成功/修改错误
     */
    @Override
    public RespBean updateBeanById(User user) {
        if (adminDao.updateBeanById(user) != 1){
            return RespBean.respError("修改信息错误",null);
        }
        return RespBean.respSuccess("修改信息成功",null);
    }

    @Override
    public RespBean getList() {
        return userService.getUserBoList(adminDao.getList());
    }

    @Override
    public RespBean getPage(int currentPage) {
        return null;
    }

    /**
     * 通过管理员用户名返回ID
     * @param username 管理员用户名
     * @return RespBean类型 msg "用户名不存在"//"用户名已存在"
     */
    @Override
    public RespBean getIdByUsername(String username) {
        int rSet = adminDao.getIdByUsername(username);
        if(rSet == 0){
            return RespBean.respError("用户名不存在",null);
        }
        return RespBean.respSuccess("用户名已存在",rSet);
    }

    /**
     * 登录服务
     * @param username 传入用户名
     * @param password 传入密码
     * @return RespBean
     * 密码错误返回“密码错误”msg，
     * 用户名错误返回”用户不存在“msg，
     * 用户名和密码吻合返回”登入成功“msg并返回RealName。
     */
    @Override
    public RespBean login(String username, String password) {
        int id = adminDao.getIdByUsername(username);
        if (id != 0){
            User user = userDao.getBeanById(id).get(0);
            if (password.equals(user.getUPassword())){
                return RespBean.respSuccess("登录成功",user);
            }return RespBean.respError("密码错误",null);
        }return RespBean.respError("用户不存在",null);
    }
}
