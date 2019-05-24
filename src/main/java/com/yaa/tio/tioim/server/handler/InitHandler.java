package com.yaa.tio.tioim.server.handler;

import com.yaa.tio.tioim.db.DBAccess;
import com.yaa.tio.tioim.server.model.ChannelReq;
import com.yaa.tio.tioim.server.processor.ServerProcessor;
import com.yaa.tio.tioim.util.ContextUtil;
import com.yaa.tio.tioim.util.WsResultUtil;
import com.yaa.tio.tioim.web.model.vo.FriendVo;
import com.yaa.tio.tioim.web.model.vo.GroupVo;
import com.yaa.tio.tioim.web.model.vo.InitVo;
import com.yaa.tio.tioim.web.model.vo.MineVo;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.common.WsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化
 */
public class InitHandler extends ServerProcessor {

    @Override
    public void handleMessage(WsRequest wsRequest, ChannelReq channelReq, ChannelContext channelContext) throws Exception {
        DBAccess dbAccess = ContextUtil.getBean(DBAccess.class);
//        String uid = channelReq.getUid();
//        if(StringUtils.isBlank(uid)){
//            return ;
//        }
//        Map<String,Object> result = new HashMap<>();
//        Account account = dbAccess.getAccount(uid);
        InitVo init = new InitVo();
        MineVo m1 = new MineVo();
        m1.setId("1");
        m1.setUsername("纸飞机");
        m1.setAvatar("http://tvax1.sinaimg.cn/crop.0.0.300.300.180/006Iv8Wjly8ff7ghbigcij308c08ct8i.jpg");
        init.setMine(m1);
        List<FriendVo> friendVos = new ArrayList<>();
        FriendVo f1 = new FriendVo();
        f1.setId("1");
        f1.setOnline("2");
        List<MineVo> friends = new ArrayList<>();
        MineVo m2 = new MineVo();
        m2.setId("100001");
        m2.setUsername("贤心");
        m2.setAvatar("http://tp1.sinaimg.cn/1571889140/180/40030060651/1");
        friends.add(m2);
        MineVo m3 = new MineVo();
        m3.setId("108101");
        m3.setUsername("Z_子晴");
        m3.setAvatar("http://tp2.sinaimg.cn/1833062053/180/5643591594/0");
        friends.add(m3);
        f1.setList(friends);
        friendVos.add(f1);
        init.setFriend(friendVos);

        List<GroupVo> groups = new ArrayList<>();
        GroupVo g1 = new GroupVo();
        g1.setGroupname("前端群");
        g1.setId("1321");
        g1.setAvatar("http://tp2.sinaimg.cn/2211874245/180/40050524279/0");
        groups.add(g1);

        GroupVo g2 = new GroupVo();
        g2.setGroupname("前端群");
        g2.setId("1321");
        g2.setAvatar("http://tp2.sinaimg.cn/5488749285/50/5719808192/1");
        groups.add(g2);
        init.setGroup(groups);
        Map<String,Object> result = new HashMap<>();
        result.put("data",init);
        result.put("type","init");
        WsResponse wsResponse = WsResultUtil.buildResponseByJson(init);
        Tio.send(channelContext,wsResponse);
    }

}
