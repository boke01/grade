package com.vz04.grade.service.login.impl;

import com.vz04.grade.pojo.login.AccountBean;
import com.vz04.grade.mapper.login.LoginMapper;
import com.vz04.grade.service.login.LoginService;
import com.vz04.grade.util.Md5Util;
import com.vz04.grade.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录相关事务的实现
 *
 * @author vz04
 * @date 7/27/2019 11:19 AM
 **/
@Service
public class LoginServiceImpl implements LoginService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 实现登录验证
     * 根据查询结果判断账号是否存在，如果不存在直接返回提示信息
     * 如果账号存再，将传入密码进行md5加密，然后进行比较，如果相同返回提示信息与accountId，identity，classesId三个变量的值
     *
     * @date 11:21 AM 7/27/2019
     * @param accountNumber 账号
     * @param password 密码
     * @return 验证通过后的用户信息
     **/
    @Override
    public Map<String, Object> loginCheck(String accountNumber, String password) {
            Map<String, Object> map = new HashMap<String, Object>(16);
            AccountBean account = loginMapper.getAccount(accountNumber);
            if (account == null) {
                map.put("message", Constant.USER_NOT_EXIST);
            }else {
                password = Md5Util.md5Encode(password);
                if (account.getPassword().equals(password)){
                    map.put("message", Constant.LOGIN_SUCCESS);
                    map.put("accountId",account.getAccountId());
                    map.put("identity",account.getIdentity());
                    map.put("classesId",account.getClassesId());
                }else {
                    map.put("message", Constant.WRONG_PASSWORD);
                }
            }
            return map;
    }

    /**
     * 利用账户id修改班级id
     * 通过sql影响的行数来判断是否成功
     *
     * @date 5:25 PM 7/31/2019
     * @param accountId 账号id
     * @param classesId 班级id
     * @return boolean
     */
    @Override
    public boolean alterClassesIdInAccountId(Integer accountId, Integer classesId) {
        int i = loginMapper.alterClassesIdInAccountId(accountId, classesId);
        return i==1;
    }
}
