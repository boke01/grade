package com.vz04.grade.controller.grade;

import com.vz04.grade.pojo.grade.GradeBean;
import com.vz04.grade.pojo.grade.TranscriptBean;
import com.vz04.grade.pojo.msg.Msg;
import com.vz04.grade.service.grade.GradeService;
import com.vz04.grade.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 与成绩管理相关的Controller
 * @author vz04
 * @date 8/1/2019 8:35 AM
 **/
@RestController
@RequestMapping("/grade")
public class GradeController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GradeService gradeService;

    /**
     * 添加成绩的方法
     * 仅教师登录可用
     *
     * @date 1:55 PM 7/31/2019
     * @param gradeBean 需要用到 accontId 用户id， courseId 课程id ，grade 分数
     * @param session 获取session
     * @return Msg
     */
    @PostMapping("/post")
    public Msg addGrade(@RequestBody GradeBean gradeBean,HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = gradeService.addGrade(gradeBean.getAccontId(),gradeBean.getCourseId(),gradeBean.getGrade());
            if (b){
                return new Msg().setMsg(Constant.SUCCESS,Constant.ADD_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ADD_OPERATION_DEFEATED,null);
            }

        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }

    /**
     * 根据用户id与科目id查看成绩的方法
     * 登录可用
     *
     * @date 3:13 PM 7/31/2019
     * @param  gradeBean 需要用到 courseId 课程id，accontId 用户id
     * @param session session
     * @return List<GradeBean>
     */
    @PostMapping("/student/get")
    public Msg checkGradeInAccont(@RequestBody GradeBean gradeBean,HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        List<GradeBean> grades= gradeService.checkGradeInAccont(gradeBean.getAccontId(), gradeBean.getCourseId());
        return new Msg().setMsg(Constant.SUCCESS,Constant.CHECK_OPERATION_SUCCESSFUL,grades);
    }

    /**
     * 根据班级id与科目id查看成绩的方法
     * 登录可用
     *
     * @date 3:13 PM 7/31/2019
     * @param  gradeBean 需要用到 courseId 课程id，classesId 班级id
     * @param session session
     * @return List<GradeBean>
     */
    @PostMapping("/classes/get")
    public Msg checkGradeInClasses(@RequestBody GradeBean gradeBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        List<TranscriptBean> transcripts = gradeService.checkGradeInClasses(gradeBean.getClassesId(), gradeBean.getCourseId());
        return new Msg().setMsg(Constant.SUCCESS,Constant.CHECK_OPERATION_SUCCESSFUL,transcripts);
    }

    /**
     * 根据成绩id修改成绩方
     * 仅教师登录可用
     *
     * @date 3:20 PM 7/31/2019
     * @param gradeBean 需要用到 gradeId 成绩id ，grade 分数
     * @param session session
     * @return boolean
     */
    @PostMapping("/put")
    public Msg alterGrade(@RequestBody GradeBean gradeBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = gradeService.alterGrade(gradeBean.getGradeId(), gradeBean.getGrade());
            if (b) {
                return new Msg().setMsg(Constant.SUCCESS,Constant.ALTER_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ALTER_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }
}
