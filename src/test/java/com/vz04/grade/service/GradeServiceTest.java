package com.vz04.grade.service;

import com.vz04.grade.pojo.grade.GradeBean;
import com.vz04.grade.pojo.grade.TranscriptBean;
import com.vz04.grade.service.grade.GradeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * 测试 com.vz04.grade.service.grade.GradeService
 * @author vz04
 * @date 8/1/2019 11:20 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeServiceTest {
    @Autowired
    private GradeService gradeService;

    /**
     * 添加成绩
     *
     * @date 1:55 PM 7/31/2019
     */
    @Test
    public void testAddGrade() {
        boolean b = gradeService.addGrade(2, 1, 80);
        Assert.assertTrue(b);

    }

    /**
     * 根据用户id与科目id查看成绩的接口
     *
     * @date 3:13 PM 7/31/2019
     */
    @Test
    public void testCheckGradeInAccont() {
        List<GradeBean> gradeBeans = gradeService.checkGradeInAccont(3, 1);
        Assert.assertNotNull(gradeBeans);
    }

    /**
     * 根据班级id与科目id查看成绩
     *
     * @date 3:15 PM 7/31/2019
     */
    @Test
    public void testCheckGradeInClasses() {
        List<TranscriptBean> transcriptBeans = gradeService.checkGradeInClasses(1, 1);
        Assert.assertNotNull(transcriptBeans);
    }

    /**
     * 根据成绩id修改成绩
     *
     * @date 3:20 PM 7/31/2019
     */
    @Test
    public void testAlterGrade() {
        boolean b = gradeService.alterGrade(1, 80);
        Assert.assertTrue(b);
    }

}
