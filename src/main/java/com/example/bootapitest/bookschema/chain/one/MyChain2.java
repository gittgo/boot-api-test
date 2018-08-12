package com.example.bootapitest.bookschema.chain.one;

import java.io.FileInputStream;
import java.util.Properties;

public class MyChain2 {
    private Handler handler[];

    public void createChain(){
        try{
//            String path = this.getClass().getResource("/").getPath();
//            FileInputStream fileInputStream = new FileInputStream(path+"myconfig.txt");
//            Properties properties = new Properties();
//            properties.load(fileInputStream);
            String chain = "com.example.bootapitest.bookschema.chain.one.com.example.bootapitest.bookschema.chain.ZuZhang,one.ZhuRen,com.example.bootapitest.bookschema.chain.one.JingLi";// properties.getProperty("chain");
            String[] chains = chain.split(",");
            int n = chains.length;
            handler = new Handler[n];
            for(int i=0 ;i<n;i++){
                handler[i] = (Handler)Class.forName(chains[i]).newInstance();
            }
            for (int i=0;i<n-1;i++){
                handler[i].setNext(handler[i+1]);
            }
        }catch ( Exception e){
            e.printStackTrace();
        }
    }

    public void handle(Request request){
        handler[0].handle(request);
    }
}
