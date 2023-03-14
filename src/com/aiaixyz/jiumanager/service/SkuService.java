package com.aiaixyz.jiumanager.service;

import com.aiaixyz.jiumanager.entity.po.Sku;
import com.aiaixyz.jiumanager.entity.vo.RespBean;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/14
 */

//getBeanBySku,countName,updateBeanBySku,deleteBeanBySku,addBean,getList

public interface SkuService<T> {
    RespBean getBeanBySku(int sku);
    RespBean countName(String name);
    RespBean updateBeanBySku(Sku sku);
    RespBean deleteBeanBySku(int sku);
    RespBean addBean(Sku sku);
    RespBean getList();
}
