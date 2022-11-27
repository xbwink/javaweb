package com.xb.web;

import com.xb.bean.Brand;
import com.xb.service.BrandsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {

    private BrandsService bs = new BrandsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        Integer id = Integer.parseInt(req.getParameter("id"));
        //调用service层查询对象
        Brand brand = bs.selectById(id);
        //将对象保存至req域中
        req.setAttribute("brand",brand);
        //请求转发至addBrand.html
        req.getRequestDispatcher("updateBrand.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
