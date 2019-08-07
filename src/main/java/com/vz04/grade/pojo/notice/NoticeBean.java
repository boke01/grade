package com.vz04.grade.pojo.notice;

/**
 * 与公告相关的数据
 * @author vz04
 * @date 7/31/2019 9:27 AM
 **/
public class NoticeBean {
    private Integer noticeId;
    private Integer classesId;
    private String notice;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "NoticeBean{" +
                "noticeId=" + noticeId +
                ", classesId=" + classesId +
                ", notice='" + notice + '\'' +
                '}';
    }
}
