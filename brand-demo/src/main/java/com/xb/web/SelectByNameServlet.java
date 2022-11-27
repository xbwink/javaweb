package com.xb.web;

import com.xb.bean.Brand;
import com.xb.bean.User;
import com.xb.service.BrandsService;
import com.xb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByNameServlet")
public class SelectByNameServlet extends HttpServlet {

    private UserService us = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username = req.getParameter("username");
        //调用service层查询对象
        Boolean flag = us.selectByName(username);
        //返回给前端页面
        resp.getWriter().write(flag.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
