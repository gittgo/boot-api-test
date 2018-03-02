package com.example.bootapitest.day.v2.day8;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.*;
import java.io.IOException;

@RestController
public class ServletDemo1 implements Servlet {



    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet  test ");

    }





    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
