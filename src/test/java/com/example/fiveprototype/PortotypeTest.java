package com.example.fiveprototype;


import com.example.bootapitest.bookschema.fiveprototype.testSerializable.Address;
import com.example.bootapitest.bookschema.fiveprototype.testSerializable.Student;
import com.example.bootapitest.bookschema.fiveprototype.testSerializable.StudentDoubl;
import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.jdknew.two.Person;
import com.example.bootapitest.people.entity.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

    @Test
    public void testconsumer(){
        People userT = new People("zm");
        //接受一个参数
        Consumer<People> userTConsumer = userT1 -> userT1.setName("zmChange");
        userTConsumer.accept(userT);
        System.out.println(userT.getName());
        System.out.println(userTConsumer.getClass());
    }

    @Test
    public void testFunction(){
        Function<String,Integer> toInteger = Integer::valueOf;
        Function<String,String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");
        int function = toInteger.apply("1");
    }

    @Test
    public void testSupplier(){
        Supplier<Person> personSupplier = Person::new;
        Person p = personSupplier.get();   // new Person
    }

    @Test
    public void testConsumer(){
        Consumer<Person> greeter = (p) -> System.out.println("Hello,"+p.getFirstName());
        greeter.accept(new Person("L","cy"));
    }

    @Test
    public void testComparator(){
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0
    }

    @Test
    public void testOptional(){
        Optional<String> optional = Optional.of("bam");
        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }

    @Test
    public void testStream(){
        // 使用Stream.forEach()迭代
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(str -> System.out.println(str));
    }

    @Test
    public void testFilter(){
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
// "aaa2", "aaa1"
    }



//
//    2018-06-07 21:46:06,794:INFO main (StartupInfoLogger.java:57) - Started PortotypeTest in 2.622 seconds (JVM running for 3.979)
//    tom
//    22
//    南开区



}
