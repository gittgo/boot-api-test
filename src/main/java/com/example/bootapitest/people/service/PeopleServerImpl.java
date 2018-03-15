package com.example.bootapitest.people.service;


import com.example.bootapitest.people.entity.People;
import com.example.bootapitest.people.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Transactional
public class PeopleServerImpl implements PeopleServer{

    @Autowired
    private PeopleMapper peopleMapper;


    /**
     * 根据id获取用户
     *
     * @param id
     */
    @Override
    public People getPeopleByid(int id) {

        System.out.println(id+"================================================");
        People p = peopleMapper.selectByPrimaryKey(id);
        return p;

    }
}
