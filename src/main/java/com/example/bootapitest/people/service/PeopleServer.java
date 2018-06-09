package com.example.bootapitest.people.service;

import com.example.bootapitest.people.entity.People;

import java.util.List;

public interface PeopleServer {


    /**
     * 根据id获取用户
     */
    People getPeopleByid(int id);

    /**
     * 分页查询
     */
    List<People> select();
}
