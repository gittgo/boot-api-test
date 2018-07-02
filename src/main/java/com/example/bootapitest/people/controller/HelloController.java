package com.example.bootapitest.people.controller;


import com.example.bootapitest.hntest.dto.TypeExponentDto;
import com.example.bootapitest.hntest.service.TypeServer;
import com.example.bootapitest.people.entity.People;
import com.example.bootapitest.people.service.BaseRestController;
import com.example.bootapitest.people.service.PeopleServer;
import org.apache.commons.collections.map.HashedMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController extends BaseRestController {

    private static Logger logger = LogManager.getLogger(HelloController.class);


    @Autowired
    PeopleServer peopleServer;

    @Autowired
    TypeServer typeServer;


    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public List<TypeExponentDto> getOne(int id) {

        Map map = new HashedMap();

        logger.debug("是两遍吗？");


        System.out.println("======begin");
//        List<TypeExponentDto> typeExponents = typeServer.getTypeExponent();
        System.out.println("======end");

        //获取系统默认编码
        System.out.println(System.getProperty("file.encoding"));

        //获取系统默认的字符编码
        System.out.println(Charset.defaultCharset());

        //获取系统默认语言

        System.out.println(System.getProperty("user.language"));

        //获取系统属性列表

        System.getProperties().list(System.out);

        if(id<=0){
//          return error("id输入有误");
        }
        People p = peopleServer.getPeopleByid(id);
        System.out.println(p.getName());
//        return success(typeExponents);
//        return typeExponents;
    return  null;
    }



    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public List<TypeExponentDto> getList() {
        peopleServer.select();

        return null;
    }





}
