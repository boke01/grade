package com.vz04.grade.pojo.classec;

/**
 * 班级信息
 *
 * @author vz04
 * @date 7/27/2019 4:13 PM
 **/
public class ClassesBean {

    private Integer classesId;
    private String nameClass;

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "ClassesBean{" +
                "classesId=" + classesId +
                ", nameClass='" + nameClass + '\'' +
                '}';
    }
}
