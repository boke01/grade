package com.vz04.grade.mapper;

import com.vz04.grade.mapper.grade.GradeMapper;
import com.vz04.grade.pojo.grade.GradeBean;
import com.vz04.grade.pojo.grade.TranscriptBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试com.vz04.grade.mapper.grade.GradeMapper中的方法
 * @author vz04
 * @date 8/1/2019 11:20 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeMapperTest {
    @Autowired
    private GradeMapper gradeMapper;


    /**
     * 新增成绩
     *
     * @date 4:44 PM 7/31/2019
     */
    @Test
    public void testAddGrade() {
        int i = gradeMapper.addGrade(2, 1, 80);
        Assert.assertSame(1,i);

    }

    /**
     * 根据用户id与科目id查看成绩
     *
     * @date 4:44 PM 7/31/2019
     */
    @Test
    public void testCheckGradeInAccont() {
        List<GradeBean> grades = gradeMapper.checkGradeInAccont(3, 1);
        Assert.assertNotNull(grades);
    }

    /**
     * 根据班级id与科目id查看成绩
     *
     * @date 4:44 PM 7/31/2019
     */
    @Test
    public void testCheckGradeInClasses() {
        List<TranscriptBean> transcripts = gradeMapper.checkGradeInClasses(0, 1);
        Assert.assertNotNull(transcripts);
    }

    /**
     * 根据成绩id修改成绩
     *
     * @date 4:44 PM 7/31/2019
     */
    @Test
    public void testAlterGrade() {
        int i = gradeMapper.alterGrade(1, 90);
        Assert.assertSame(1,i);
    }

    /**
     * 根据科目id删除成绩
     *
     * @date 4:44 PM 7/31/2019
     */
    @Test
    public void test() {
        int i = gradeMapper.deleteGrade(1);
        Assert.assertNotSame(-1,i);
    }
}
