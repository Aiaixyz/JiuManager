package com.aiaixyz.jiumanager.service;

import com.aiaixyz.jiumanager.entity.vo.RespBean;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public interface BaseService<T> {
    RespBean register(T t);
    RespBean deleteBeanById(int id);
    RespBean updateBeanById(T t);
    RespBean getList();
    RespBean getPage(int currentPage);
}
