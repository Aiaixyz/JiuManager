package com.aiaixyz.jiumanager.dao;

import com.aiaixyz.jiumanager.entity.po.User;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public interface UserDao extends BaseDao{

    /**
     * 通过用户对象添加
     * @param user 用户对象
     * @return 返回int类型结果
     */
    public int addBeanByUser(User user);
}
