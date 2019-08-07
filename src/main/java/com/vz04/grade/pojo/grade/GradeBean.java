package com.vz04.grade.pojo.grade;

/**
 * 成绩相关的数据
 *
 * @author vz04
 * @date 7/31/2019 1:50 PM
 **/
public class GradeBean {
    private Integer gradeId;
    private Integer accontId;
    private Integer classesId;
    private Integer courseId;
    private Integer grade;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getAccontId() {
        return accontId;
    }

    public void setAccontId(Integer accontId) {
        this.accontId = accontId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "GradeBean{" +
                "gradeId=" + gradeId +
                ", accontId=" + accontId +
                ", classesId=" + classesId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
