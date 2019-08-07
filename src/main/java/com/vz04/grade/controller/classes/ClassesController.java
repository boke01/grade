package com.vz04.grade.controller.classes;

import com.vz04.grade.pojo.classec.ClassesBean;
import com.vz04.grade.pojo.msg.Msg;
import com.vz04.grade.service.classes.ClassesService;
import com.vz04.grade.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 与班级管理相关的Controller
 *
 * @author vz04
 * @date 7/27/2019 3:51 PM
 **/
@RestController
@RequestMapping("/classes")
public class ClassesController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClassesService classesService;

    /**
     * 查看已有的所有班级，班级对应的id
     * 次接口登录后可用
     *
     * @date 12:01 PM 7/30/2019
     * @param session 获取session
     * @return Msgs
     **/
    @PostMapping("/get")
    public Msg viewAllClasses(HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        List<ClassesBean> classesBeans = classesService.checkAllClasses();
        return new Msg().setMsg(Constant.SUCCESS,Constant.CHECK_OPERATION_SUCCESSFUL,classesBeans);
    }

    /**
     * 传入一个班级名称来创建班级
     * 如果班级名称已有会创建失败
     * 此接口仅教师登录可用
     *
     * @date 4:06 PM 7/27/2019
     * @param session 获取session
     * @param classesBean 使用 nameClass 字段获取班级名称
     * @return Msg
     **/
    @PostMapping("/post")
    public Msg addClasses(@RequestBody ClassesBean classesBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = classesService.addClasses(classesBean.getNameClass());
            if (b) {
                log.info("用户："+session.getAttribute("accountId")+" 创建了班级："+classesBean.getNameClass());
                return new Msg().setMsg(Constant.SUCCESS,Constant.ADD_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ADD_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }

    /**
     * 传入班级id与班级要修改的名称来修改原来的班级名称
     * 如果要改的名称已经存在则修改失败
     * 如果传入的班级id不存在则修改失败
     * 此接口仅教师登录可用
     *
     * @date 1:37 PM 7/30/2019
     * @param classesBean 需要用到classesId nameClass两个字段
     * @return Msg
     **/
    @PostMapping("/put")
    public Msg alterClassses(@RequestBody ClassesBean classesBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = classesService.alterClassses(classesBean);
            if (b) {
                log.info("用户："+session.getAttribute("accountId")+" 将"+classesBean.getClassesId()+" 班级的名称修改为："+classesBean.getNameClass());
                return new Msg().setMsg(Constant.SUCCESS,Constant.ALTER_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ALTER_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }

    /**
     * 删除classesId指定的班级
     * 此接口仅教师登录可用
     *
     * @date 11:00 AM 7/31/2019
     * @param classesBean 使用到classesId
     * @param session session
     * @return Msg
     */
    @PostMapping("delete")
    public Msg deleteClasses(@RequestBody ClassesBean classesBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = classesService.deleteClasses(classesBean.getClassesId());
            if (b) {
                log.info("用户"+session.getAttribute("accountId")+" 删除了与班级："+classesBean.getClassesId()+" 相关的数据");
                return new Msg().setMsg(Constant.SUCCESS,Constant.DELETE_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.DELETE_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }
}
