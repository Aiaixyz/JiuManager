package dao;

import com.aiaixyz.jiumanager.dao.ReportDao;
import com.aiaixyz.jiumanager.dao.impl.ReportDaoImpl;
import org.junit.Test;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/16
 */
public class ReportDaoTest {
    ReportDao reportDao = new ReportDaoImpl();

    @Test
    public void getListTest(){
        System.out.println(reportDao.getList());
    }
}
