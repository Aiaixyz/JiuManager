package service;

import com.aiaixyz.jiumanager.entity.po.Vendors;
import com.aiaixyz.jiumanager.service.VendorsService;
import com.aiaixyz.jiumanager.service.impl.VendorsServiceImpl;
import org.junit.Test;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/15
 */
public class VendorsServiceTest {
    //Service方法列表:addBean,getIdByName,deleteBeanById,updateBeanById,getBeanById,getBeanByName,getList,getPhoneByName,getAddressByName

    VendorsService vendorsService = new VendorsServiceImpl();

    public Vendors getNewVendorsObjTest(){
        return new Vendors("广州白云山酒业","1242323432","广州市白云区白云山酒业");
    }
    public Vendors getVendorsObjTest(){
        return new Vendors(4,"广州白云山酒业","1232","广州市白云区白云山酒业");
    }

        @Test public void addBeanTest(){
        System.out.println(vendorsService.addBean(getNewVendorsObjTest()));
    };
        @Test public void getIdByNameTest(){
        System.out.println(vendorsService.getIdByName("广州白云山酒业"));
    };
        @Test public void deleteBeanByIdTest(){
        System.out.println(vendorsService.deleteBeanById(3));
    };
        @Test public void updateBeanByIdTest(){
        System.out.println(vendorsService.updateBeanById(getVendorsObjTest()));
    };
        @Test public void getBeanByIdTest(){
        System.out.println(vendorsService.getBeanById(4));
    };
        @Test public void getBeanByNameTest(){
        System.out.println(vendorsService.getBeanByName("广州白云山酒业"));
    };
        @Test public void getListTest(){
        System.out.println(vendorsService.getList());
    };
        @Test public void getPhoneByNameTest(){
        System.out.println(vendorsService.getPhoneByName("广州白云山酒业"));
    };
        @Test public void getAddressByNameTest(){
        System.out.println(vendorsService.getAddressByName("广州白云山酒业"));
    };

}
