package com.xb.web;

import com.xb.bean.Brand;
import com.xb.service.BrandsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

    private BrandsService bs = new BrandsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post方式乱码问题(tomcat8以上已解决Get乱码问题)
        req.setCharacterEncoding("UTF-8");
        //解决resp中文数据乱码以及标识html
        //resp.setContentType("text/html;charset=utf-8");

        //获得参数
        int id = Integer.parseInt(req.getParameter("id"));
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        Integer ordered = Integer.parseInt(req.getParameter("ordered"));
        String description = req.getParameter("description");
        Integer status = Integer.parseInt(req.getParameter("status"));
        //根据参数创建对象
        Brand brand = new Brand(id, brandName, companyName, ordered, description, status);
        //执行修改操作
        bs.update(brand);
        //重定向至查询所有servlet
        // req.getRequestDispatcher("/selectAllServlet").forward(req,resp);
        resp.sendRedirect("/brand_demo/selectAllServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
