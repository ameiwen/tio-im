package com.yaa.tio.tioim.web.model;

import java.io.Serializable;

/**
 * 好友关系
 */
public class FriendShip implements Serializable {

    private String uid;
    private String friendID;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFriendID() {
        return friendID;
    }

    public void setFriendID(String friendID) {
        this.friendID = friendID;
    }

    @Override
    public String toString() {
        return "FriendShip{" +
                "uid='" + uid + '\'' +
                ", friendID='" + friendID + '\'' +
                '}';
    }
}
