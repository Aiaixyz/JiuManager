package dao;

import com.aiaixyz.jiumanager.dao.AdminDao;
import com.aiaixyz.jiumanager.dao.UserDao;
import com.aiaixyz.jiumanager.dao.impl.AdminDaoImpl;
import com.aiaixyz.jiumanager.dao.impl.UserDaoImpl;
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

/*    public void test(){
        int i = userDao.addBeanByUser(new User(null, "ls", "123456", "李四", null));
        System.out.println(i);
    }*/

    public void getIdByUsernameTest(){
        int zs = userDao.getIdByUsername("admin");
        System.out.println(zs);
    }

   /* public void getBeanByIdTest(){
        List beanById = userDao.getBeanById(3);
        for (Object list:beanById) {
            System.out.println(list+"***");
        }

    }*/

}
