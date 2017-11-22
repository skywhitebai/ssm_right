package com.sky.ssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sky.ssm.common.JsonResult;
import com.sky.ssm.model.Role;
import com.sky.ssm.model.User;
import com.sky.ssm.model.vo.RoleVO;
import com.sky.ssm.service.IRoleService;

@Controller
@RequestMapping("role")
public class RoleController{

	@Autowired
	IRoleService roleService;
	@RequestMapping("list")
	public String List(){
		return "Role/List";
	}
	
	@RequestMapping("menuList")
	@ResponseBody
	public String menuList(RoleVO roleVO){
		String list=roleService.roleList(roleVO);		
		return list;
	}
	
	
	@RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Role role,HttpServletRequest request){   
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
    	if(StringUtils.isEmpty(role.getRoleName())){
    		sbErro.append("角色名称不能为空;");
    	}
    	if(sbErro.length()>0){
    		return JsonResult.fail(sbErro.substring(0,sbErro.length()-1));
    	}
		
    	if(role.getRoleId()==null){
    		//添加    		
    		role.setCreateBy(loginUser.getUserId());
    		role.setCreateTime(new Date());
    		roleService.Insert(role);
        	return JsonResult.successMessage("添加成功");
    	}
    	else{    		
    		Role old=roleService.getRoleByRoleId(role.getRoleId());
    		if(old==null){
    			return JsonResult.fail("菜单不存在");
    		}
    		role.setCreateBy(old.getCreateBy());
    		role.setCreateTime(old.getCreateTime());
    		role.setUpdateBy(loginUser.getUserId());
    		role.setUpdateTime(new Date());
    		roleService.updateByPrimaryKeySelective(role);
        	return JsonResult.successMessage("修改成功");
    	}
    }
	
	@ResponseBody
	@RequestMapping("delete")
	public JsonResult delete(Integer roleId){
		if(roleId==null){
			return JsonResult.fail("请选择要删除的数据");
		}
		roleService.deleteByRoleId(roleId);
		 
		 return JsonResult.successMessage("删除成功");
	}
}
