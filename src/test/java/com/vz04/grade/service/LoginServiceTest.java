package com.vz04.grade.service;

import com.vz04.grade.service.login.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * 测试com.vz04.grade.service.impl.LoginService
 * @author vz04
 * @date 8/1/2019 11:20 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    /**
     * 登录业务测试
     *
     * @date 12:22 PM 8/1/2019
     */
    @Test
    public void testLoginCheck() {
        Map<String, Object> stringObjectMap = loginService.loginCheck("10001", "123456");
        Assert.assertNotNull(stringObjectMap);
    }

    /**
     * 修改用户班级id
     *
     * @date 12:25 PM 8/1/2019
     */
    @Test
    public void test() {
        boolean b = loginService.alterClassesIdInAccountId(2, 3);
        Assert.assertTrue(b);
    }
}
