package com.sky.ssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.ssm.common.CommHelper;
import com.sky.ssm.common.JsonResult;
import com.sky.ssm.common.PageInfo;
import com.sky.ssm.model.User;
import com.sky.ssm.model.vo.UserVO;
import com.sky.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex( Model model) {
        User user = this.userService.getUserById(1);
        model.addAttribute("user", user);
        return "User";
    }
    @RequestMapping("/list")
    public String list(){
    	return "User/List";
    }
    
    @RequestMapping("/GetUserList")
    @ResponseBody
    public String getUserList(UserVO userVO,HttpServletRequest request ){    	
    		if (request.getParameter("rows") != null) {
    			userVO.setPageSize(Integer.parseInt(request.getParameter("rows"))); 
    		}
    		if (request.getParameter("page") != null) {
    			userVO.setPageIndex(Integer.parseInt(request.getParameter("page"))); 
    		}
    	String userListJson=userService.GetUserList(userVO);
    	return userListJson;
    }
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(User user){    	
    	StringBuilder sbErro=new StringBuilder();
    	if(CommHelper.StringIsNullOrEmpety(user.getUserName())){
    		sbErro.append("用户名称不能为空;");
    	}
    	if(CommHelper.StringIsNullOrEmpety(user.getRealName())){
    		sbErro.append("用户姓名不能为空;");
    	}
    	if(sbErro.length()>0){
    		return JsonResult.fail(sbErro.substring(0,sbErro.length()-1));
    	}

		User userExists=new User();
		userExists.setUserName(user.getUserName());
		userExists=userService.getUserByUser(userExists);
    	if(user.getUserId()==null){
    		//添加
    		if(userExists!=null){
    			return JsonResult.fail("用户名已存在");
    		}    		
    		user.setCreateBy(0);
    		user.setCreateTime(new Date());
    		userService.Insert(user);
        	return JsonResult.successMessage("添加成功");
    	}
    	else{
    		if(userExists!=null&&!CommHelper.dataEquals(user.getUserId(),userExists.getUserId())){
    			return JsonResult.fail("用户名已存在");
    		}
    		User userOld=userService.getUserById(user.getUserId());
    		if(userOld==null){
    			return JsonResult.fail("用户不存在");
    		}
    		
    		user.setCreateBy(userOld.getCreateBy());
    		user.setCreateTime(userOld.getCreateTime());
    		user.setUpdateBy(0);
    		user.setUpdateTime(new Date());
    		userService.Update(user);
        	return JsonResult.successMessage("修改成功");
    	}
    }
}
