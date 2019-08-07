package com.vz04.grade.service;

import com.vz04.grade.pojo.notice.NoticeBean;
import com.vz04.grade.service.notice.NoticeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试 com.vz04.grade.mapper.notice.NoticeMapper
 * @author vz04
 * @date 8/1/2019 11:21 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private NoticeService noticeService;

    /**
     * 测试根据班级id查看公告列表
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testNoticeMapper() {
        List<NoticeBean> noticeBeans = noticeService.checkNotice(1);
        Assert.assertNotNull(noticeBeans);
    }

    /**
     * 测试新增公告
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testAddNotice() {
        NoticeBean noticeBean = new NoticeBean();
        noticeBean.setClassesId(1);
        noticeBean.setNotice("测试公告");
        boolean b = noticeService.addNotice(noticeBean);
        Assert.assertTrue(b);
    }

    /**
     * 测试修改公告
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testAlterNotice() {
        NoticeBean noticeBean = new NoticeBean();
        noticeBean.setNoticeId(6);
        noticeBean.setNotice("测试公告6");
        boolean b = noticeService.alterNotice(noticeBean);
        Assert.assertTrue(b);
    }

    /**
     * 测试通过公告id删除公告
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testDeleteNotice() {
        boolean b = noticeService.deleteNotice(6);
        Assert.assertTrue(b);
    }
}
