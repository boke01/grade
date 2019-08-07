package com.vz04.grade.service.grade;

import com.vz04.grade.pojo.grade.GradeBean;
import com.vz04.grade.pojo.grade.TranscriptBean;

import java.util.List;

/**
 * 与成绩管理相关的接口
 * @author vz04
 * @date 8/1/2019 8:04 AM
 **/
public interface GradeService {
    /**
     * 添加成绩的接口
     * 通过sql的影响行数来判断是否成功
     *
     * @date 1:55 PM 7/31/2019
     * @param accontId 用户id
     * @param courseId 课程id
     * @param grade 分数
     * @return boolean
     */
    boolean addGrade(Integer accontId,Integer courseId,Integer grade);

    /**
     * 根据用户id与科目id查看成绩的接口
     *
     * @date 3:13 PM 7/31/2019
     * @param accontId 用户id
     * @param courseId 课程id
     * @return List<GradeBean>
     */
    List<GradeBean> checkGradeInAccont(Integer accontId, Integer courseId);

    /**
     * 根据班级id与科目id查看成绩的接口
     *
     * @date 3:15 PM 7/31/2019
     * @param classesId 班级id
     * @param courseId 课程id
     * @return List<TranscriptBean>
     */
    List<TranscriptBean> checkGradeInClasses(Integer classesId, Integer courseId);

    /**
     * 根据成绩id修改成绩的接口
     * 通过sql的影响行数来判断是否成功
     *
     * @date 3:20 PM 7/31/2019
     * @param gradeId 成绩id
     * @param grade 分数
     * @return boolean
     */
    boolean alterGrade(Integer gradeId,  Integer grade);

}
