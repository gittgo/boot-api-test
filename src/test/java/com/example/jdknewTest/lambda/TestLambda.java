package com.example.jdknewTest.lambda;


import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.jdknew.lambda.PointAction;
import com.example.bootapitest.jdknew.lambda.PointArrayList;
import com.example.bootapitest.jdknew.lambda.TranslateByOne;
import com.example.bootapitest.jdknew.lambda.TranslateConsumerByOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class TestLambda {


    @Test
    public void testForEash(){

//        List<Point> pointList = new ArrayList<Point>();
//        pointList.add(new Point(2,3));
//        pointList.add(new Point(3,4));
//        pointList.add(new Point(6,9));
//        //
//        for (Iterator iterator = pointList.iterator(); iterator.hasNext();){
//            ((Point)iterator.next()).translate(1,1);
//        }
        //


//        PointArrayList pointList = new PointArrayList();
//        pointList.add(new Point(2,3));
//        pointList.add(new Point(3,4));
//        pointList.add(new Point(6,9));
//        pointList.forEach(new TranslateByOne());

        // 定义  accept 执行方法
//        List<Point> pointList = Arrays.asList(new Point(2,3),new Point(3,6),new Point(9,9));
//        pointList.forEach(new TranslateConsumerByOne());

        // 匿名内部类
//        pointList.forEach(new Consumer<Point>() {
//            public void accept(Point point) {
//                point.translate(1,1);
//            }
//        });

        //  lambde
//        pointList.forEach(point -> point.translate(1,1));
//        System.out.println(pointList.get(0).getLocation());

        //

        // 1.2 从集合到流

        // 一般方法
//        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
//        List<Point> pointList = new ArrayList<>();
//        for (Integer integer:integerList){
//            pointList.add(new Point(integer % 3,integer));
//        }
//        double maxDistance = Double.MIN_VALUE;
//        for (Point point:pointList) {
//            maxDistance = Math.max(point.distance(0,0),maxDistance);
//        }

         //
//        IntStream intStream = IntStream.of(1,2,3,4,5);
        // lambda
//        OptionalDouble max = integerList.stream().map(i -> new Point( i%3,i/2))
//                .mapToDouble(p->p.distance(0,0)).max();

        // 并行化
//        OptionalDouble maxDistance = integerList.parallelStream().map(i -> new Point( i%3,i/2))
//                .mapToDouble(p->p.distance(0,0)).max();


        Map<String,String> map = new HashMap<>();
        map.put("120004","张4");
        map.put("120005","张5");
        map.put("120003","张3");
        map.put("120001","张1");
        map.put("120002","张2");
        map.put("120002","张2");

        //
        TreeMap<String,String> treeMap = new TreeMap<>(map);
        //
        TreeMap<String, String> treeMap2 = new TreeMap<String, String>(new Comparator<String>(){
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
//        treeMap2.putAll(map);

//        TreeMap<String, String> treeMap3 = new TreeMap<String, String>(map);

//        treeMap3.forEach((a, b) -> b.compareTo(a));
//        Collections.sort(treeMap3.keySet(), (String a, String b) -> b.compareTo(a));
//        treeMap3.keySet().stream((a,b) -> b.compareTo(a));
        //
        treeMap2.putAll(map);
        List<String> listKey = new ArrayList<>(treeMap2.keySet());
        if(listKey.size()>2){
            Map sortedMap = treeMap2.subMap(listKey.get(0),listKey.get(2));
        }
        System.out.println("========");
        System.out.println("========");

        UnaryOperator<Integer> b = x -> x.intValue();
















    }
}
