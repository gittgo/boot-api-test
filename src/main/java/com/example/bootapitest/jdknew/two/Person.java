package com.example.bootapitest.jdknew.two;

public class Person {

    String firstName;
    String lastName;

   public Person(){}

   public Person(String fiestName,String lastName){
        this.firstName = fiestName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
