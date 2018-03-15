package com.example.bootapitest.day.v2.day8;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletGetMessage extends HttpServlet{


    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

//    TODO 此处encoding 并未查找出来  怀疑是  没有创建  filter encoding 过滤器
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encod = config.getInitParameter("encoding");
        System.out.println(encod+"********");
    }
}
