package com.aiaixyz.jiumanager.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * author LeeC
 * date 2023/3/9
 * since JDK 1.8
 */

public class DBManager {
    /**
     *
     * @param sql sql语句
     * @param objs obj对象（参数）
     * @return 修改方法 返回影响行数
     */
    public static int commonUpdate(String sql,Object ... objs){
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1,objs[i]);
            }
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(ps,conn);
        }
        return rs;
    }

    /**
     *
     * @param sql sql语句
     * @param objs objs对象（参数）
     * @return 查询方法 返回单int类型
     */
    public static int common(String sql,Object ... objs){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            if (objs != null){
                for (int i = 0; i < objs.length; i++) {
                    ps.setObject(i,objs[i]);
                }
            }
            rs = ps.executeQuery();
            if (rs.next()){
                num = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,ps,conn);
        }
        return num;
    }

    /**
     * 通过反射获取对象查询数据库
     * @param sql sql语句
     * @param clazz class对象
     * @param objs objs对象（参数）
     * @return 查询结果
     * @param <T> 泛型
     */
    public static <T> List<T> commonQuery(String sql, Class<T> clazz, Object ... objs){
        List<T> list = new ArrayList<>();
        T t;
        String fieldName = null;
        Object fieldValue = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            if (objs != null){
                for (int i = 0; i < objs.length; i++) {
                    ps.setObject(i,objs[i]);
                }
            }
            rs = ps.executeQuery();

            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()){
                t = clazz.newInstance();
                for (Field field: fields) {
                    field.setAccessible(true);
                    fieldName = field.getName();
                    fieldName = changeFieldName(fieldName);
                    fieldValue = rs.getObject(fieldName);
                    field.set(t,fieldValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,ps,conn);
        }
        return list;
    }

    /**
     * 驼峰命名 2 数据命名
     * @return 数据库字段命名
     */
    public static String changeFieldName(String name){
        char[] chars = name.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                sb.append("_");
            }
            sb.append(aChar);
        }
        return sb.toString();
    }



}
