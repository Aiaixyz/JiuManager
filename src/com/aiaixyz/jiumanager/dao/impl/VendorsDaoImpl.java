package com.aiaixyz.jiumanager.dao.impl;

import com.aiaixyz.jiumanager.dao.VendorsDao;
import com.aiaixyz.jiumanager.entity.po.Vendors;
import com.aiaixyz.jiumanager.utils.DBManager;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
//方法列表：addBean,getIdByName,deleteBeanById,updateBeanById,getBeanById,getBeanByName,getList;
public class VendorsDaoImpl implements VendorsDao {
    @Override
    public int addBean(Vendors vendors) {
        return DBManager.commonUpdate(
                "insert into v_vendors(v_name,v_phone,v_address) values(?,?,?)",
                vendors.getVName(),vendors.getVPhone(),vendors.getVAddress()
        );
    }

    @Override
    public int getIdByName(String name) {
        return DBManager.common(
                "select v_id from v_vendors where is_delete = 1 and v_name = ?",
                name
        );
    }

    @Override
    public int deleteBeanById(int id) {
        return DBManager.commonUpdate(
                "update v_vendors set is_delete = 0 where v_id = ? ",
                id
        );
    }

    @Override
    public int updateBeanById(Vendors vendors) {
        return DBManager.commonUpdate(
                "update v_vendors set v_name = ? ,v_phone = ?,v_address = ? where is_delete = 1 and v_id = ?",
                vendors.getVName(),vendors.getVPhone(),vendors.getVAddress(),vendors.getVId()
        );
    }

    @Override
    public List<Vendors> getBeanById(int id) {
        return DBManager.commonQuery(
                "select v_id,v_name,v_phone,v_address from v_vendors where is_delete = 1 and v_id = ?",
                Vendors.class, id
        );
    }

    @Override
    public List<Vendors> getBeanByName(String name) {
        return DBManager.commonQuery(
                "select v_id,v_name,v_phone,v_address from v_vendors where is_delete = 1 and v_name = ?",
                Vendors.class,name
        );
    }

    @Override
    public List<Vendors> getList() {
        return DBManager.commonQuery(
                "select v_id,v_name,v_phone,v_address from v_vendors where is_delete = 1",
                Vendors.class
        );
    }
}
