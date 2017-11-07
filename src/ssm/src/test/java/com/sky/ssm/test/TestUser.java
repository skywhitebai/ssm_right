package com.sky.ssm.test;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;import org.apache.log4j.helpers.MDCKeySetExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sky.ssm.common.MD5Util;
import com.sky.ssm.model.User;
import com.sky.ssm.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestUser {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	@Resource
	private IUserService userService ;

	@Test
	public void test() {
		for(int i=0;i<100;i++){
			User user=new User();
			user.setUserName("test"+i);
			user.setPassword(MD5Util.getMD5("123"));
			user.setRealName("測試"+i);
			user.setCreateTime(new Date());
			user.setCreateBy(0);
			user.setSex(i%2+1);
			user.setDeleted(0);
			user.setEmail("bxp"+i+"@163.com");
			user.setMoblie("123456");
			user.setQq("54135"+i);
			user.setRemark("1233123");
			user.setWechat("wahceaes");
			userService.Insert(user);
			logger.info(JSON.toJSONString(user));
		}
	}
}
