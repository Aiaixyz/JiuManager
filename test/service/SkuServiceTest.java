package service;

import com.aiaixyz.jiumanager.entity.po.Sku;
import com.aiaixyz.jiumanager.service.SkuService;
import com.aiaixyz.jiumanager.service.impl.SkuServiceImpl;
import org.junit.Test;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
public class SkuServiceTest {
    //getBeanBySku,countName,updateBeanBySku,deleteBeanBySku,addBean,getList

    SkuService<Sku> skuService = new SkuServiceImpl();

    public Sku getSkuTestObj(){
        return new Sku(3,"伏特加",10,1,1);
    }

    @Test public void getBeanBySku(){
        System.out.println(skuService.getBeanBySku(3));
    }
    @Test public void countName(){
        System.out.println(skuService.countName("威士忌"));
    }
    @Test public void updateBeanBySku(){
        System.out.println(skuService.updateBeanBySku(getSkuTestObj()));
    }
    @Test public void deleteBeanBySku(){
        System.out.println(skuService.deleteBeanBySku(3));
    }
    @Test public void addBean(){
        System.out.println(skuService.addBean(getSkuTestObj()));
    }
    @Test public void getList(){
        System.out.println(skuService.getList());
    }
}
