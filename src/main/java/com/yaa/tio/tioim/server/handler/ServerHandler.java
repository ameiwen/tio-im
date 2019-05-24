package com.yaa.tio.tioim.server.handler;

import com.alibaba.fastjson.JSON;
import com.yaa.tio.tioim.conf.TioProperties;
import com.yaa.tio.tioim.server.common.Const;
import com.yaa.tio.tioim.server.model.ChannelReq;
import com.yaa.tio.tioim.server.processor.ServerProcessor;
import com.yaa.tio.tioim.util.WsResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.server.handler.IWsMsgHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServerHandler extends AbsServerHandler implements IWsMsgHandler {

	private static Logger logger = LoggerFactory.getLogger(ServerHandler.class);

	private static final Map<String, ServerProcessor> handlerMap = new ConcurrentHashMap<>();

	static {
		//单对单消息
		handlerMap.put(Const.ONE_TO_ONE_CHANNEL, new OneToOneHandler());
		//群组消息
		handlerMap.put(Const.ONE_TO_GROUP_CHANNEL, new GroupHandler());
		//系统消息(比如加好友,加群请求)
		handlerMap.put(Const.SYSTEM_CHANNEL,new SystemHandler());
		//初始化
		handlerMap.put(Const.ACCOUNT_INIT_CHANNEL,new InitHandler());
	}

	/**
	 * 字符消息（binaryType = blob）过来后会走这个方法
	 */
	@Override
	public Object onText(WsRequest wsRequest, String text, ChannelContext channelContext) throws Exception {
		ChannelReq channelReq = JSON.parseObject(text, ChannelReq.class);
		if (channelReq.getChannel().equals(TioProperties.HEART_BEAT)) {
			Map<String, Object> heart = new HashMap<>();
			heart.put("pong", new Date().getTime());
			Tio.send(channelContext, WsResultUtil.buildResponseByJson(heart));
		}
		if (channelReq != null) {
			ServerProcessor server = handlerMap.get(channelReq.getChannel());
			if (server != null) {
				if(Const.ONE_TO_GROUP_CHANNEL.equals(channelReq.getChannel())) {
					Tio.bindGroup(channelContext,channelReq.getGroup());
				}else if(Const.SYSTEM_CHANNEL.equals(channelReq.getChannel())){
					Tio.bindGroup(channelContext,channelReq.getChannel()+channelReq.getUid());
				}
				server.handleMessage(wsRequest, channelReq, channelContext);
			}
		}
		return null;
	}

}
