package com.example.bootapitest.jdknew.oneinterface;

import org.springframework.core.convert.converter.Converter;

public class LambdaStatic {

    static int outerStaticNum;
    int outerNum;
        void testScopes () {
            Converter<Integer, String> converter = (form) -> {
                outerNum = 23;
                return String.valueOf(form);
            };

            Converter<Integer, String> converter2 = (form) -> {
                outerStaticNum = 72;
                return String.valueOf(form);
            };
        }

}
