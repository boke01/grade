package com.vz04.grade.service.notice.impl;

import com.vz04.grade.mapper.classes.ClassesMapper;
import com.vz04.grade.mapper.notice.NoticeMapper;
import com.vz04.grade.pojo.classec.ClassesBean;
import com.vz04.grade.pojo.notice.NoticeBean;
import com.vz04.grade.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公告管理的实现类
 * @author vz04
 * @date 7/31/2019 10:34 AM
 **/
@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 查询属于classesId班级的全部公告
     *
     * @date 10:35 AM 7/31/2019
     * @param classesId 班级id
     * @return List<NoticeBean>
     */
    @Override
    public List<NoticeBean> checkNotice(Integer classesId) {
        return noticeMapper.checkNotice(classesId);
    }

    /**
     * 为classesId班级新增一条公告
     *
     * @date 10:35 AM 7/31/2019
     * @param noticeBean 公告的相关数据
     * @return boolean;
     */
    @Override
    public boolean addNotice(NoticeBean noticeBean) {
        Integer classesId = noticeBean.getClassesId();
        ClassesBean classes = classesMapper.checkClassesInid(classesId);
        if (classes == null){
            return false;
        }
        int i = noticeMapper.addNotice(classesId, noticeBean.getNotice());
        return i==1;
    }

    /**
     * 修改noticeId对应公告内容
     *
     * @date 10:35 AM 7/31/2019
     * @param noticeBean 公告的相关数据
     * @return boolean
     */
    @Override
    public boolean alterNotice(NoticeBean noticeBean) {
        int i = noticeMapper.alterNotice(noticeBean.getNoticeId(), noticeBean.getNotice());
        return i==1;
    }

    /**
     * 根据公告id来删除对应的公告
     *
     * @date 10:36 AM 7/31/2019
     * @param noticeId 公告id
     * @return boolean
     */
    @Override
    public boolean deleteNotice(Integer noticeId) {
        int i = noticeMapper.deleteNotice(noticeId);
        return i>=0;
    }
}
