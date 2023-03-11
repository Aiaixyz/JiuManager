package dao;

import com.aiaixyz.jiumanager.dao.UserDao;
import com.aiaixyz.jiumanager.dao.impl.UserDaoImpl;
import com.aiaixyz.jiumanager.entity.po.User;
import org.junit.Test;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/11
 */
public class UserDaoTest {
    @Test

    public void test(){
        UserDao userDao = new UserDaoImpl();
        int i = userDao.addBeanByUser(new User(null, "ls", "123456", "李四", null));
        System.out.println(i);
    }

}
