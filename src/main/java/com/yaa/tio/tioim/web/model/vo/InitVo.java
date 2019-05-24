package com.yaa.tio.tioim.web.model.vo;

import java.util.List;

public class InitVo {

    private MineVo mine;
    private List<FriendVo> friend;
    private List<GroupVo> group;

    public MineVo getMine() {
        return mine;
    }

    public void setMine(MineVo mine) {
        this.mine = mine;
    }

    public List<FriendVo> getFriend() {
        return friend;
    }

    public void setFriend(List<FriendVo> friend) {
        this.friend = friend;
    }

    public List<GroupVo> getGroup() {
        return group;
    }

    public void setGroup(List<GroupVo> group) {
        this.group = group;
    }
}
