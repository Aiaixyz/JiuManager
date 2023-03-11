package com.aiaixyz.jiumanager.dao.impl;

import com.aiaixyz.jiumanager.dao.UserDao;
import com.aiaixyz.jiumanager.entity.po.User;
import com.aiaixyz.jiumanager.utils.DBManager;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class UserDaoImpl implements UserDao {
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

    @Override
    public int getIdByUsername(String username) {
        return 0;
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


    @Override
    public int addBeanByUser(User user) {
        return DBManager.commonUpdate(
                "insert into u_user(u_username,u_password,u_realname) values(?,?,?)",
                user.getuUsername(),user.getuPassword(),user.getuRealname()
        );
    }
}
