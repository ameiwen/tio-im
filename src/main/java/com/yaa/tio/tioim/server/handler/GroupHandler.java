package com.yaa.tio.tioim.server.handler;

import com.yaa.tio.tioim.server.model.ChannelReq;
import com.yaa.tio.tioim.server.processor.ServerProcessor;
import org.tio.core.ChannelContext;
import org.tio.websocket.common.WsRequest;

/**
 * 群组消息
 */
public class GroupHandler extends ServerProcessor {

    @Override
    public void handleMessage(WsRequest wsRequest, ChannelReq channelReq, ChannelContext channelContext) throws Exception {

    }
}
