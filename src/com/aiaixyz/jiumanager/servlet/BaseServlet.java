package com.aiaixyz.jiumanager.servlet;

import com.aiaixyz.jiumanager.entity.vo.RespBean;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author LeeC
 * date 2023/3/9
 * since JDK 1.8
 */

/**
 * 输出json格式的对象respBean
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决响应乱码问题
        resp.setContentType("text/html;charset=utf-8");
        //解决 post 提交方式的请求乱码问题
        req.setCharacterEncoding("utf-8");

        String method = req.getParameter("method");
        Class<? extends BaseServlet> clazz = this.getClass();

        try {
            //2.根据反射对象获取方法对象
            Method declaredMethod  = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //3.打开访问权限
            declaredMethod.setAccessible(true);
            //4.调用指定对象的方法并传递参数
            RespBean respBean = (RespBean) declaredMethod.invoke(this,req,resp);
            //5.转换json格式的数据并响应
            String json = JSONObject.toJSONString(respBean);
            resp.getWriter().write(json);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
