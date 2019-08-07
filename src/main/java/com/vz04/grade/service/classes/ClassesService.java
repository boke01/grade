package com.vz04.grade.service.classes;


import com.vz04.grade.pojo.classec.ClassesBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 班级管理相关接口
 *
 * @author vz04
 * @date 7/27/2019 4:45 PM
 **/
public interface ClassesService {


    /**
     * 需要获取全部已有班级的id与名称
     *
     * @date 4:31 PM 7/30/2019
     * @return List<ClassesBean>
     */
    List<ClassesBean> checkAllClasses();

    /**
     * 添加班级的接口
     * 需要验证新增的班级是否已经存在
     *
     * @param nameClass 班级名称
     * @return boolean
     */
    boolean addClasses(String nameClass);

    /**
     * 修改班级名称
     * 需要验证要修改的班级是否存在
     * 需要验证要改的名称是否已经被使用
     *
     * @param classesBean 班级数据
     * @return boolean
     */
    boolean alterClassses(ClassesBean classesBean);

    /**
     * 删除班级的接口
     * 需要修改这个班的学生的信息
     * 需要删除这个班的公告
     *
     * @param classesId 班级id
     * @return boolean
     */
    boolean deleteClasses(@Param("classesId") Integer classesId);
}
