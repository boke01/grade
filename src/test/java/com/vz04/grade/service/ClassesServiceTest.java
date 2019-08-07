package com.vz04.grade.service;

import com.vz04.grade.pojo.classec.ClassesBean;
import com.vz04.grade.service.classes.ClassesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试 com.vz04.grade.service.classes.ClassesService
 * @author vz04
 * @date 8/1/2019 11:19 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassesServiceTest {
    @Autowired
    private ClassesService classesService;

    /**
     * 测试获取全部已有班级的id与名称
     *
     * @date 4:31 PM 7/30/2019
     */
    @Test
    public void testCheckAllClasses() {
        List<ClassesBean> classesBeans = classesService.checkAllClasses();
        Assert.assertNotNull(classesBeans);
    }

    /**
     * 测试添加班级
     *
     * @date 4:31 PM 7/30/2019
     */
    @Test
    public void testAddClasses() {
        boolean b = classesService.addClasses("二年级一班");
        Assert.assertTrue(b);

    }

    /**
     * 测试修改班级名称
     *
     * @date 4:31 PM 7/30/2019
     */
    @Test
    public void testAlterClassses() {
        ClassesBean classesBean = new ClassesBean();
        classesBean.setClassesId(5);
        classesBean.setNameClass("二年级三班");
        boolean b = classesService.alterClassses(classesBean);
        Assert.assertTrue(b);
    }

    /**
     * 测试删除班级
     *
     * @date 4:31 PM 7/30/2019
     */
    @Test
    public void testDeleteClasses() {
        boolean b = classesService.deleteClasses(5);
        Assert.assertTrue(b);
    }
}
