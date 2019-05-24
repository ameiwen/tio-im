package com.yaa.tio.tioim.server;

import com.yaa.tio.tioim.conf.TioProperties;
import com.yaa.tio.tioim.server.handler.ServerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tio.server.ServerGroupContext;
import org.tio.websocket.server.WsServerStarter;

import javax.annotation.PostConstruct;

@Component
public class AppServer {

    @Autowired
    private TioProperties tioProperties;
    @Autowired
    private ServerHandler serverHandler;
    @Autowired
    private ServerListener serverListener;


    private ServerGroupContext serverGroupContext;

    @PostConstruct
    public void starts() throws Exception {
        WsServerStarter starter = new WsServerStarter(tioProperties.getServerPort(), serverHandler);

        serverGroupContext = starter.getServerGroupContext();
        serverGroupContext.setServerAioListener(serverListener);
        serverGroupContext.setHeartbeatTimeout(tioProperties.getHeartTimeout());

        starter.start();
    }

}
