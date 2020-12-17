package com.yc.CZ21S2Plyspringboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.yc.CZ21S2Plyspringboot.biz.MailBiz;

@SpringBootTest
class Cz21S2PlySpringbootApplicationTests {
	
	@Resource
	private JdbcTemplate jt;

	@Test
	void contextLoads() {
		Assert.notNull(jt, "jt不能为空！");
		jt.update("insert into account values(null,?,?,?)", 230, "张三", "123");
		jt.update("insert into account values(null,?,?,?)", 1000, "李四", "1");
		jt.update("insert into account values(null,?,?,?)", 1200, "王五", "3");
		jt.update("insert into account values(null,?,?,?)", 7890, "赵六", "13");
	}
	@Resource
	private MailBiz mbiz;

	@Test
	void test1() {
		mbiz.sendSimpleMail("1079368619@qq.com", "测试邮件", "我的测试邮件：测试邮件");
	}
}
