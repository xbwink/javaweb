package com.xb.web.filter;

import com.xb.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.jsp","/imgs/","/css/","/js/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet","/selectByNameServlet"};
        // 获取当前访问的资源路径
        String url = request.getRequestURL().toString();

        //循环判断
        for (String u : urls) {
            if(url.contains(u)){
                //找到了
                //放行
                filterChain.doFilter(request, servletResponse);
                //break;
                return;
            }
        }

        //取得session对象中的用户对象
        Object user = request.getSession().getAttribute("user");
        if(user == null){//用户未登录
            //跳转至登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
            return;
        }
        //用户已登录执行放行
        filterChain.doFilter(request,servletResponse);
    }

}
