package com.hgkj.model.Servlet;

import com.hgkj.model.entity.Good;
import com.hgkj.model.service.GoodService;
import com.hgkj.model.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateGoodServlet",value = "/UpdateGoodServlet")
public class UpdateGoodServlet extends HttpServlet {
    private GoodService goodService=new GoodServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int goodId= Integer.parseInt(request.getParameter("goodId"));
        String goodName=request.getParameter("goodName");
        double goodPrice= Double.parseDouble(request.getParameter("goodPrice"));
        String goodAddress=request.getParameter("goodAddress");

        Good good=new Good(goodId,goodName,goodAddress,goodPrice);
        boolean result=goodService.UpdateService(good);
        if (result){
            response.sendRedirect("AllGoodServlet");
        }
        else {
            request.setAttribute("emsg","修改失败");
            request.getRequestDispatcher("Updategood.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
