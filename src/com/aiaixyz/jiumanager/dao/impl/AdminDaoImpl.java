package com.aiaixyz.jiumanager.dao.impl;

import com.aiaixyz.jiumanager.dao.AdminDao;
import com.aiaixyz.jiumanager.dao.UserDao;
import com.aiaixyz.jiumanager.entity.po.User;
import com.aiaixyz.jiumanager.utils.DBManager;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class AdminDaoImpl implements AdminDao {

    UserDao userDao = new UserDaoImpl();
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int addBean(Object o) {
        return 0;
    }

    @Override
    public int deleteBeanById(int id) {
        return 0;
    }

    @Override
    public int updateBeanById(Object o) {
        return 0;
    }

    @Override
    public int countUsername(String username) {
        return 0;
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    /**
     * 通过id获取管理员
     * @param username 用户名
     * @return int类型ID值
     * sql:select u_id from u_user where is_delete = 1 and u_permit = 0 and u_username = 'admin';
     */
    @Override
    public int getIdByUsername(String username) {
        return  DBManager.common("select u_id from u_user where is_delete = 1 and u_permit = 1 and u_username = ?",username);
    }

    @Override
    public List getList() {
        return null;
    }

    @Override
    public List getList(int offset, int selectNum) {
        return null;
    }

    @Override
    public List getBeanById(int id) {
        return null;
    }

    @Override
    public List getListByUsername(String username) {
        return null;
    }
}
