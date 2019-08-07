package com.vz04.grade.service.login;

import java.util.Map;

/**
 * 登录业务处理接口
 *
 * @author vz04
 * @date 7/27/2019 10:59 AM
 **/
public interface LoginService {


    /**
     * 进行登录校验的接口
     * 需要检验账户是否存在
     * 需要检验密码是否正确
     *
     * @date 7/27/2019 10:59 AM
     * @param accountNumber 账号
     * @param password 密码
     * @return Map<String,Object>
     */
    Map<String,Object> loginCheck(String accountNumber, String password);

    /**
     * 利用账户id修改班级id
     *
     * @date 5:25 PM 7/31/2019
     * @param accountId 账号id
     * @param classesId 班级id
     * @return boolean
     */
    boolean alterClassesIdInAccountId(Integer accountId ,Integer classesId);
}
