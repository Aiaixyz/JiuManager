package com.aiaixyz.jiumanager.service;

import com.aiaixyz.jiumanager.entity.po.Vendors;
import com.aiaixyz.jiumanager.entity.vo.RespBean;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
//Dao方法列表：addBean,getIdByName,deleteBeanById,updateBeanById,getBeanById,getBeanByName,getList
public interface VendorsService {
    RespBean addBean(Vendors vendors);
    RespBean getIdByName(String name);
    RespBean deleteBeanById(int id);
    RespBean updateBeanById(Vendors vendors);
    RespBean getBeanById(int id);
    RespBean getBeanByName(String id);
    RespBean getList();
    RespBean getPhoneByName(String name);
    RespBean getAddressByName(String name);
}
