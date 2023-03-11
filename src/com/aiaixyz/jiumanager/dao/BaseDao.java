package com.aiaixyz.jiumanager.dao;

import java.util.List;

/**
 * author LeeC
 * date 2023/3/9
 * since JDK 1.8
 */

public interface BaseDao<T> {
    //添加数据
    int addBean(T t);
    //根据 id 删除对象
    int deleteBeanById(int id);
    //根据 id 修改对象信息
    int updateBeanById(T t);
    //统计用户名出现的次数
    int countUsername(String username);
    //统计所有用户的总条数
    int getTotalCount();
    //根据用户名查找用户id
    int getIdByUsername(String username);
    //获取所有用户信息
    List<T> getList();
    //分页查询
    List<T> getList(int offset,int selectNum);
    //根据 Id 获取用户信息
    List<T> getBeanById(int id);
    //根据用户名模糊查询用户信息
    List<T> getListByUsername(String username);
}
