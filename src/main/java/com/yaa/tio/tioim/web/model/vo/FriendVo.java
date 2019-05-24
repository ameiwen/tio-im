package com.yaa.tio.tioim.web.model.vo;

import java.util.List;

public class FriendVo {

    private String groupname = "我的好友";
    private String id;
    private String online;
    private List<MineVo> list;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public List<MineVo> getList() {
        return list;
    }

    public void setList(List<MineVo> list) {
        this.list = list;
    }


}
