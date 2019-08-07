package com.vz04.grade.controller.course;

import com.vz04.grade.pojo.course.CourseBean;
import com.vz04.grade.pojo.msg.Msg;
import com.vz04.grade.service.course.CourseService;
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
 * 与课程管理相关的controller
 * @author vz04
 * @date 8/1/2019 8:15 AM
 **/
@RestController
@RequestMapping("/course")
public class CourseController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseService courseService;

    /**
     * 用于添加课程的方法
     * 教师登录后可用
     *
     * @date 3:58 PM 7/31/2019
     * @param courseBean 使用 courseTitle 课程名称
     * @param session 获取session
     * @return Msg
     */
    @PostMapping("/post")
    public Msg addCourse(@RequestBody CourseBean courseBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = courseService.addCourse(courseBean.getCourseTitle());
            if (b){
                log.info("用户："+session.getAttribute("accountId")+" 创建了课程："+courseBean.getCourseTitle());
                return new Msg().setMsg(Constant.SUCCESS,Constant.ADD_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ADD_OPERATION_DEFEATED,null);
            }

        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }

    /**
     * 获取现有全部课程信息的接口实现
     * 登录后可用
     *
     * @date 3:59 PM 7/31/2019
     * @param session 获取session
     * @return Msg
     */
    @PostMapping("/get")
    public Msg checkAllCourse(HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        List<CourseBean> courses = courseService.checkAllCourse();
        return new Msg().setMsg(Constant.SUCCESS,Constant.CHECK_OPERATION_SUCCESSFUL,courses);
    }

    /**
     * 根据课程id修改课程名称的方法
     * 仅教师登录可用
     *
     * @date 4:00 PM 7/31/2019
     * @param courseBean 需要用到 courseId 课程id ，courseTitle 课程名称
     * @param session 获取session
     * @return Msg
     */
    @PostMapping("/put")
    public Msg alterCourse(@RequestBody CourseBean courseBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = courseService.alterCourse(courseBean.getCourseId(), courseBean.getCourseTitle());
            if (b) {
                log.info("用户："+session.getAttribute("accountId")+" 将"+courseBean.getCourseId()+" 的课程名修改为："+courseBean.getCourseTitle());
                return new Msg().setMsg(Constant.SUCCESS,Constant.ALTER_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ALTER_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }

    /**
     * 根据课程id删除课程的方法
     * 同时删除与这门课相关的成绩
     * 仅教师登录可用
     *
     * @date 4:02 PM 7/31/2019
     * @param courseBean 需要用到 courseId 课程id
     * @return boolean
     */
    @PostMapping("/delete")
    public Msg deleteCourse(@RequestBody CourseBean courseBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = courseService.deleteCourse(courseBean.getCourseId());
            if (b) {
                log.info("用户"+session.getAttribute("accountId")+" 删除了与科目："+courseBean.getCourseId()+" 相关的数据");
                return new Msg().setMsg(Constant.SUCCESS,Constant.DELETE_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.DELETE_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }
}
