package com.yaa.tio.tioim.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * tio 网络框架配置信息
 */
@Component
@ConfigurationProperties("tio")
public class TioProperties {

	public static final String CHARSET = "utf-8";

	/**
	 * 心跳请求
	 */
	public static final String  HEART_BEAT = "ping";


	/**
	 * 服务端监听端口
	 */
	@NotNull
	private int serverPort;

	/**
	 * 服务端绑定的 ip
	 */
	private String serverIp;


	/**
	 * 心跳包时间间隔
	 */
	@NotNull
	private int heartTimeout;


	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public int getHeartTimeout() {
		return heartTimeout;
	}

	public void setHeartTimeout(int heartTimeout) {
		this.heartTimeout = heartTimeout;
	}
}
