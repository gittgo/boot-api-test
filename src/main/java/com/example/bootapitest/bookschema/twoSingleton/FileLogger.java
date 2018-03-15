package com.example.bootapitest.bookschema.twoSingleton;

import com.example.bootapitest.help.DateUtil;

import java.io.FileOutputStream;
import java.util.Date;

public class FileLogger {

    // 日志路径
    private String path = "/Users/rock/IdeaProjects/boot-api-test/src/main/java/com/example/bootapitest/bookschema/twoSingleton/log";

    private FileOutputStream out;
    private FileLogger() throws Exception{
        out = new FileOutputStream(path,true);
        System.out.println("This is new instance");
    }

    public void write(String msg){
        try {
            String strTime = DateUtil.formatDateTime(new Date());

            byte buf[] = strTime.getBytes("UTF-8");
            out.write(buf);

            String strContent = "conten:\r\n"+msg+"\r\n";
            buf = strContent.getBytes("UTF-8");
            out.write(buf);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static class My{
        static FileLogger log;
        static {
            try{
                log = new FileLogger();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static FileLogger getInstance(){
        return My.log;
    }
}
