package com.example.bootapitest.netty.day07FrameDecoder.netty7;

import java.io.Serializable;

/**
 * @author wang cheng wei
 * @date 2019-9-18 17:14
 */
public class SubscribeResp implements Serializable {
    private static final long serialVersionUID = 6047331206745192557L;

    private int subReqID;

    private int respCode;

    private String desc;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SubscribeResp{" +
                "subReqID=" + subReqID +
                ", respCode=" + respCode +
                ", desc='" + desc + '\'' +
                '}';
    }
}
