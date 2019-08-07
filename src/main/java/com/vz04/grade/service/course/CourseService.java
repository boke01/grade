package com.vz04.grade.service.course;

import com.vz04.grade.pojo.course.CourseBean;

import java.util.List;

/**
 * 与课程管理相关的接口
 *
 * @author vz04
 * @date 7/31/2019 5:12 PM
 **/
public interface CourseService {

    /**
     * 用于添加课程的接口
     * 通过sql的影响行数来判断是否成功
     *
     * @date 3:58 PM 7/31/2019
     * @param courseTitle 课程名称
     * @return boolean
     */
    boolean addCourse(String courseTitle);

    /**
     * 获取现有全部课程信息的接口
     *
     * @date 3:59 PM 7/31/2019
     * @return List<CourseBean>
     */
    List<CourseBean> checkAllCourse();

    /**
     * 根据课程id修改课程名称
     * 通过sql的影响行数来判断是否成功
     *
     * @date 4:00 PM 7/31/2019
     * @param courseId 课程id
     * @param courseTitle 课程名称
     * @return boolean
     */
    boolean alterCourse(Integer courseId,String courseTitle);

    /**
     * 根据课程id删除课程的接口
     * 通过sql的影响行数来判断是否成功
     *
     * @date 4:02 PM 7/31/2019
     * @param courseId 课程id
     * @return boolean
     */
    boolean deleteCourse(Integer courseId);

}
