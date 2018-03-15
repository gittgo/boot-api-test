package com.example.oneReflectTest;

import com.example.bootapitest.bookschema.oneReflect.FileMsg;
import com.example.bootapitest.bookschema.oneReflect.IMsg;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class ReflectTests {

	@Test
	public void contextLoads() throws Exception{
        IMsg obj = null;
        obj = (IMsg)Class.forName("com.example.bootapitest.bookschema.oneReflect.FileMsg").newInstance();
        obj.process("Hello word");

        obj =(IMsg) Class.forName("com.example.bootapitest.bookschema.oneReflect.ConsoleMsg").newInstance();
        obj.process("Hello word");
	}


	@Test
    public void testProperties() throws Exception{
        Properties p = new Properties();
        p.load(new FileInputStream("/Users/rock/IdeaProjects/boot-api-test/src/main/resources/msg.properties"));
        String cname = p.getProperty("func");
        IMsg obj = null;
        obj = (IMsg)Class.forName(cname).newInstance();
        obj.process("hello word");
    }

    @Test
    public void testChage() throws Exception{
        FileMsg ref = new FileMsg();
        System.out.println("改变之前："+ref.getSsss());
        //通过先得到它的字节码，反射得到它的成员变量
        Field[] fields = ref.getClass().getFields();
        for(Field field :fields){
            //这里要用==
            if(field.getType() == String.class){
                String oldValue =(String)field.get("ssss");
                String newValue = oldValue.replace("ssss","a");
                field.set("ssss","a");
            }
        }
        System.out.println("改变之后："+ref.getSsss());

    }

    @Test
    public void testVecor()throws Exception{
	    Class classinfo = Class.forName("java.util.Vector");
	    // 获得构造函数
        System.out.println("构造函数：");
        Constructor constructor[] = classinfo.getConstructors();
        for (int i = 0;i<constructor.length;i++){
            System.out.println(constructor[i].toString());
        }
        // 获得类的多有变量
        System.out.println("变量：");
        Field field[] = classinfo.getDeclaredFields();
        for (Field s:field) {
            System.out.println(s.toString());
        }
        // 获取方法：
        System.out.println("方法：");
        Method methods[] = classinfo.getMethods();
        for (Method ss:methods) {
            System.out.println(ss.toString());
        }

	}

}
