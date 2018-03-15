package com.example.bootapitest.day.v2.day8;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns="/st/myservlet2", description="Servlet的说明")
public class Myservlet2 implements Servlet{


    // 实例化
    public Myservlet2(){
        System.out.println("*****************Myservlet  实例化2 执行了 ******************");
    }

    // 初始化
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("*****************Myservlet  初始化2 执行了 ******************");
    }



    // 服务
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println(">>>>>>>>>>doPost2()<<<<<<<<<<<");
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("utf-8");
        PrintWriter out = servletResponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>大家好，我的名字叫Servlet2</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    // 销毁
    @Override
    public void destroy() {
        System.out.println("*****************Myservlet  销毁2 执行了 ******************");
    }

    @Override
    public String getServletInfo() {
        return null;
    }


    //
    @Override
    public ServletConfig getServletConfig() {
        return null;
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
