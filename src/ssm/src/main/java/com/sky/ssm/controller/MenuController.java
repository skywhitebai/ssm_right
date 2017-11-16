package com.sky.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.ssm.common.CommHelper;
import com.sky.ssm.common.JsonResult;
import com.sky.ssm.model.Menu;
import com.sky.ssm.model.User;
import com.sky.ssm.model.vo.MenuVO;
import com.sky.ssm.service.IMenuService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
	
	
	@RequestMapping("listtree")
	@ResponseBody
	public String listTree(){
		String listTree=menuService.listTree();		
		return listTree;
	}
	@RequestMapping("menuList")
	@ResponseBody
	public String menuList(MenuVO menuVO){
		String menuList=menuService.menuList(menuVO);		
		return menuList;
	}
	
	@RequestMapping("menucombotree")
	@ResponseBody
	public JsonResult menuComboTree(){
		String menuComboTree=menuService.getMenuComboTree();
		
		return JsonResult.successData(menuComboTree);
	}
	@RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Menu menu,HttpServletRequest request){   
		HttpSession session = request.getSession();
		Object object=session.getAttribute("loginUser");
		User loginUser=new User();
		if(object==null){
			return JsonResult.successMessage("用户未登录，请重新登录");	
		}
		else{
			loginUser=(User)object;
		}		
    	StringBuilder sbErro=new StringBuilder();
    	if(StringUtils.isEmpty(menu.getMenuName())){
    		sbErro.append("菜单名称不能为空;");
    	}
    	if(menu.getParentId()==null){
    		sbErro.append("父菜单不能为空;");
    	}
    	if(menu.getOrderBy()==null){
    		sbErro.append("排序不能为空;");
    	}
    	if(sbErro.length()>0){
    		return JsonResult.fail(sbErro.substring(0,sbErro.length()-1));
    	}
		
    	if(menu.getMenuId()==null){
    		//添加
    		
    		menu.setCreateBy(loginUser.getUserId());
    		menu.setCreateTime(new Date());
    		menuService.Insert(menu);
        	return JsonResult.successMessage("添加成功");
    	}
    	else{    		
    		Menu menuOld=menuService.getMenuByMenuId(menu.getMenuId());
    		if(menuOld==null){
    			return JsonResult.fail("菜单不存在");
    		}
    		menu.setCreateBy(menuOld.getCreateBy());
    		menu.setCreateTime(menuOld.getCreateTime());
    		menu.setUpdateBy(loginUser.getUserId());
    		menu.setUpdateTime(new Date());
    		menuService.updateByPrimaryKeySelective(menu);
        	return JsonResult.successMessage("修改成功");
    	}
    }
	@ResponseBody
	@RequestMapping("delete")
	public JsonResult delete(Integer menuId){
		if(menuId==null){
			return JsonResult.fail("请选择要删除的数据");
		}
		menuService.deleteByMenuId(menuId);
		 
		 return JsonResult.successMessage("删除成功");
	}
}
