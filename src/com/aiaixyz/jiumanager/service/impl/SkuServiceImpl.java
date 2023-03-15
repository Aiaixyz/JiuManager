package com.aiaixyz.jiumanager.service.impl;

import com.aiaixyz.jiumanager.dao.SkuDao;
import com.aiaixyz.jiumanager.dao.impl.SkuDaoImpl;
import com.aiaixyz.jiumanager.entity.po.Sku;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.SkuService;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/14
 */
public class SkuServiceImpl implements SkuService<Sku> {
    SkuDao skuDao = new SkuDaoImpl();
    @Override
    public RespBean getBeanBySku(int sku) {
        List<Sku> list = skuDao.getBeanBySku(sku);
        if (list.isEmpty()){
            return RespBean.respError("请求失败",null);
        }return RespBean.respSuccess("请求成功",list.get(0));
    }

    @Override
    public RespBean countName(String name) {
        int i = skuDao.countName(name);
        if (i > 0){
            return RespBean.respSuccess("Sku存在","i");
        }return RespBean.respError("Sku不存在",name);
    }

    @Override
    public RespBean updateBeanBySku(Sku sku) {
        if (skuDao.updateBeanBySku(sku) != 1){
            return RespBean.respError("修改失败",null);
        }return RespBean.respSuccess("修改成功",null);
    }

    @Override
    public RespBean deleteBeanBySku(int sku) {
       if ( skuDao.deleteBeanBySku(sku) != 1){
           return RespBean.respError("删除失败",null);
       }return RespBean.respSuccess("删除成功",null);
    }

    @Override
    public RespBean addBean(Sku sku) {
        if (skuDao.addBean(sku) != 1){
            return RespBean.respError("添加失败",null);
        }return RespBean.respSuccess("添加成功",null);
    }

    @Override
    public RespBean getList() {
        List<Sku> list = skuDao.getList();
        if (list.get(0).getSSku() == null){
            return RespBean.respError("获取失败",null);
        }return RespBean.respSuccess("获取成功",list);
    }
}
