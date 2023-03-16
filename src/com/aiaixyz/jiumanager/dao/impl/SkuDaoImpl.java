package com.aiaixyz.jiumanager.dao.impl;

import com.aiaixyz.jiumanager.dao.SkuDao;
import com.aiaixyz.jiumanager.entity.po.Sku;
import com.aiaixyz.jiumanager.utils.DBManager;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/14
 */
public class SkuDaoImpl implements SkuDao {
    @Override
    public int inSkuQuantity(int sku, int num) {
        return DBManager.commonUpdate(
                "update s_sku set s_quantity = s_quantity + ? where is_delete = 1 and s_sku = ?",
                num,sku
        );
    }

    @Override
    public int outSkuQuantity(int sku, int num) {
        return DBManager.commonUpdate(
                "update s_sku set s_quantity = s_quantity - ? where is_delete = 1 and s_sku = ?",
                num,sku
        );
    }

    /**
     * 添加对象
     * @param sku 传入的对象
     * @return int类型添加行数
     */
    @Override
    public int addBean(Sku sku) {
        return DBManager.commonUpdate(
                "insert into s_sku(s_name,s_quantity,d_id,v_id) values(?,?,?,?)",
                sku.getSName(),sku.getSQuantity(),sku.getDId(),sku.getVId()
        );
    }

    /**
     * 通过sku删除对象
     * @return 返回删除行数
     */
    @Override
    public int deleteBeanBySku(int sku) {
        return DBManager.commonUpdate(
                "update s_sku set is_delete = 0 where is_delete = 1 and s_sku = ?",sku
        );
    }

    /**
     * 通过sku修改对象
     * @return 返回int类型影响行数
     */
    @Override
    public int updateBeanBySku(Sku sku) {
        return DBManager.commonUpdate(
                "update s_sku set s_name = ? , s_quantity = ? , d_id = ? , v_id = ? where is_delete = 1 and s_sku = ?",
                sku.getSName(),sku.getSQuantity(),sku.getDId(),sku.getVId(),sku.getSSku()
        );
    }

    /**
     * 通过name统计数量（是否存在0
     * @return int类型数量
     */
    @Override
    public int countName(String name) {
        return DBManager.common(
                "select count(*) from s_sku where is_delete = 1 and s_name = ?",name
        );
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public int getSkuByName(String username) {
        return 0;
    }

    /**
     * 获取所有Sku对象
     * @return Sku类型List集合
     */
    @Override
    public List<Sku> getList() {
        return DBManager.commonQuery("select s_sku,"+
                                "s_name, " +
                                "s_quantity, " +
                                "d_id, " +
                                "v_id from s_sku where is_delete = 1",Sku.class);
    }

    @Override
    public List<Sku> getList(int offset, int selectNum) {
        return null;
    }

    /**
     * 通过s_sku获取Sku对象
     * @return Sku类型List集合
     */
    @Override
    public List<Sku> getBeanBySku(int sku) {
        return DBManager.commonQuery("select s_sku," +
                "s_name, " +
                "s_quantity, " +
                "d_id, " +
                "v_id from s_sku where is_delete = 1 and s_sku = ?",Sku.class,sku);
    }

    @Override
    public List<Sku> getListByName(String username) {
        return null;
    }
}
