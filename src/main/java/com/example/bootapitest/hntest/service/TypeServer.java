package com.example.bootapitest.hntest.service;

import com.example.bootapitest.hntest.dto.TypeExponentDto;
import com.example.bootapitest.hntest.entity.TypeExponent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TypeServer {


    /**
     * 获取数据
     */
    List<TypeExponentDto> getTypeExponent();
}
