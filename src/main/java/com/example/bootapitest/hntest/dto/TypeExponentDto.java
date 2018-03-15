package com.example.bootapitest.hntest.dto;


import com.example.bootapitest.hntest.entity.FunExponent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

public class TypeExponentDto {

    private int id;

    private int tId;

    private String tName;

    private String content;


    List<FunExponent> funExponents;

    public List<FunExponent> getFunExponents() {
        return funExponents;
    }

    public void setFunExponents(List<FunExponent> funExponents) {
        this.funExponents = funExponents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
