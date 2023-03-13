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
public class UserDaoImpl implements UserDao{
    /**
     * 通过用户对象添加
     * @param user 用户对象
     * @return 返回int类型结果
     */
    @Override
    public int addBean(User user) {
        return DBManager.commonUpdate(
                "insert into u_user(u_username,u_password,u_realname,u_permit) values(?,?,?,?)",
                user.getuUsername(),user.getuPassword(),user.getuRealname(),user.getuPermit()
        );
    }

    @Override
    public int deleteBeanById(int id) {
        return 0;
    }

    @Override
    public int updateBeanById(User user) {
        return 0;
    }

    @Override
    public int countUsername(String username) {
        return 0;
    }

    /**
     * 查询用户总数
     * @return int类型 用户总数
     */
    @Override
    public int getTotalCount() {
        return DBManager.common("select count(u_id) from u_user where is_delete = 1");
    }

    /**
     * 通过id获取用户名
     * @param username 用户名
     * @return int类型ID值
     * sql:select u_id from u_user where is_delete = 1 and u_permit = 0 and u_username = 'user';
     */
    @Override
    public int getIdByUsername(String username) {
        return  DBManager.common("select u_id from u_user where is_delete = 1 and u_permit = 1 and u_username = ?",username);
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public List<User> getList(int offset, int selectNum) {
        return null;
    }

    /**
     * 通过id获取用户对象
     * @param id 用户id
     * @return User集合
     */
    @Override
    public List<User> getBeanById(int id) {
        return DBManager.commonQuery("select " +
                "u_id," +
                "u_username," +
                "u_password," +
                "u_realname," +
                "u_permit from u_user where is_delete = 1 and u_id = ?",
                User.class,id
                );
    }

    @Override
    public List<User> getListByUsername(String username) {
        return null;
    }

}
