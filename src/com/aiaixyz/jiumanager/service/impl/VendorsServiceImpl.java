package com.aiaixyz.jiumanager.service.impl;

import com.aiaixyz.jiumanager.dao.VendorsDao;
import com.aiaixyz.jiumanager.dao.impl.VendorsDaoImpl;
import com.aiaixyz.jiumanager.entity.po.Vendors;
import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.VendorsService;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
//Service方法列表:addBean,getIdByName,deleteBeanById,updateBeanById,getBeanById,getBeanByName,getList,getPhoneByName,getAddressByName
//Dao方法列表：addBean,getIdByName,deleteBeanById,updateBeanById,getBeanById,getBeanByName,getList
public class VendorsServiceImpl implements VendorsService {

    VendorsDao vendorsDao = new VendorsDaoImpl();


    @Override
    public RespBean addBean(Vendors vendors) {
        if (vendorsDao.addBean(vendors) != 1){
            return RespBean.respError("添加失败",null);
        }return RespBean.respSuccess("添加成功",null);
    }

    @Override
    public RespBean getIdByName(String name) {
        int id = vendorsDao.getIdByName(name);
        if (id == 0){
            return RespBean.respError("获取失败",null);
        }return RespBean.respSuccess("获取成功",id);
    }

    @Override
    public RespBean deleteBeanById(int id) {
        if (vendorsDao.deleteBeanById(id) != 1){
            return RespBean.respError("修改失败",null);
        }return RespBean.respSuccess("修改成功",id);
    }

    @Override
    public RespBean updateBeanById(Vendors vendors) {
        if (vendorsDao.updateBeanById(vendors) != 1){
            return RespBean.respError("修改失败",null);
        }return RespBean.respSuccess("修改成功",null);
    }

    @Override
    public RespBean getBeanById(int id) {
        List<Vendors> list = vendorsDao.getBeanById(id);
        if (list.isEmpty()){
            return RespBean.respError("获取失败",null);
        }return RespBean.respSuccess("获取成功",list.get(0));
    }

    @Override
    public RespBean getBeanByName(String name) {
        List<Vendors> list = vendorsDao.getBeanByName(name);
        if (list.isEmpty()){
            return RespBean.respError("获取失败",null);
        }return RespBean.respSuccess("获取成功",list.get(0));
    }

    @Override
    public RespBean getList() {
        List<Vendors> list = vendorsDao.getList();
        if (list.isEmpty()){
            return RespBean.respError("获取失败",null);
        }return RespBean.respSuccess("获取成功",list);
    }

    @Override
    public RespBean getPhoneByName(String name) {
        List<Vendors> list = vendorsDao.getBeanByName(name);
        if (!list.isEmpty()){
            String phone = list.get(0).getVPhone();
            if (!phone.isEmpty()){
                return RespBean.respSuccess("获取成功",phone);
            }
        }
        return RespBean.respError("获取失败",null);
    }

    @Override
    public RespBean getAddressByName(String name) {
        List<Vendors> list = vendorsDao.getBeanByName(name);
        if (!list.isEmpty()) {
            String address = list.get(0).getVAddress();
            if (!address.isEmpty()) {
                return RespBean.respSuccess("获取成功", address);
            }
        }
        return RespBean.respError("获取失败", null);
    }
}
