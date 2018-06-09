package com.example.bootapitest.people.service;


import com.example.bootapitest.people.entity.People;
import com.example.bootapitest.people.mapper.PeopleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    @Override
    public List<People> select() {
        //为了程序的严谨性，判断非空：
        Integer page = 2;
        Integer rows = 10;
         if(page == null){
                 page = 1;   //设置默认当前页
             }
         if(page <= 0){
                 page = 1;
             }
         if(rows == null){
                 rows = 30;    //设置默认每页显示的商品数(因为jsp页面上默认写的就是30条)
             }

         //1、设置分页信息，包括当前页数和每页显示的总计数
         PageHelper.startPage(page, rows);
         People people = new People();
         //2、执行查询
         List<People> list = peopleMapper.select(people);
         //3、获取分页查询后的数据
         PageInfo<People> pageInfo = new PageInfo<>(list);
         //设置数据集合rows：
        List<People> peopleList = pageInfo.getList();
        System.out.println(peopleList.size());

        return null;
    }
}
