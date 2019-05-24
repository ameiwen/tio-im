package com.yaa.tio.tioim.web.model;

import java.io.Serializable;

public class Message implements Serializable {

    private String uid;
    private String pid;
    //1 个人消息 2群组消息
    private String type;
    //发送给谁
    private String toUid;
    //发送的群组
    private String toPid;
    //是否已读 1 已读 0 未读
    private String isRead;
    private Long time;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid;
    }

    public String getToPid() {
        return toPid;
    }

    public void setToPid(String toPid) {
        this.toPid = toPid;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uid='" + uid + '\'' +
                ", pid='" + pid + '\'' +
                ", type='" + type + '\'' +
                ", toUid='" + toUid + '\'' +
                ", toPid='" + toPid + '\'' +
                ", isRead='" + isRead + '\'' +
                ", time=" + time +
                '}';
    }
}
