package com.aiaixyz.jiumanager.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/2/22
 */
@WebFilter("/*")
public class LoginFilter extends BaseFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.强转
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //2.处理乱码问题
        //解决响应乱码问题
        response.setContentType("text/html;charset=utf-8");
        //解决 post 提交方式的请求乱码问题
        request.setCharacterEncoding("utf-8");

        //3.获取请求地址
        String uri = request.getRequestURI();
        String method = request.getParameter("method");
        //4.未登录前能访问的请求
        if(uri.endsWith("index.html")
                || uri.endsWith("userLogin.html")
                || uri.endsWith("adminLogin.html")
                || uri.endsWith(".js")
                || uri.endsWith(".css")
                || uri.endsWith("UserController")
                || uri.endsWith("7.jpg")
                || uri.endsWith("20.jpg")
                || uri.endsWith("100.jpg")
                || "login".equals(method)
                || "register".equals(method)){
            //放行
            filterChain.doFilter(request,response);
            return;
        }
        //5.判断是否登录
        Object id = request.getSession().getAttribute("id");
        if(id != null){
            //放行
            filterChain.doFilter(request,response);
            return;
        }
        response.getWriter().write("<script>alert('请先登录');location.href='index.html'</script>");
    }

}
