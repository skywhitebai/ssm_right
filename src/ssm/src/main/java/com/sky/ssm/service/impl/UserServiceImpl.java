package com.sky.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.ssm.common.PageInfo;
import com.sky.ssm.dao.UserMapper;
import com.sky.ssm.model.User;
import com.sky.ssm.model.vo.UserVO;
import com.sky.ssm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper userMapper;
	public User getUserById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	public User getUserByUser(User user) {
		return	userMapper.selectByUser(user);
	}
	public String GetUserList(UserVO userVO) {
		PageInfo<UserVO> pageInfo=new PageInfo<UserVO>();
		int userListCount=userMapper.GetUserListCount(userVO);
		pageInfo.setTotal(userListCount);
		if(userListCount>userVO.getStartRow()){
			List<UserVO> userList=userMapper.GetUserList(userVO);
			pageInfo.setRecords(userList);
		}
		return pageInfo.jsonPage();
	}
	public boolean Insert(User user) {
		int result=userMapper.insert(user);
		return result>0;
	}
	public void Update(User user) {
		// TODO Auto-generated method stub
		
	}

}
