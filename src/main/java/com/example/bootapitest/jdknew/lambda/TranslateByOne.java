package com.example.bootapitest.jdknew.lambda;

import java.awt.*;

public class TranslateByOne implements PointAction {

    @Override
    public void doForPoint(Point point) {
        point.translate(1,1);
    }
}
