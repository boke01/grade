package com.vz04.grade.mapper;

import com.vz04.grade.mapper.course.CourseMappper;
import com.vz04.grade.pojo.course.CourseBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试com.vz04.grade.mapper.course.CourseMappper中的方法
 *
 * @author vz04
 * @date 8/1/2019 11:20 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMapperTest {
    @Autowired
    private CourseMappper courseMappper;

    /**
     * 测试新增课程
     *
     * @date 4:18 PM 7/31/2019
     */
    @Test
    public void testAddCourse () {
        int i = courseMappper.addCourse("美术");
        Assert.assertSame(1,i);
    }

    /**
     * 测试查看课程是否存在
     *
     * @date 4:18 PM 7/31/2019
     */
    @Test
    public void testCheckCourse () {
        CourseBean course = courseMappper.checkCourse("美术");
        Assert.assertNotNull(course);
    }

    /**
     * 测试查看全部课程
     *
     * @date 4:18 PM 7/31/2019
     */
    @Test
    public void testCheckAllCourse () {
        List<CourseBean> courses = courseMappper.checkAllCourse();
        Assert.assertNotNull(courses);
    }

    /**
     * 测试修改课程名
     *
     * @date 4:18 PM 7/31/2019
     */
    @Test
    public void testAlterCourse () {
        int i = courseMappper.alterCourse(4, "物理");
        Assert.assertSame(1,i);
    }

    /**
     * 测试删除课程
     *
     * @date 4:18 PM 7/31/2019
     */
    @Test
    public void test () {
        int i = courseMappper.deleteCourse(4);
        Assert.assertSame(1,i);

    }

}
