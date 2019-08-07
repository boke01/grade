package com.vz04.grade.mapper.notice;

import com.vz04.grade.pojo.notice.NoticeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 与公告功能相关的数据接口
 *
 * @author vz04
 * @date 7/30/2019 5:08 PM
 **/
@Mapper
@Repository
public interface NoticeMapper {

    /**
     * 根据班级id查看公告的数据接口
     *
     * @date 9:45 AM 7/31/2019
     * @param classesId 班级id
     * @return List<NoticeBean>
     */
    List<NoticeBean> checkNotice(@Param("classesId") Integer classesId);

    /**
     * 新增公告的数据接口
     *
     * @date 9:25 AM 7/31/2019
     * @param classesId 班级id
     * @param notice 公告内容
     * @return int
     */
    int addNotice(@Param("classesId") Integer classesId, @Param("notice") String notice);

    /**
     * 修改公告的数据接口
     *
     * @date 9:55 AM 7/31/2019
     * @param noticeId 公告id
     * @param notice 公告内容
     * @return int
     */
    int alterNotice(@Param("noticeId") Integer noticeId, @Param("notice") String notice);

    /**
     * 根据班级id来删除公告的数据接口
     * 给删除班级的功能使用
     *
     * @date 5:29 PM 7/30/2019
     * @param classesId 班级id
     * @return int
     */
    int deleteNoticeInClasses(@Param("classesId") Integer classesId);

    /**
     * 根据消息id来删除公告的数据接口
     *
     * @date 5:32 PM 7/30/2019
     * @param noticeId 公告id
     * @return int
     */
    int deleteNotice(@Param("noticeId") Integer noticeId);
}
