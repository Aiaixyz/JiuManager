package com.aiaixyz.jiumanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * author LeeC
 * date 2023/3/9
 * since JDK 1.8
 */


/**
 * 数据库工具包
 */

public class DBUtils {

    private static String className;
    private static String url;
    private static String userName;
    private static String passWord;


    static {
        Properties properties = new Properties();
        try {
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            className = properties.getProperty("ClassName");
            url = properties.getProperty("URL");
            userName = properties.getProperty("UserName");
            passWord = properties.getProperty("PassWord");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getConnection；获取连接对象
     * @return
     */

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url,userName,passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭所有连接对象 ...可变参数
     * @param autoCloseables
     */

    public static void closeAll(AutoCloseable... autoCloseables){
        for (AutoCloseable autoCloseable:autoCloseables) {
            if (autoCloseable != null){
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
