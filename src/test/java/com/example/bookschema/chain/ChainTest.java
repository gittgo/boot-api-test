package com.example.bookschema.chain;

import com.alibaba.dubbo.common.json.JSONObject;
import com.example.bootapitest.bookschema.chain.one.*;
import com.example.bootapitest.config.TaotaoApplication;
import com.streamax.mp4.H264ToMp4;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class ChainTest {

    @Test
    public void testChain(){

        JSONObject video = new JSONObject();
//        String h264FilePath ="C:\\Users\\admin\\Desktop\\02_09_6501_0_1574661055474.h264";
//        String h264FilePath ="D:\\work\\idea\\ideawork\\netty\\boot-api-test\\src\\main\\java\\com\\example\\bootapitest\\netty\\02_09_6501_0_1574661055474.h264";
        String h264FilePath ="com/example/bootapitest/netty/02_09_6501_0_1574661055474.h264";
        String mp4FilePath = h264FilePath.replaceAll("h264", "mp4");
//        h264FilePath = h264FilePath.replaceAll("C:/Users/admin/Desktop/", "C:/Users/admin/Desktop/");
//        mp4FilePath = mp4FilePath.replaceAll("C:/Users/admin/Desktop/", "C:/Users/admin/Desktop/");
//        File h264File = new File(h264FilePath);
//        File mp4File = new File(mp4FilePath);
//        if (h264File.exists() && !mp4File.exists() && h264File.getName().contains("h264")) {
//        com/example/bootapitest/netty/02_09_6501_0_1574661055474.h264

        H264ToMp4 h264ToMp4 = new H264ToMp4();
        int res = h264ToMp4.Converth264ToMp4(h264FilePath, "com/example/bootapitest/netty/02_09_6501_0_157466105547455.h264");
//        }
//        String videoPath = constant.videoIpPath + basicParametersDao.getAbsolutePath() + alarmFile.getFilePath().replaceAll("h264", "mp4");
//        videoArray.add(videoPath);

//        String timestamp =  (new Date()).getTime()/1000+"";
//        System.out.println(timestamp);
//        Request request = new Request(3);
//        MyChain2 myChain = new MyChain2();
//        myChain.createChain();
//        myChain.handle(request);
    }


    @Test
    public void testfor(){
        List<Integer>
        list = null;
//        for (int i: list) {
//            System.out.println("true");
//        }
        if(list.isEmpty()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
