package com.example.bootapitest.bookschema.fiveprototype.bacecopy;

public class Student implements Cloneable{

    String name;
    int age;
    Address add;

    public Student(String name, int age, Address add) {
        this.name = name;
        this.age = age;
        this.add = add;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.setAdd((Address) add.clone());
        return student;
    }

    public Student(Student s){
        this.name = s.getName();
        this.age = s.getAge();
        this.add = new Address(s.getAdd());
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
