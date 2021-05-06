package com.ykp.snacks.domain;

import java.util.List;

public class Notice {
    private int status;
    private Object msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "status=" + status +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }
}

class DataBean {
    private int noticeId;
    private String noticeTitle;
    private Object noticeImg;
    private long noticeCreateTime;
    private long noticeUpdateTime;
    private String noticeContent;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Object getNoticeImg() {
        return noticeImg;
    }

    public void setNoticeImg(Object noticeImg) {
        this.noticeImg = noticeImg;
    }

    public long getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(long noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public long getNoticeUpdateTime() {
        return noticeUpdateTime;
    }

    public void setNoticeUpdateTime(long noticeUpdateTime) {
        this.noticeUpdateTime = noticeUpdateTime;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeImg=" + noticeImg +
                ", noticeCreateTime=" + noticeCreateTime +
                ", noticeUpdateTime=" + noticeUpdateTime +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}
