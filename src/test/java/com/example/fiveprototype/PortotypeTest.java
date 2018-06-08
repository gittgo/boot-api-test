package com.example.fiveprototype;


import com.example.bootapitest.bookschema.fiveprototype.testSerializable.Address;
import com.example.bootapitest.bookschema.fiveprototype.testSerializable.Student;
import com.example.bootapitest.bookschema.fiveprototype.testSerializable.StudentDoubl;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class PortotypeTest {

    @Test
    public void testPorto()throws IOException{

        Address address = new Address("天津市","南开区","300000");
        Student student = new Student("tom",22, address);

        // 对象输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("c:/student.txt")));
        objectOutputStream.writeObject(student); // 序列化
        objectOutputStream.close();
    }

    @Test
    public void testPortoReturn() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("c:/student.txt")));
        StudentDoubl student = (StudentDoubl) objectInputStream.readObject();
        System.out.println( student.getName());
        System.out.println( student.getAge());
        System.out.println( student.getAdd().getCity());

    }
//
//    2018-06-07 21:46:06,794:INFO main (StartupInfoLogger.java:57) - Started PortotypeTest in 2.622 seconds (JVM running for 3.979)
//    tom
//    22
//    南开区
}
