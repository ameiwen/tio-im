package com.yaa.tio.tioim.util;

import com.alibaba.fastjson.JSON;
import com.yaa.tio.tioim.conf.TioProperties;
import org.tio.websocket.common.WsResponse;

import java.io.UnsupportedEncodingException;

public class WsResultUtil {

    public static WsResponse buildResponseByJson(Object obj){
        WsResponse wsResponse = WsResponse.fromText(JSON.toJSONString(obj), TioProperties.CHARSET);
        return wsResponse;
    }

    public static WsResponse buildResponseByByte(Object obj){
        WsResponse wsResponse = null;
        try {
            wsResponse = WsResponse.fromBytes(JSON.toJSONString(obj).getBytes(TioProperties.CHARSET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return wsResponse;
    }

    public static WsResponse buildResponseByText(String message){
        WsResponse  wsResponse = WsResponse.fromText(message,TioProperties.CHARSET);
        return wsResponse;
    }

}
