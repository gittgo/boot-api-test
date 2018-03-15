package com.example.bootapitest.hntest.service;


import com.example.bootapitest.hntest.dto.TypeExponentDto;
import com.example.bootapitest.hntest.entity.TypeExponent;
import com.example.bootapitest.hntest.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class TypeServerImpl implements TypeServer{

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 获取数据
     *
     */
    @Override
    public List<TypeExponentDto> getTypeExponent() {
        System.out.println("================================================");
        List<TypeExponentDto> p = typeMapper.selectByMyThink();
        return p;
    }
}
