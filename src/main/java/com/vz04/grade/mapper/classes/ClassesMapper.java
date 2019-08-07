package com.vz04.grade.mapper.classes;

import com.vz04.grade.pojo.classec.ClassesBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 班级相关的数据操作接口
 *
 * @author vz04
 * @date 7/27/2019 4:09 PM
 **/
@Mapper
@Repository
public interface ClassesMapper {


    /**
     * 获取全部班级名称与id的数据接口
     *
     * @date 7/27/2019 4:09 PM
     * @return List<ClassesBean>
     */
    List<ClassesBean> checkAllClasses();

    /**
     * 用于校验班级是否存在的数据接口
     *
     * @date 7/27/2019 4:09 PM
     * @param nameClass 班级名
     * @return ClassesBean
     */
    ClassesBean checkClasses(@Param("nameClass") String nameClass);

    /**
     * 通过班级id来查找班级是否存在
     *
     * @date 3:22 PM 8/2/2019
     * @param classesId 班级id
     * @return ClassesBean
     */
    ClassesBean checkClassesInid(@Param("classesId") Integer classesId);

    /**
     * 添加班级的数据接口
     *
     * @date 7/27/2019 4:09 PM
     * @param nameClass 班级名
     * @return int
     */
    int addClasses(@Param("nameClass") String nameClass);

    /**
     * 修改班级名称的数据接口
     *
     * @date 7/27/2019 4:09 PM
     * @param nameClass 班级名称
     * @param classesId 班级id
     * @return int
     */
    int alterClassses(@Param("classesId") Integer classesId,@Param("nameClass") String nameClass);

    /**
     * 根据班级id删除班级的数据接口
     *
     * @date 7/27/2019 4:09 PM
     * @param classesId 班级id
     * @return int
     */
    int deleteClasses(@Param("classesId") Integer classesId);
}
