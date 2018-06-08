package com.example.bootapitest.bookschema.fiveprototype.testSerializable;

import java.io.Serializable;

public class Address implements Serializable{

    String pro;
    String city;
    String zip;

    public Address(String p,String c,String z){
        pro = p;city=c;zip =z;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
