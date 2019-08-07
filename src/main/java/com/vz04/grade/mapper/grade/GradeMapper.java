package com.vz04.grade.mapper.grade;
import com.vz04.grade.pojo.grade.TranscriptBean;
import com.vz04.grade.pojo.grade.GradeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 成绩管理相关的数据接口
 * @author vz04
 * @date 7/31/2019 1:55 PM
 **/
@Mapper
@Repository
public interface GradeMapper {
    /**
     * 添加成绩的数据接口
     *
     * @date 1:55 PM 7/31/2019
     * @param accontId 用户id
     * @param courseId 课程id
     * @param grade 分数
     * @return int
     */
    int addGrade(@Param("accontId") Integer accontId, @Param("courseId") Integer courseId, @Param("grade") Integer grade);

    /**
     * 根据用户id与科目id查看成绩
     *
     * @date 3:13 PM 7/31/2019
     * @param accontId 用户id
     * @param courseId 课程id
     * @return List<GradeBean>
     */
    List<GradeBean> checkGradeInAccont(@Param("accontId") Integer accontId, @Param("courseId") Integer courseId);

    /**
     * 根据班级id与科目id查看成绩
     *
     * @date 3:15 PM 7/31/2019
     * @param classesId 班级id
     * @param courseId 课程id
     * @return List<TranscriptBean>
     */
    List<TranscriptBean> checkGradeInClasses(@Param("classesId") Integer classesId, @Param("courseId") Integer courseId);

    /**
     * 根据成绩id修改成绩
     *
     * @date 3:20 PM 7/31/2019
     * @param gradeId 成绩id
     * @param grade 分数
     * @return int
     */
    int alterGrade(@Param("gradeId") Integer gradeId, @Param("grade") Integer grade);

    /**
     * 根据科目id删除成绩
     * 删除科目时使用
     *
     * @date 3:22 PM 7/31/2019
     * @param courseId 课程
     * @return int
     */
    int deleteGrade(@Param("courseId") Integer courseId);
}
