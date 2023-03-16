package service;

import com.aiaixyz.jiumanager.service.ReportService;
import com.aiaixyz.jiumanager.service.impl.ReportServiceImpl;
import org.junit.Test;

/**
 * author LeeC
 * since JDK 1.8
 * date 2023/3/16
 */
public class ReportServiceTest {
    ReportService reportService = new ReportServiceImpl();
    @Test

    public void Test(){
        System.out.println(reportService.getList());

    }
}
