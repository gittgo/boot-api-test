package com.example.bootapitest.jdknew.lambda;

import java.awt.*;
import java.util.function.Consumer;

public class TranslateConsumerByOne implements Consumer<Point> {

    @Override
    public void accept(Point point) {
        point.translate(1,1);
    }
}
