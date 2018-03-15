package com.example.bootapitest.hntest.entity;


import javax.persistence.*;
import java.util.List;

@Table(name = "fun_exponent")
@Entity
public class FunExponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String country;

    @Column
    private String exponent;

    @Column
    private int tId;


    private List<TypeExponent> typeExponents;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }


    public List<TypeExponent> getTypeExponents() {
        return typeExponents;
    }

    public void setTypeExponents(List<TypeExponent> typeExponents) {
        this.typeExponents = typeExponents;
    }
}
