package com.example.bootapitest.bookschema.twoSingleton;

import java.io.File;
import java.io.FileWriter;

public class TesterLog {

    public void log (String s){
        try{
            File file = new File("c:/test/test.log");
            FileWriter wr = new FileWriter(file);
            wr.write(s);
            wr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
