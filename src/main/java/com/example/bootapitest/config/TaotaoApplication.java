package com.example.bootapitest.config;

import javax.sql.DataSource;

import com.example.bootapitest.day.v2.day8.*;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

import java.util.Properties;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties",
        "classpath:httpclient.properties" })
@ComponentScan(basePackages = "com.example")
//@ImportResource(value = "classpath:dubbo/dubbo-consumer.xml")
@SpringBootApplication
//@ServletComponentScan("com.example")
public class TaotaoApplication extends SpringBootServletInitializer{

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driver}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;



    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        // 数据库驱动
        boneCPDataSource.setDriverClass(jdbcDriverClassName);
        // 相应驱动的jdbcUrl
        boneCPDataSource.setJdbcUrl(jdbcUrl);
        // 数据库的用户名
        boneCPDataSource.setUsername(jdbcUsername);
        // 数据库的密码
        boneCPDataSource.setPassword(jdbcPassword);
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数
        boneCPDataSource.setMinConnectionsPerPartition(5);
        return boneCPDataSource;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TaotaoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TaotaoApplication.class, args);
    }


    /**
     * 使用代码注册Servlet（不需要@ServletComponentScan注解）
     * @return
     * @author SHANHY
     * @create  2016年1月6日
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new Myservlet(), "/xs/*");// ServletName默认值为首字母小写，即myServlet
//    }
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean2() {
//        return new ServletRegistrationBean(new GenericServletDemo1(), "/xz/*");// ServletName默认值为首字母小写，即myServlet
//    }
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean3() {
//        return new ServletRegistrationBean(new HttpServletDemo(), "/xy/*");// ServletName默认值为首字母小写，即myServlet
//    }

//    @Bean
//    public ServletRegistrationBean servletRegistrationBeanget() {
//        return new ServletRegistrationBean(new ServletGetMessage(), "/xg/*");// ServletName默认值为首字母小写，即myServlet
//    }
//    @Bean
//    public ServletRegistrationBean servletRegistrationBeangetContest() {
//        return new ServletRegistrationBean(new ServletContestGetMessage(), "/xcontest/*");// ServletName默认值为首字母小写，即myServlet
//    }



}
