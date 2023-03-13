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

    @Override
    public int addBean(User user) {
        return 0;
    }

    @Override
    public int deleteBeanById(int id) {
        return 0;
    }

    /**
     * 通过id修改管理员
     * @param user 用户对象
     * @return 返回int类型 影响行数
     * sql:UPDATE u_user set u_password = '123',u_realname = 'lss' where is_delete = 1 AND  u_permit = 0 AND u_id = 5;
     */
    @Override
    public int updateBeanById(User user) {
        return DBManager.commonUpdate(
                "update u_user set u_password = ? , u_realname = ? where is_delete = 1 and u_permit = 0 and u_id = ?",
                user.getuPassword(),user.getuRealname(),user.getuId()
        );
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
        return  DBManager.common("select u_id from u_user where is_delete = 1 and u_permit = 0 and u_username = ?",username);
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public List<User> getList(int offset, int selectNum) {
        return null;
    }

    @Override
    public List<User> getBeanById(int id) {
        return null;
    }

    @Override
    public List<User> getListByUsername(String username) {
        return null;
    }
}
