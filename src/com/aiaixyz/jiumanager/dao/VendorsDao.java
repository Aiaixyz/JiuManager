package com.aiaixyz.jiumanager.dao;

import com.aiaixyz.jiumanager.entity.po.Vendors;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
//方法列表：addBean,getIdByName,deleteBeanById,updateBeanById,getBeanById,getBeanByName,getList
public interface VendorsDao {
    //添加供应商
    int addBean(Vendors vendors);

    //使用name获取id
    int getIdByName(String name);

    //使用id删除供应商
    int deleteBeanById(int id);

    //使用id修改供应商
    int updateBeanById(Vendors vendors);

    //使用id获取供应商
    List<Vendors> getBeanById(int id);

    //通过name获取供应商
    List<Vendors> getBeanByName(String name);

    //获取所有供应商
    List<Vendors> getList();

}
