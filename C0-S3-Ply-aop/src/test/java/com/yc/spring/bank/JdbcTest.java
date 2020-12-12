package com.yc.spring.bank;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bank.biz.BankBiz;
import com.yc.spring.bank.dao.AccountDao;

@RunWith(SpringRunner.class)
//@ContextConfiguration("/bank-beans.xml")
@ContextConfiguration(classes = JdbcConfig.class)
public class JdbcTest {

	@Resource
	private JdbcTemplate jt;
	
	@Test
	public void test1() {
		Assert.assertNotNull(jt);
		jt.update("insert into account values(null,?,?,?)", 230, "张三", "123");
		jt.update("insert into account values(null,?,?,?)", 1000, "李四", "1");
		jt.update("insert into account values(null,?,?,?)", 1200, "王五", "3");
		jt.update("insert into account values(null,?,?,?)", 7890, "赵六", "13");
	}
	
	@Test
	public void test2() {
		String sql = "select * from account";
		//
		List<?> list = jt.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account a = new Account();
				a.setAccountid(rs.getInt("accountid"));
				a.setName(rs.getString("name"));
				a.setBalance(rs.getDouble("balance"));
				a.setPwd(rs.getString("pwd"));
				return a;
			}

		});
		System.out.println(list);

	}
	
	@Resource
	private BankBiz bbiz;
	@Resource
	private AccountDao adao;

	@Test
	public void testDeposit() throws IOException {
		int id = 1;
		
		Account a = adao.selectById(1);
		Assert.assertEquals((Double)5500d, a.getBalance());
		System.out.println(a);
		
		bbiz.deposit(1, 500);
		
		a = adao.selectById(1);
		Assert.assertEquals((Double)6000d, a.getBalance());
		System.out.println(a);
	}
	
	@Test
	public void testTransfer() throws IOException {
		int aid = 1;
		int bid = 3;
		Account a = adao.selectById(aid);
		Account b = adao.selectById(bid);
		System.out.println("账户" + aid + "的初始金额为" + a.getBalance());
		System.out.println("账户" + bid + "的初始金额为" + b.getBalance());
		bbiz.transfer(aid, bid, 500);
		
		a = adao.selectById(aid);
		b = adao.selectById(bid);
		System.out.println("账户" + aid + "的转账后金额为" + a.getBalance());
		System.out.println("账户" + bid + "的转账后金额为" + b.getBalance());

	}

}
