package com.vz04.grade.service.course.impl;

import com.vz04.grade.mapper.course.CourseMappper;
import com.vz04.grade.mapper.grade.GradeMapper;
import com.vz04.grade.pojo.course.CourseBean;
import com.vz04.grade.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程管理接口实现类
 * @author vz04
 * @date 8/1/2019 7:53 AM
 **/
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMappper courseMappper;

    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 用于添加课程的接口的实现
     * 验证课程名是否已存在
     * 通过sql的影响行数来判断是否成功
     *
     *
     * @date 3:58 PM 7/31/2019
     * @param courseTitle 课程名称
     * @return boolean
     */
    @Override
    public boolean addCourse(String courseTitle) {
        CourseBean course= courseMappper.checkCourse(courseTitle);
        if (course != null){
            return false;
        }
        int i = courseMappper.addCourse(courseTitle);
        return i == 1;
    }

    /**
     * 获取现有全部课程信息的接口实现
     *
     * @date 3:59 PM 7/31/2019
     * @return List<CourseBean>
     */
    @Override
    public List<CourseBean> checkAllCourse() {
        return courseMappper.checkAllCourse();
    }

    /**
     * 根据课程id修改课程名称接口实现
     * 验证了要修改的名称是否已经存在
     * 通过sql的影响行数来判断是否成功
     *
     * @date 4:00 PM 7/31/2019
     * @param courseId 课程id
     * @param courseTitle 课程名称
     * @return boolean
     */
    @Override
    public boolean alterCourse(Integer courseId, String courseTitle) {
        CourseBean course= courseMappper.checkCourse(courseTitle);
        if (course != null){
            return false;
        }
        int i = courseMappper.alterCourse(courseId, courseTitle);
        return i == 1;
    }

    /**
     * 根据课程id删除课程的接口实现
     * 同时删除与这门课相关的成绩
     * 通过sql的影响行数来判断是否成功
     *
     * @date 4:02 PM 7/31/2019
     * @param courseId 课程id
     * @return boolean
     */
    @Override
    public boolean deleteCourse(Integer courseId) {
        int i = courseMappper.deleteCourse(courseId);
        int i1 = gradeMapper.deleteGrade(courseId);
        return i >= 0 && i1 >= 0;
    }
}
