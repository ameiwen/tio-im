package com.yaa.tio.tioim.web.model;

import java.io.Serializable;

public class GroupShip implements Serializable {

    private String uid;
    private String gid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "GroupShip{" +
                "uid='" + uid + '\'' +
                ", gid='" + gid + '\'' +
                '}';
    }
}
