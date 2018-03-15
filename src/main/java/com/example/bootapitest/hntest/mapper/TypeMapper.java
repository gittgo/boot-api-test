package com.example.bootapitest.hntest.mapper;


import com.example.bootapitest.hntest.dto.TypeExponentDto;
import com.example.bootapitest.hntest.entity.TypeExponent;
import com.example.bootapitest.people.entity.People;
import com.github.abel533.mapper.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;



@MapperScan
public interface TypeMapper extends Mapper<TypeExponent> {



    List<TypeExponentDto> selectByMyThink();


}
