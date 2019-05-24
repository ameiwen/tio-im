package com.yaa.tio.tioim.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.websocket.server.WsServerAioListener;

/**
 * 用户根据情况来完成该类的实现
 */
@Component
public class ServerListener extends WsServerAioListener {

	private static Logger log = LoggerFactory.getLogger(ServerListener.class);

	public static final ServerListener me = new ServerListener();


	@Override
	public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
		//连接后，需要把连接会话对象设置给channelContext
		super.onAfterConnected(channelContext, isConnected, isReconnect);
    }

	@Override
	public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
	}

	@Override
	public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception {
//		super.onBeforeClose(channelContext, throwable, remark, isRemove);
//		ServerConfig.processor.onBeforeClose(channelContext, throwable, remark, isRemove);
	}

	@Override
	public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {
//		super.onAfterDecoded(channelContext, packet, packetSize);
//		if (log.isInfoEnabled()) {
//			log.info("onAfterDecoded\r\n{}\r\n{}", packet.logstr(), channelContext);
//		}
	}

	@Override
	public void onAfterReceivedBytes(ChannelContext channelContext, int receivedBytes) throws Exception {
//		super.onAfterReceivedBytes(channelContext, receivedBytes);
	}

	@Override
	public void onAfterHandled(ChannelContext channelContext, Packet packet, long cost) throws Exception {
//		super.onAfterHandled(channelContext, packet, cost);
//		if (log.isInfoEnabled()) {
//			log.info("onAfterHandled\r\n{}\r\n{}", packet.logstr(), channelContext);
//		}
	}

}
