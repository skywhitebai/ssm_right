package com.sky.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.ssm.common.JsonResult;
import com.sky.ssm.model.Menu;
import com.sky.ssm.service.IMenuService;

import java.util.ArrayList;
import java.util.List;
@Controller 
@RequestMapping("menu")
public class MenuController {

	@Autowired 
	IMenuService menuService;
	
	@RequestMapping("list")
	public String List(){
		return "Menu/List";
	}
	@RequestMapping("menutree")
	@ResponseBody
	public JsonResult MenuTree(){
		String menuTree=menuService.getMenuTree();
		
		return JsonResult.successData(menuTree);
	}
}
