package com.yc.spring.bank.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.bean.Record;
import com.yc.spring.common.dao.BaseDao;

@Repository
public class RecordDao extends BaseDao<Record> {

	@Resource
	private JdbcTemplate jt;

	@Override
	public void insert(Record e) {
		jt.update("insert into oprecord values(null,?,?,null,null)", e.getAccountId(), e.getOpmoney());
	}
	
	
}
