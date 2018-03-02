package com.example.bootapitest.people.service;

import com.example.bootapitest.people.entity.People;

public interface PeopleServer {


    /**
     * 根据id获取用户
     */
    People getPeopleByid(int id);
}
