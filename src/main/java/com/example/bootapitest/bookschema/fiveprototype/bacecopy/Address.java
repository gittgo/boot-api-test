package com.example.bootapitest.bookschema.fiveprototype.bacecopy;

import java.io.Serializable;

public class Address implements Cloneable{

    String pro;
    String city;
    String zip;

    public Address(String p, String c, String z){
        pro = p;city=c;zip =z;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Address s = (Address) super.clone();
        return s;
    }

    public Address(Address address){
        this.pro = address.getPro();
        this.city = address.getCity();
        this.zip = address.getZip();
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
