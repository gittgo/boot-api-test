package com.example.bootapitest.day.v2.day8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Myservlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println(":sssssssss=======================");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }


//    private static final long serialVersionUID = -8685285401859800066L;
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
//        doPost(req, resp);
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Hello World</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>大家好，我的名字叫Servlet</h1>");
//        out.println("</body>");
//        out.println("</html>");
//    }
}
