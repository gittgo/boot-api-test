package com.example.bootapitest.hntest.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "type_exponent")
@Entity
public class TypeExponent {

    @Id
    private int id;

    @Column
    private int tId;

    @Column
    private String tName;

    @Column
    private String content;


//    List<FunExponent> funExponents;

//    public List<FunExponent> getFunExponents() {
//        return funExponents;
//    }
//
//    public void setFunExponents(List<FunExponent> funExponents) {
//        this.funExponents = funExponents;
//    }



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
