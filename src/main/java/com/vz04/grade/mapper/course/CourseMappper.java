package com.vz04.grade.mapper.course;

import com.vz04.grade.pojo.course.CourseBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 与课程管理相关的数据接口
 *
 * @author vz04
 * @date 7/31/2019 3:54 PM
 **/
@Mapper
@Repository
public interface CourseMappper {
    /**
     * 根据课程名称查看课程是否已经存在
     *
     * @date 4:01 PM 7/31/2019
     * @param courseTitle 课程名称
     * @return CourseBean
     */
    CourseBean checkCourse(@Param("courseTitle") String courseTitle);

    /**
     * 添加课程的数据接口
     *
     * @date 3:58 PM 7/31/2019
     * @param courseTitle 课程名称
     * @return int
     */
    int addCourse(@Param("courseTitle") String courseTitle);

    /**
     * 查看全部课程的数据接口
     *
     * @date 3:59 PM 7/31/2019
     * @return List<CourseBean>
     */
    List<CourseBean> checkAllCourse();

    /**
     * 根据课程id修改课程名称
     *
     * @date 4:00 PM 7/31/2019
     * @param courseId 课程id
     * @param courseTitle 课程名称
     * @return int
     */
    int alterCourse(@Param("courseId") Integer courseId,@Param("courseTitle") String courseTitle);

    /**
     * 根据课程id删除课程的数据接口
     *
     * @date 4:02 PM 7/31/2019
     * @param courseId 课程id
     * @return int
     */
    int deleteCourse(@Param("courseId") Integer courseId);
}
