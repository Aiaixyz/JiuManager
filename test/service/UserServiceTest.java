package service;

import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.aiaixyz.jiumanager.service.AdminService;
import com.aiaixyz.jiumanager.service.UserService;
import com.aiaixyz.jiumanager.service.impl.AdminServiceImpl;
import com.aiaixyz.jiumanager.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    AdminService adminService = new AdminServiceImpl();
    @Test
    /*public void registerTest(){
        RespBean zs = userService.login("zs", "123456");
        System.out.println(zs);
    }*/
/*    public void getIdByUsernameTest(){
        RespBean zs = adminService.getIdByUsername("admin");
        System.out.println(zs);
    }*/

    public void getListTest(){
        RespBean list = adminService.getList();
        System.out.println(list);
    }

}
