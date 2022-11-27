package com.xb.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端所有cookie对象
        Cookie[] cookies = req.getCookies();
        //遍历数组取得数据
        for (Cookie cookie : cookies) {
            String key = cookie.getName();
            if("box".equals(key)){
                String value = cookie.getValue();
                //URL解码
                value = URLDecoder.decode(value,"UTF-8");
                System.out.println(key+":"+value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
