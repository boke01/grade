package com.vz04.grade;

import com.vz04.grade.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * SpringBoot创建的一个测试类模板
 * 用来测试一些工具类
 *
 * @author vz04
 * @date 7/27/2019 4:27 PM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeApplicationTests {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {}

    /**
     * md5加密测试
	 *
     * @date 10:22 AM 7/27/2019
     **/
    @Test
	public void md5(){
		log.debug(Md5Util.md5Encode("123456"));
	}
}
