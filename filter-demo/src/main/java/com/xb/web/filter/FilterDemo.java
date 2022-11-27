package com.xb.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.放行前对request数据进行处理
        System.out.println("Filter1....");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        //放行后对response数据进行处理
        System.out.println("Filter3....");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
