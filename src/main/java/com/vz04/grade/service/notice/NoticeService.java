package com.vz04.grade.service.notice;

import com.vz04.grade.pojo.notice.NoticeBean;


import java.util.List;

/**
 * 进行公告管理的接口
 *
 * @author vz04
 * @date 7/31/2019 10:20 AM
 **/
public interface NoticeService {

    /**
     * 获取公告的接口
     * 利用班级id来获取这个班的所有公告
     *
     * @date 10:22 AM 7/31/2019
     * @param classesId 班级id
     * @return List<NoticeBean>
     */
    List<NoticeBean> checkNotice(Integer classesId);

    /**
     * 新增公告的接口
     * 利用noticeBean中的数据来新建一条公告
     *
     * @date 10:24 AM 7/31/2019
     * @param noticeBean 公告的相关信息
     * @return boolean
     */
    boolean addNotice(NoticeBean noticeBean);

    /**
     * 修改公告内容
     * 利用noticeBean中的数据来新建一条公告
     *
     * @date 10:31 AM 7/31/2019
     * @param noticeBean 公告的相关信息
     * @return boolean
     */
    boolean alterNotice(NoticeBean noticeBean);

    /**
     * 根据公告id删除公告
     *
     * @date 10:33 AM 7/31/2019
     * @param noticeId 公告id
     * @return boolean
     */
    boolean deleteNotice(Integer noticeId);
}
