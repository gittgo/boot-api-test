package com.example.bootapitest.jdknew.lambda;

import java.awt.*;
import java.util.ArrayList;

public class PointArrayList extends ArrayList<Point> {


    public void forEach(PointAction pointAction) {
        for (Point p:this){
            pointAction.doForPoint(p);
        }
    }
}
