package com.yc.cinema.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.cinema.dao.CinemaDao;

@Service
public class CinemaBiz {
	
	@Resource
	private UserBiz ubiz;
	
	@Resource
	private MovieBiz mbiz;
	
	@Resource
	private CinemaDao cdao;

	public UserBiz getUbiz() {
		return ubiz;
	}

	public void setUbiz(UserBiz ubiz) {
		this.ubiz = ubiz;
	}

	public MovieBiz getMbiz() {
		return mbiz;
	}

	public void setMbiz(MovieBiz mbiz) {
		this.mbiz = mbiz;
	}

	public CinemaDao getCdao() {
		return cdao;
	}

	public void setCdao(CinemaDao cdao) {
		this.cdao = cdao;
	}

}
