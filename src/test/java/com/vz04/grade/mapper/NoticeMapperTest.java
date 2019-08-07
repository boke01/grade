package com.vz04.grade.mapper;

import com.vz04.grade.mapper.notice.NoticeMapper;
import com.vz04.grade.pojo.notice.NoticeBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试接口com.vz04.grade.mapper.notice.NoticeMapper
 *
 * @author vz04
 * @date 8/1/2019 11:21 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeMapperTest {
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 测试根据班级id查看公告列表
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testNoticeMapper() {
        List<NoticeBean> noticeBeans = noticeMapper.checkNotice(1);
        Assert.assertNotNull(noticeBeans);
    }

    /**
     * 测试新增公告
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testAddNotice() {
        int i = noticeMapper.addNotice(1, "测试公告");
        Assert.assertSame(1,i);
    }

    /**
     * 测试修改公告
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testAlterNotice() {
        int i = noticeMapper.alterNotice(6, "测试公告1");
        Assert.assertSame(1,i);
    }

    /**
     * 测试通过公告id删除公告
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testDeleteNotice() {
        int i = noticeMapper.deleteNotice(1);
        Assert.assertSame(1,i);
    }

    /**
     * 测试通过班级id删除公告
     *
     * @date 8:27 AM 7/31/2019
     */
    @Test
    public void testDeleteNoticeInClasses() {
        int i = noticeMapper.deleteNoticeInClasses(1);
        Assert.assertNotSame(-1,i);
    }

}
