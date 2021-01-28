package com.yc.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.yc.mvc.biz.BizException;
import com.yc.mvc.biz.UserBiz;
import com.yc.mvc.dao.UserMapper;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.po.Result;

@RestController
public class UserAction {

	@Resource
	private UserBiz ubiz;

	@Resource
	private UserMapper um; 
	
	@PostMapping("login.do")
	public Result login(JsjUser user, HttpSession session) {
		JsjUser dbuser;
		try {
			dbuser = ubiz.login(user);
			session.setAttribute("loginedUser", dbuser);
			return Result.success("登录成功！", dbuser);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage(), null);
		}
	}
	
	@RequestMapping("getLoginedUser.do")
	public Result getLoginedUser(@SessionAttribute JsjUser loginedUser) {
		return Result.success("获取用户对象成功！", loginedUser);
	}
	
	@RequestMapping("regist.do")
	public Result regist(@Valid JsjUser user, Errors errors) {
		if(errors.hasErrors()) {
			return Result.failure("获取用户对象成功！", errors.getAllErrors());
		}
		int i = ubiz.regist(user);
		if(i > 0) {
			return Result.success("注册成功！", user);
		}else {
			return Result.failure("获取用户对象成功！", null);
		}
		
		
	}
	
	@PostMapping("upload.do")
	public Result upload(@RequestParam("headImgFile") MultipartFile headImgFile,
			@SessionAttribute JsjUser loginedUser) {
		String newfile = UUID.randomUUID().toString();
		String oldfile = headImgFile.getOriginalFilename();
		//
		String suffix = oldfile.substring(oldfile.lastIndexOf("."));
		newfile += suffix;
		try {
			headImgFile.transferTo(new File("f:/jsj/upload_head", newfile));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return Result.failure("文件上传失败！", null);
		}
		
		String webpath = "upload_head/" + newfile;
		loginedUser.setHeadImg(webpath);
		ubiz.updataHeadImg(loginedUser);
		return Result.success("文件上传成功！", webpath);
	}
	
	@RequestMapping("queryLastLoginUsers.do")
	public List<JsjUser> queryLastLoginUsers() {
		return um.queryLastLoginUsers();
	}
	
	@RequestMapping("queryregTimeUsers.do")
	public List<JsjUser> queryregTimeUsers() {
		return um.queryregTimeUsers();
	}
	
}
