package com.vz04.grade.mapper;

import com.vz04.grade.mapper.classes.ClassesMapper;
import com.vz04.grade.pojo.classec.ClassesBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试com.vz04.grade.mapper.classes.ClassesMapper
 * @author vz04
 * @date 8/1/2019 11:19 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassesMapperTest {
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 测试添加班级接口
     *
     * @date 11:26 AM 8/1/2019
     */
    @Test
    public void testAddClasses() {
        int i = classesMapper.addClasses("一年级三班");
        Assert.assertSame(1,i);
    }

    /**
     * 修改班级
     *
     * @date 11:26 AM 8/1/2019
     */
    @Test
    public void testAlterClassses() {
        int i = classesMapper.alterClassses(5, "二年级三班");
        Assert.assertSame(1,i);

    }

    /**
     * 查看全部班级
     *
     * @date 11:26 AM 8/1/2019
     */
    @Test
    public void testCheckAllClasses() {
        List<ClassesBean> classesBeans = classesMapper.checkAllClasses();
        Assert.assertNotNull(classesBeans);
    }

    /**
     * 测试单个班级查询接口
     *
     * @date 11:26 AM 8/1/2019
     */
    @Test
    public void testCheckClasses() {
        ClassesBean classes = classesMapper.checkClasses("一年级五班");
        Assert.assertNotNull(classes);
    }

    /**
     * 通过id查班级
     *
     * @date 3:25 PM 8/2/2019
     */
    @Test
    public void testcheckClassesInid() {
        ClassesBean classes = classesMapper.checkClassesInid(3);
        Assert.assertNotNull(classes);
    }

}
