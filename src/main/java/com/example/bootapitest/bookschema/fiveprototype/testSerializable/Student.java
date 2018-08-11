package com.example.bootapitest.bookschema.fiveprototype.testSerializable;

import java.io.*;

public class Student  implements Cloneable,Serializable{

//    private static final long serialVersionUID = 1L;


    String name;
    int age;
    Address add; // 籍贯信息

   public Student(String na,int a,Address add){
        this.name = na;
        this.age = a;
        this.add = add;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
       Object object = null;
       try {
           ByteArrayOutputStream bos = new ByteArrayOutputStream();
           ObjectOutputStream oos = new ObjectOutputStream(bos);
           oos.writeObject(this);
           // 从流中读取
           ByteArrayInputStream ios = new ByteArrayInputStream(bos.toByteArray());
           ObjectInputStream ois = new ObjectInputStream(ios);
           object = ois.readObject();
       }catch (Exception e){e.printStackTrace();}
       return object;
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
