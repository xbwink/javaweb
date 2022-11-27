package com.xb.web;

import com.xb.bean.Brand;
import com.xb.service.BrandsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    private BrandsService bs = new BrandsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        Integer id = Integer.parseInt(req.getParameter("id"));
        //调用service删除
        bs.deleteById(id);
        //重定向至查询所有servlet
        // req.getRequestDispatcher("/selectAllServlet").forward(req,resp);
        resp.sendRedirect("/brand_demo/selectAllServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
