package com.example.bootapitest.people.mapper;


import com.example.bootapitest.people.entity.People;
import com.github.abel533.mapper.Mapper;
import org.mybatis.spring.annotation.MapperScan;


@MapperScan
public interface PeopleMapper extends Mapper<People> {



}
