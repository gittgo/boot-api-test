package com.example.pagehelper;

import com.example.bootapitest.bookschema.oneReflect.FileMsg;
import com.example.bootapitest.bookschema.oneReflect.IMsg;
import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.people.controller.HelloController;
import com.example.bootapitest.people.entity.People;
import com.example.bootapitest.people.service.PeopleServer;
import com.example.bootapitest.people.service.PeopleServerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class PageHelperTests {

	@Test
	public void pageHelperTest() throws Exception{
//		HelloController helloController = new HelloController();
//		helloController.getList(1);
//
//        PeopleServer peopleServer = new PeopleServerImpl();
//        List<People> peopleList = peopleServer.select();
//        System.out.println(peopleList.size());
    }




}
