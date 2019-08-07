package com.vz04.grade.pojo.course;

/**
 * 与课程相关的数据接口
 *
 * @author vz04
 * @date 7/31/2019 3:51 PM
 **/
public class CourseBean {

    private Integer courseId;
    private String courseTitle;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @Override
    public String toString() {
        return "CourseBean{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }
}
