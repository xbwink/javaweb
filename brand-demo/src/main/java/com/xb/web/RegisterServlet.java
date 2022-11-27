package com.xb.web;

import com.xb.bean.User;
import com.xb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post方式乱码问题(tomcat8以上已解决Get乱码问题)
        req.setCharacterEncoding("UTF-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        //判断验证码是否为空
        if(checkCode==null || "".equals(checkCode)){
            //存储提示信息
            req.setAttribute("errorNameMsg","验证码不能为空");
            //请求转发注册页面
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }
        //取得session中正确的验证码
        String checkCode1 = (String) req.getSession().getAttribute("checkCode");
        if(!checkCode.equalsIgnoreCase(checkCode1)){
            //存储提示信息
            req.setAttribute("errorNameMsg","验证码错误");
            //请求转发注册页面
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }

        User user = new User(null, username, password);
        //调用service层执行注册
        boolean flag = userService.register(user);
        if(!flag){ //注册失败
            //存储一个用户名不太受欢迎提示信息
            req.setAttribute("errorNameMsg","用户名不太受欢迎");
            //请求转发注册页面
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }
        //注册成功
        resp.sendRedirect(req.getContextPath()+"/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}
