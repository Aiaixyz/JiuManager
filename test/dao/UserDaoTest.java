package dao;

import com.aiaixyz.jiumanager.dao.AdminDao;
import com.aiaixyz.jiumanager.dao.UserDao;
import com.aiaixyz.jiumanager.dao.impl.AdminDaoImpl;
import com.aiaixyz.jiumanager.dao.impl.UserDaoImpl;
import com.aiaixyz.jiumanager.entity.po.User;
import org.junit.Test;

import java.util.List;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    AdminDao adminDao = new AdminDaoImpl();
    @Test

    public void test(){
        int i = userDao.addBean(new User(null, "ls", "123456", "李四", null));
        System.out.println(i);
    }

    public void getIdByUsernameTest(){
        int zs = adminDao.getIdByUsername("admin");
        System.out.println(zs);
    }

    public void getBeanByIdTest(){
        List beanById = userDao.getBeanById(3);
        for (Object list:beanById) {
            System.out.println(list+"***");
        }

    }
    public void updateBeanByIdTest(){
        int u_id = 5;
        String username = "wwwww";
        String password = "ww123456";
        String realname = "王五";
        int i = userDao.updateBeanById(new User(u_id, username, password, realname));
        System.out.println(i);
    }

}
