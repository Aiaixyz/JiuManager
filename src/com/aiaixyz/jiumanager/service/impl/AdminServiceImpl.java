package com.aiaixyz.jiumanager.service.impl;

import com.aiaixyz.jiumanager.dao.AdminDao;
import com.aiaixyz.jiumanager.dao.impl.AdminDaoImpl;
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
    @Override
    public RespBean register(User user) {
        int rSet = adminDao.addBeanByUser(user);
        if(rSet != 1){
            return RespBean.respError("注册失败",null);
        }
        return RespBean.respSuccess("注册成功",null);
    }

    @Override
    public RespBean deleteBeanById(int id) {
        return null;
    }

    @Override
    public RespBean updateBeanById(User user) {
        return null;
    }

    @Override
    public RespBean getList() {
        return null;
    }

    @Override
    public RespBean getPage(int currentPage) {
        return null;
    }
}
