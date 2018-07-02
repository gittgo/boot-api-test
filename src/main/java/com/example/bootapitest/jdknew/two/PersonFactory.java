package com.example.bootapitest.jdknew.two;

public interface PersonFactory<P extends Person> {

     P create(String firestName,String lastName);





}
