package com.example.jdknewTest;


import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.jdknew.oneinterface.DefaultBt;
import com.example.bootapitest.jdknew.oneinterface.DefaultClass;
import com.example.bootapitest.jdknew.two.Person;
import com.example.bootapitest.jdknew.two.PersonFactory;
import com.sun.xml.internal.ws.util.xml.XmlUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import java.rmi.RemoteException;


import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class DefaultTest {
    @Test
    public void testDefaultA(){
        //Collection
        DefaultClass defaultClass = new DefaultClass();
        defaultClass.dmath();
        defaultClass.dmathtt();
    }

    @Test
    public void  lambda(){

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o2.compareTo(o1));
                return o2.compareTo(o1);
            }
        });
//        for (String s :names){
//            System.out.println(s);
//        }
    }

    @Test
    public void TestInt(){
        DefaultBt<String,Integer>  defaultBt = (form) -> Integer.valueOf(form);
        Integer integer = defaultBt.convert("123");
        System.out.println(integer);
    }


    @Test
    public void TestFactory(){
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person.getFirstName());
    }


    @Test
    public void testCallFinal(){


        Integer sss = 2;
        Converter<Integer, String> s =(param) -> {
            return String.valueOf(param + sss);
        };
        System.out.println(s.convert(2));
    }

    @Test
    public void testPredicate(){
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        Predicate<Float> isFloat = a-> Float.isNaN(a);
    }


    @Test
    public void testFunction(){
//        Function<String, Integer> toInteger = Integer::valueOf;
//        Function<String, String> backToString = toInteger.andThen(String::valueOf);
////        Function<String, String> backToStringc = toInteger.compose(String::valueOf);
//        String t = backToString.apply("123");     // "123"
//        Integer ts = toInteger.apply("123");
//
//        char a = 'a';
//        System.out.println(123);

        DefaultClass defaultClass = new DefaultClass();
        System.out.println(defaultClass.ttt(8));

        StringBuffer ss = new StringBuffer("sss");
        ss.append("ss");

        String s = "ttt";
        String aaa = s.concat("ss");
    }


    @Test
    public void testbuffer(){
        StringBuffer str1 = new StringBuffer("good");
        StringBuffer str2 = new StringBuffer("bad");
        DefaultClass defaultClass = new DefaultClass();
        ExecutorService es = Executors.newSingleThreadExecutor();

        try{
            es.submit(defaultClass);
        }catch (Exception e){
            e.printStackTrace();
        }

        defaultClass.change(str1,str2);
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testwebservice(){
        String url = "http://imes.rockcheck.com:8857/Service.asmx";
        String namespace = "http://tempuri.org/";
        String methodName = "isProd";

        Service service = new Service();
        Call call;
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            call.setUseSOAPAction(true);
            call.setReturnType(XMLType.XSD_STRING);
            call.setOperationName(new QName(url,methodName));
            call.setSOAPActionURI(namespace+methodName);
            call.addParameter(new QName(url, "materialCode"),XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);

            System.out.println(new Object[]{"82100191003"});
            String ss = "82100191003";
            String[] materialCode = new String[1];
            materialCode[0] = "82100191003";
            System.out.println(materialCode);
            System.out.println(materialCode[0]);

            String result = (String) call.invoke(new Object[] { "82100191003" });

            System.out.println(result);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testtwo()throws RemoteException, ServiceException{
        Service service = new Service() ;
        Call call = null;
        call = (Call) service.createCall();
        call.setTargetEndpointAddress("http://imes.rockcheck.com:8857/Service.asmx") ;
        call.setOperationName(new QName("http://imes.rockcheck.com:8857/Service.asmx","isProd"));//ws方法名
        //一个输入参数,如果方法有多个参数,复制多条该代码即可,参数传入下面new Object后面
        call.addParameter("materialCode",org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN) ;
        call.setReturnType(XMLType.XSD_STRING) ;
        call.setUseSOAPAction(true) ;
        call.setSOAPActionURI("http://tempuri.org/isProd");


        String[] head = {"物料编码"};
        String[][] body = new String[1][];
        body[0] = new String[1];
        body[0][0]="82100191003";
        String xml =  com.example.bootapitest.jdknew.two.XmlUtil.tableFormatXml(head,body);

        System.out.println(xml);
//        sendString[0] = "82100191003";

        String result = (String) call.invoke(new Object[] { xml });

        System.out.println(result);


    }


    @Test
    public void testtwo2()throws Exception{
        Service service = new Service() ;
        Call call = null;
        String methodName = "isProd";
        call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL("http://imes.rockcheck.com:8857/Service.asmx"));
        call.setUseSOAPAction(true);
        call.setReturnType(new QName("http://www.w3.org/2001/XMLSchema","string"));
        call.setOperationName(new QName("http://tempuri.org/",methodName));
        call.setSOAPActionURI("http://tempuri.org/isProd");
        call.addParameter(new QName("http://tempuri.org/","materialCode"),XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);

//        String[] head = {"物料编码"};
//        String[][] body = new String[1][];
//        body[0] = new String[1];
        String xml ="82100191003";
//        String xml =  com.example.bootapitest.jdknew.two.XmlUtil.tableFormatXml(head,body);

//        System.out.println(xml);
//        sendString[0] = "82100191003";

        String result = (String) call.invoke(new Object[] { xml });

        System.out.println(result);


    }

    // Date API
    @Test
    public void testClock(){
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        Instant instant = clock.instant();
        Date date = Date.from(instant);
    }

    @Test
    public void testTimezones(){
//        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zoneId1 = ZoneId.of("Europe/Berlin");
        ZoneId zoneId2 = ZoneId.of("Brazil/East");

//        System.out.println(zoneId1.getRules());
//        System.out.println(zoneId2.getRules());

        LocalTime now1 = LocalTime.now(zoneId1);
        LocalTime now2 = LocalTime.now(zoneId2);
//        System.out.println(now1.isBefore(now2));  // true

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

//        System.out.println(hoursBetween);       // 19
//        System.out.println(minutesBetween);     // 1140

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37

    }







}
