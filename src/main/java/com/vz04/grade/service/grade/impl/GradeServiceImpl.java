package com.vz04.grade.service.grade.impl;

import com.vz04.grade.mapper.grade.GradeMapper;
import com.vz04.grade.pojo.grade.GradeBean;
import com.vz04.grade.pojo.grade.TranscriptBean;
import com.vz04.grade.service.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author vz04
 * @date 8/1/2019 8:08 AM
 **/
@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 添加成绩的接口实现
     * 通过sql的影响行数来判断是否成功
     *
     * @date 1:55 PM 7/31/2019
     * @param accontId 用户id
     * @param courseId 课程id
     * @param grade 分数
     * @return boolean
     */
    @Override
    public boolean addGrade(Integer accontId, Integer courseId, Integer grade) {
        int i = gradeMapper.addGrade(accontId, courseId, grade);
        return i == 1;
    }

    /**
     * 根据用户id与科目id查看成绩的接口实现
     *
     * @date 3:13 PM 7/31/2019
     * @param accontId 用户id
     * @param courseId 课程id
     * @return List<GradeBean>
     */
    @Override
    public List<GradeBean> checkGradeInAccont(Integer accontId, Integer courseId) {
        return gradeMapper.checkGradeInAccont(accontId,courseId);
    }

    /**
     * 根据班级id与科目id查看成绩的接口实现
     *
     * @date 3:15 PM 7/31/2019
     * @param classesId 班级id
     * @param courseId 课程id
     * @return List<TranscriptBean>
     */
    @Override
    public List<TranscriptBean> checkGradeInClasses(Integer classesId, Integer courseId) {
        return gradeMapper.checkGradeInClasses(classesId,courseId);
    }

    /**
     * 根据成绩id修改成绩的接口实现
     * 通过sql的影响行数来判断是否成功
     *
     * @date 3:20 PM 7/31/2019
     * @param gradeId 成绩id
     * @param grade 分数
     * @return boolean
     */
    @Override
    public boolean alterGrade(Integer gradeId, Integer grade) {
        int i = gradeMapper.alterGrade(gradeId, grade);
        return i == 1;
    }
}
