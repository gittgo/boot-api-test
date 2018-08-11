package com.example.bookschema.fiveprototype;

import com.example.bootapitest.bookschema.fiveprototype.testSerializable.Address;
import com.example.bootapitest.bookschema.fiveprototype.testSerializable.Student;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class CloneTest {


    @Test
    public void testbasClone() throws CloneNotSupportedException {
//        Address adr = new Address("tianjin","tj","hedong");
//        Student st1 = new Student("zhang",20,adr);
//        Student st2 = (Student)st1.clone();
//
//        System.out.println(st1);
//        System.out.println(st2);
//        System.out.println(st1.getAdd());
//        System.out.println(st2.getAdd());
    }

    @Test
    public void testSerializable() throws CloneNotSupportedException {
        Address adr = new Address("tianjin","tj","hedong");
        Student st1 = new Student("zhang",20,adr);
        Student st2 = (Student)st1.clone();

        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st1.getAdd());
        System.out.println(st2.getAdd());
    }
}
