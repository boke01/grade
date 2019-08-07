package com.vz04.grade.controller.notice;

import com.vz04.grade.pojo.msg.Msg;
import com.vz04.grade.pojo.notice.NoticeBean;
import com.vz04.grade.service.notice.NoticeService;
import com.vz04.grade.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 公告功能相关的controller
 * @author vz04
 * @date 7/31/2019 10:50 AM
 **/
@RestController
@RequestMapping("/notice")
public class NoticeController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NoticeService noticeService;

    /**
     * 根据班级id来查看这个班的全部公告
     * 此接口需要登录后才能使用
     *
     * @date 10:57 AM 7/31/2019
     * @param noticeBean 使用classesId
     * @param session session
     * @return Msg
     */
    @PostMapping("/get")
    public Msg checkNotice(@RequestBody NoticeBean noticeBean,HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        List<NoticeBean> list = noticeService.checkNotice(noticeBean.getClassesId());
        return new Msg().setMsg(Constant.SUCCESS,Constant.CHECK_OPERATION_SUCCESSFUL,list);
    }

    /**
     * 向classesId班级新增一条公告
     * 此接口仅教师登录有效
     *
     * @date 11:08 AM 7/31/2019
     * @param noticeBean 需要用到classesId，notice 这两个字段
     * @param session session
     * @return Msg
     */
    @PostMapping("/post")
    public Msg addNotice(@RequestBody NoticeBean noticeBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = noticeService.addNotice(noticeBean);
            if (b) {
                log.info("用户："+session.getAttribute("accountId")+" 向"+noticeBean.getClassesId()+" 班级新增了一条公告");
                return new Msg().setMsg(Constant.SUCCESS,Constant.ADD_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ADD_NOTICE_DEFATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }

    /**
     * 将noticeId对应的公告内容修改为notice
     * 此接口仅教师登录有效
     *
     * @date 11:17 AM 7/31/2019
     * @param noticeBean 需要用到noticeId，notice 这两个字段
     * @param session session
     * @return Msg
     */
    @PostMapping("/put")
    public Msg alterNotice(@RequestBody NoticeBean noticeBean, HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = noticeService.alterNotice(noticeBean);
            if (b) {
                log.info("用户："+session.getAttribute("accountId")+" 修改了 "+noticeBean.getNoticeId()+" 这条公告的内容");
                return new Msg().setMsg(Constant.SUCCESS,Constant.ALTER_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.ALTER_OPERATION_DEFEATED,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }

    /**
     * 删除noticeId对应的公告
     * 此接口仅教师登录有效
     *
     * @date 11:22 AM 7/31/2019
     * @param noticeBean 使用noticeId 公告id
     * @param session session
     * @return Msg
     */
    @PostMapping("/delete")
    public Msg deleteNotice(@RequestBody NoticeBean noticeBean,HttpSession session) {
        Object identity = session.getAttribute("identity");
        if (identity == null) {
            return new Msg().setMsg(Constant.DEFEATED,Constant.PLEASE_LOGIN,null);
        }
        if (identity.equals(0)) {
            boolean b = noticeService.deleteNotice(noticeBean.getNoticeId());
            if (b) {
                log.info("用户："+session.getAttribute("accountId")+" 删除了 "+noticeBean.getNoticeId()+" 这条公告");
                return new Msg().setMsg(Constant.SUCCESS,Constant.DELETE_OPERATION_SUCCESSFUL,null);
            }else {
                return new Msg().setMsg(Constant.DEFEATED,Constant.DELETE_OPERATION_SUCCESSFUL,null);
            }
        }else {
            return new Msg().setMsg(Constant.UNAUTHORIZED,Constant.HAVE_NO_RIGHT,null);
        }
    }
}
