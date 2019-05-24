package com.yaa.tio.tioim.web.model;

import java.io.Serializable;

/**
 * 群信息
 */
public class Group implements Serializable {

    //群号
    private String gid;
    //群主
    private String uid;
    //群名称
    private String gName;
    //群头像
    private String gHeadImg;
    //群介绍
    private String remark;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgHeadImg() {
        return gHeadImg;
    }

    public void setgHeadImg(String gHeadImg) {
        this.gHeadImg = gHeadImg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Group{" +
                "gid='" + gid + '\'' +
                ", uid='" + uid + '\'' +
                ", gName='" + gName + '\'' +
                ", gHeadImg='" + gHeadImg + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
