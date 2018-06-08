package com.example.bootapitest.bookschema.fiveprototype.testSerializable;

import java.io.Serializable;

public class StudentDoubl implements Serializable{

//    private static final long serialVersionUID = 1L;


    String name;
    int age;
    Address add; // 籍贯信息

   public StudentDoubl(String na, int a, Address add){
        this.name = na;
        this.age = a;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

}
