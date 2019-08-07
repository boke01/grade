package com.vz04.grade.service;

import com.vz04.grade.pojo.course.CourseBean;
import com.vz04.grade.service.course.CourseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试 com.vz04.grade.service.course.CourseService
 * @author vz04
 * @date 8/1/2019 11:20 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {
    @Autowired
    private CourseService courseService;

    /**
     * 测试添加课程
     *
     * @date 3:58 PM 7/31/2019
     */
    @Test
    public void testAddCourse() {
        boolean b = courseService.addCourse("美术");
        Assert.assertTrue(b);

    }

    /**
     * 获取现有全部课程信息
     *
     * @date 3:59 PM 7/31/2019
     */
    @Test
    public void testCheckAllCourse() {
        List<CourseBean> courseBeans = courseService.checkAllCourse();
        Assert.assertNotNull(courseBeans);
    }

    /**
     * 根据课程id修改课程名称
     *
     * @date 4:00 PM 7/31/2019
     */
    @Test
    public void testAlterCourse() {
        boolean b = courseService.alterCourse(4, "物理");
        Assert.assertTrue(b);

    }

    /**
     * 根据课程id删除课程
     *
     * @date 4:02 PM 7/31/2019
     */
    @Test
    public void testDeleteCourse() {
        boolean b = courseService.deleteCourse(4);
        Assert.assertTrue(b);
    }
}
