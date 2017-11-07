package com.sky.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.ssm.common.CommHelper;
import com.sky.ssm.common.DES;
import com.sky.ssm.common.JsonResult;
import com.sky.ssm.common.MD5Util;
import com.sky.ssm.model.User;
import com.sky.ssm.service.IUserService;

@Controller
public class AccountController {

	@Autowired
	IUserService userService;
	@RequestMapping("login")
	public String Login(){
		return "User/Login";
	}
	@RequestMapping("index")
	public String Index(){
		return "Index";
	}
	@RequestMapping("logindo")
	@ResponseBody
	public JsonResult Login(String userName,String password) {
		//后期要开发一个拦截器之类的把参数首尾空格去掉
		//StringBuilder：线程非安全的	　　　　StringBuffer：线程安全的
		StringBuilder sbErro=new StringBuilder();
		if(CommHelper.StringIsNullOrEmpety(userName)){
			sbErro.append("用户名不能为空;");
		}
		if(CommHelper.StringIsNullOrEmpety(password)){
			sbErro.append("密码不能为空;");
		}
		if(sbErro.length()>0){
			//返回错误信息，去除末尾的分号
			return JsonResult.fail(sbErro.substring(0,sbErro.length()-1));
		}
		User user=new User();
		user.setUserName(userName);
		user.setPassword(MD5Util.getMD5(password));		
		user=userService.getUserByUser(user);
		if(user==null){
			return JsonResult.fail("用户名或密码错误");
		}
		return JsonResult.successMessage("");
	}

}
