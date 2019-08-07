package com.vz04.grade.mapper;

import com.vz04.grade.mapper.login.LoginMapper;
import com.vz04.grade.pojo.login.AccountBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试com.vz04.grade.mapper.login.LogInDao中的方法
 * @author vz04
 * @date 8/1/2019 11:20 AM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginMapperTest {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 根据班级id修改班级
     *
     * @date 10:22 AM 7/27/2019
     **/
    @Test
    public void testAlterClasseId() {
        int i = loginMapper.alterClasseId(1);
        Assert.assertNotSame(-1,i);
    }

    /**
     * 账户信息获取校验
     *
     * @date 10:22 AM 7/27/2019
     **/
    @Test
    public void testGetAccount() {
        AccountBean account = loginMapper.getAccount("10009");
        Assert.assertNotNull(account);
    }

    /**
     * 修改班级id
     *
     * @date 10:22 AM 7/27/2019
     **/
    @Test
    public void testAlterClassesIdInAccountId() {
        int i = loginMapper.alterClassesIdInAccountId(2, 2);
        Assert.assertSame(1,i);
    }


}
