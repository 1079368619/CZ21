package com.yc.CZ21S2Plyspringboot.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yc.CZ21S2Plyspringboot.bean.Account;

@Repository
public class AccountDao {

	@Resource
	private JdbcTemplate jt;
	
	public void insert(Account e) {
		jt.update("insert into account values(null,?,?,?)", e.getBalance(), e.getName(), e.getPwd());
	}

	public void update(Account e) {
		String sql = "update account set balance = balance + ? where accountid=?";
		jt.update(sql, e.getBalance(), e.getAccountid());
	}

	@SuppressWarnings("deprecation")
	public Account selectById(int id) {
		String sql = "select * from account where accountid=?";
		Object[] params = {id};
		return jt.query(sql, params, rs -> {
			rs.next();
			Account a = new Account();
			a.setAccountid(rs.getInt("accountid"));
			a.setName(rs.getString("name"));
			a.setBalance(rs.getDouble("balance"));
			a.setPwd(rs.getString("pwd"));
			return a;
		});
	}
	
	public void transfer(Account e) {
		String sql = "update account set balance=balance-? where accountid=?";
		jt.update(sql, e.getBalance(), e.getAccountid());

	}

	public List<Account> selectAll() {
		String sql = "select * from account";
		
		return jt.query(sql, (rs,index)->{
			Account a = new Account();
			a.setAccountid(rs.getInt("accountid"));
			a.setName(rs.getString("name"));
			a.setBalance(rs.getDouble("balance"));
			a.setPwd(rs.getString("pwd"));
			return a;
		});
	}

}
