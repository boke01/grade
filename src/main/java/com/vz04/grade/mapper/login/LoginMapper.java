package com.vz04.grade.mapper.login;

import com.vz04.grade.pojo.login.AccountBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 与登录相关的数据接口
 *
 * @author vz04
 * @date 7/27/2019 9:54 AM
 **/
@Mapper
@Repository
public interface LoginMapper {

    /**
     * 获取账号获取账户的accountId, accountNumber, password, identity, classesId
     *
     * @date 7/27/2019 9:54 AM
     * @param accountNumber 账号
     * @return AccountBean
     */
    AccountBean getAccount(@Param("accountNumber") String accountNumber);

    /**
     * 将账户表中班级id为classesId的值修改为0
     * 给班级删除使用
     *
     * @date 8:38 AM 7/31/2019
     * @param classesId 班级id
     * @return int
     */
    int alterClasseId(@Param("classesId") Integer classesId);

    /**
     * 通过账户id修改班级id
     *
     * @date 5:15 PM 7/31/2019
     * @param accountId 账号id
     * @param classesId 班级id
     * @return int
     */
    int alterClassesIdInAccountId(@Param("accountId") Integer accountId ,@Param("classesId") Integer classesId);
}
