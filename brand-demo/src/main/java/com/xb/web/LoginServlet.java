package com.xb.web;

import com.xb.bean.User;
import com.xb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post方式乱码问题(tomcat8以上已解决Get乱码问题)
        req.setCharacterEncoding("UTF-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //用户是否勾选记住密码
        String remember = req.getParameter("remember");
        if (remember != null && remember != "") {
            //使用cookie保存用户名密码
            Cookie nameCookie = new Cookie("nameCookie", username);
            Cookie pwdCookie = new Cookie("pwdCookie", password);
            //设置存活时间为一周
            nameCookie.setMaxAge(60 * 60 * 24 * 7);
            pwdCookie.setMaxAge(60 * 60 * 24 * 7);
            //发送给客户端
            resp.addCookie(nameCookie);
            resp.addCookie(pwdCookie);
        }

        //调用service层查询
        User user = userService.login(username, password);
        if (user == null) { //登录失败
            //请求转发至登录页面
            //存储一个登录失败提示信息
            req.setAttribute("errorMsg", "用户名或密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        //登录成功
        //使用session存储用户
        req.getSession().setAttribute("user", user);
        //重定向至selectAllServlet
        resp.sendRedirect(req.getContextPath() + "/selectAllServlet");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
