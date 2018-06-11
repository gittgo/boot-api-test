package com.example.bootapitest.bookschema.twoSingleton;

import java.io.File;
import java.io.FileWriter;

public class TesterLog {

    public void log (String s){
        try{
            FileWriter  file = new FileWriter ("c:/test/test.log",true);
            file.write(s);
            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
