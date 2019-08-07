package com.vz04.grade.pojo.grade;

/**
 * 查询出的以班级为单位成绩数据
 *
 * @author vz04
 * @date 7/31/2019 3:33 PM
 **/
public class TranscriptBean {
    private Integer gradeId;
    private Integer accontId;
    private String accountNumber;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "TranscriptBean{" +
                "gradeId=" + gradeId +
                ", accontId=" + accontId +
                ", accountNumber='" + accountNumber + '\'' +
                ", grade=" + grade +
                '}';
    }
}
