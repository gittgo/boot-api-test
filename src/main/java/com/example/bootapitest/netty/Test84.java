package com.example.bootapitest.netty;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wang cheng wei
 * @date 2019-3-1 10:48
 */
public class Test84 {

    double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
       double PI = 3.1415926535897932384626;
       double a = 6378245.0;
       double ee = 0.00669342162296594323;

              /**
   1      * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换
   12      * 即 百度 转 谷歌、高德
   13      * @param bd_lon
   14      * @param bd_lat
   15      * @returns {*[]}
   16      */
             public List bd09togcj02(double bd_lon, double bd_lat){
                double x = bd_lon - 0.0065;
                double y = bd_lat - 0.006;
                double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_PI);
                double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_PI);
                 double gg_lng = z * Math.cos(theta);
                double gg_lat = z * Math.sin(theta);
//                 Point point=new Point();
//                 point.setLocation(gg_lng,gg_lat);
                 List<Double> list = new ArrayList();
                 list.add(gg_lng);
                 list.add(gg_lat);
                 return list;
            }

    /**
     66      * GCJ02 转换为 WGS84
     67      * @param lng
     68      * @param lat
     69      * @returns {*[]}
     70      */
      public List gcj02towgs84(double lng, double lat){
                double dlat = transformlat(lng - 105.0, lat - 35.0);
                 double dlng = transformlng(lng - 105.0, lat - 35.0);
                 double radlat = lat / 180.0 * PI;
                 double magic = Math.sin(radlat);
                 magic = 1 - ee * magic * magic;
                 double sqrtmagic = Math.sqrt(magic);
                 dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
                 dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
                 double mglat = lat + dlat;
                 double mglng = lng + dlng;
                Point point=new Point();point.setLocation(mglng, mglat);
          List list = new ArrayList();
          list.add(mglng);
          list.add(mglat);
          return list;
//                 return point;
             };

    private double transformlat(double lng,double lat){
                 double ret= -100.0 + 2.0 * lng + 3.0 * lat + 0.2 * lat * lat + 0.1 * lng * lat + 0.2 * Math.sqrt(Math.abs(lng));
                ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
                ret += (20.0 * Math.sin(lat * PI) + 40.0 * Math.sin(lat / 3.0 * PI)) * 2.0 / 3.0;
                ret += (160.0 * Math.sin(lat / 12.0 * PI) + 320 * Math.sin(lat * PI / 30.0)) * 2.0 / 3.0;
               return ret;
             }

              private double transformlng(double lng,double lat){
                 double ret = 300.0 + lng + 2.0 * lat + 0.1 * lng * lng + 0.1 * lng * lat + 0.1 * Math.sqrt(Math.abs(lng));
                 ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
                 ret += (20.0 * Math.sin(lng * PI) + 40.0 * Math.sin(lng / 3.0 * PI)) * 2.0 / 3.0;
                 ret += (150.0 * Math.sin(lng / 12.0 * PI) + 300.0 * Math.sin(lng / 30.0 * PI)) * 2.0 / 3.0;
                 return ret;
             }


        public static void main(String[] args) {
            Test84 test84 = new Test84();
            List<Double> pointH = test84.bd09togcj02(39.1055993255,117.1721677145);
            List point = test84.gcj02towgs84(Double.valueOf(pointH.get(0)),Double.valueOf(pointH.get(1)));
            System.out.println(point);
//       num;
//double[] num = lonLat2Mercator(120.385222, 36.061416);
//System.err.println(num[0]+"  "+num[1]);
//      for (int i = 0; i < num.length; i++) {
//          System.out.println(num[0]+"  "+num[1]);
//      }
}
}
