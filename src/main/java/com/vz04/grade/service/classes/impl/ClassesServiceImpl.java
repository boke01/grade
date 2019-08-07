package com.vz04.grade.service.classes.impl;

import com.vz04.grade.mapper.classes.ClassesMapper;
import com.vz04.grade.mapper.login.LoginMapper;
import com.vz04.grade.mapper.notice.NoticeMapper;
import com.vz04.grade.pojo.classec.ClassesBean;
import com.vz04.grade.service.classes.ClassesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级管理业务接口实现
 * @author vz04
 * @date 7/27/2019 4:49 PM
 **/
@Service
public class ClassesServiceImpl implements ClassesService{

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 获取全部已有的班级id与名称
     *
     * @date 11:14 AM 7/30/2019
     * @return List<ClassesBean>
     */
    @Override
    public List<ClassesBean> checkAllClasses() {
        return classesMapper.checkAllClasses();
    }

    /**
     * 添加一个班级
     * 如果要添加的班级已经存在返回false
     * 如果添加时印象的行数不为1也返回false
     *
     * @date 5:00 PM 7/27/2019
     * @param nameClass 班级名称
     * @return 成功返回true，失败返回false
     */
    @Override
    public boolean addClasses(String nameClass) {
        //检查班级是否已经存在
        ClassesBean classesBean = classesMapper.checkClasses(nameClass);
        if (classesBean != null) {
            return false;
        }
        int i = classesMapper.addClasses(nameClass);
        return i != 0;
    }

    /**
     * 修改班级名称
     * 修改前检查要修改的名称是否存在，如果存在返回false
     * 如果修改影响行数不是1也返回false
     *
     * @date 1:21 PM 7/30/2019
     * @param classesBean 使用classesBean中的classesId与nameClass字段
     * @return boolean
     */
    @Override
    public boolean alterClassses(ClassesBean classesBean) {

        ClassesBean classes = classesMapper.checkClasses(classesBean.getNameClass());
        if (classes == null) {
            int i = classesMapper.alterClassses(classesBean.getClassesId(), classesBean.getNameClass());
            return i == 1;
        }
        return false;
    }

    /**
     * 通过班级id删除班级
     * 先将这个班中的学生的classesId改为0
     * 再将这个班的公告删除
     * 最后删除班级
     *
     * @date 4:41 PM 7/30/2019
     * @param classesId 班级id
     * @return boolean
     */
    @Override
    public boolean deleteClasses(Integer classesId) {
        int i1 = loginMapper.alterClasseId(classesId);
        int i2 = noticeMapper.deleteNoticeInClasses(classesId);
        int i3 = classesMapper.deleteClasses(classesId);
        return i1 >= 0 && i2 >= 0 && i3 >= 0;
    }
}
