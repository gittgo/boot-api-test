package com.example.bootapitest.people.controller;


import com.example.bootapitest.people.entity.People;
import com.example.bootapitest.people.entity.Result;
import com.example.bootapitest.people.service.BaseRestController;
import com.example.bootapitest.people.service.PeopleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends BaseRestController{



    @Autowired
    PeopleServer peopleServer;


    @RequestMapping(value = "/getOne",method = RequestMethod.GET)
    public Result getOne(int id){

        if(id<=0){
          return error("id输入有误");
        }
        People p = peopleServer.getPeopleByid(id);
        System.out.println(p.getPeopleId());
        System.out.println(p.getPeopleName());
        return success(p);
    }






}
