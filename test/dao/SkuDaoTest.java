package dao;

import com.aiaixyz.jiumanager.dao.SkuDao;
import com.aiaixyz.jiumanager.dao.impl.SkuDaoImpl;
import com.aiaixyz.jiumanager.entity.po.Sku;
import org.junit.Test;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/14
 */

//getBeanBySku,countName,updateBeanBySku,deleteBeanBySku,addBean,getList
public class SkuDaoTest {
    SkuDao skuDao = new SkuDaoImpl();
    @Test public void getBeanBySku(){
        System.out.println(skuDao.getBeanBySku(1));
    }
    @Test public void countName(){
        System.out.println(skuDao.countName("威士忌"));
    }
    @Test public void updateBeanBySku(){
        System.out.println(skuDao.updateBeanBySku(new Sku("威士忌",2,1,1)));
    }
    @Test public void deleteBeanBySku(){
        System.out.println(skuDao.deleteBeanBySku(1));
    }
    @Test public void addBean(){
        System.out.println(skuDao.addBean(new Sku("威士忌",2,1,1)));
    }
    @Test public void getList(){
        System.out.println(skuDao.getList());
    }
}
