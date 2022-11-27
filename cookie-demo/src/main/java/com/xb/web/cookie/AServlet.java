package com.xb.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //tomcat8以下版本cookie存储中文需要通过url编码解码方式
        String value = "珍贵的宝箱";
        //url编码
        value = URLEncoder.encode(value, "UTF-8");
        System.out.println("存储数据："+value);
        //1.创建cookie对象，设置数据
        Cookie cookie = new Cookie("box", value);
        //设置cookie寿命为一周
        cookie.setMaxAge(60*60*24*7);
        //2.发送给客户端:使用response对象
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
