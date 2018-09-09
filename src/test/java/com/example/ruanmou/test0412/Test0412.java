package com.example.ruanmou.test0412;


import com.example.bootapitest.bookschema.fiveprototype.testSerializable.Student;
import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.people.entity.People;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.*;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class Test0412 {

    @Test
    public void testgetclass() throws ClassNotFoundException {
        // 通过本身获取
        System.out.println(People.class);
        // 通过实例获取
        People people = new People();
        System.out.println(people.getClass());
        // 通过Class中提供的静态forName获取
        Class clazz = Class.forName("com.example.bootapitest.people.entity.People");
        System.out.println(clazz);
    }

    @Test  // 获取成员变量
    public void testGetClassField() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        System.out.println("----获取一个对象的成员变量---");
        Class clazz = People.class;
        Field[] fileds = clazz.getFields();  // 只能获取 public 修饰的变量
         fileds = clazz.getDeclaredFields();   // 获取所有
        System.out.println("-------------------");
        for (Field f :
                fileds) {
            System.out.println(f);
            System.out.println("访问修饰符"+ Modifier.toString(f.getModifiers()));
            System.out.println("字段类型"+f.getType().getName());
            System.out.println("字段类型简单名称"+f.getType().getSimpleName());
            System.out.println("字段名称"+f.getName());
        }
        // 通过class对象创建类实例
        Object instance = clazz.newInstance();
        //  单独获取一个字段访问权限
        Field field = clazz.getDeclaredField("age");
        // 开启访问权限
        field.setAccessible(true);
        // 设置年龄
        field.set(instance,20);
        //
        if(instance instanceof People){
            People people = (People) instance;
            System.out.println(people.getAge());
        }
    }

    // 反射method  获取方法信息
    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        System.out.println("------设置方法---------");
        Class clazz = People.class;
        //
        Method[] methods = clazz.getMethods();
        //
        System.out.println("------");
        for (Method me : methods) {
            System.out.println(me);
            System.out.println("-----访问修饰符"+Modifier.toString(me.getModifiers()));
            System.out.println("-----方法返回类型"+me.getReturnType());
            System.out.println("-----方法名称"+me.getName());
            System.out.println("-----参数类型"+ Arrays.toString(me.getParameterTypes()));
            System.out.println("-----参数个数"+me.getParameterCount());
            System.out.println("-----参数数组"+Arrays.toString(me.getParameters()));
        }
        //  设置方法请求
        // 创建一个 student
        People student = new People();
        Method method = clazz.getDeclaredMethod("setAge",Integer.class);
        //
        method.setAccessible(true);
        //
        Object object = method.invoke(student,12);
//        People people = (People) object;
        System.out.println(student.getAge());
    }


}
