package com.sky.ssm.service;

import com.sky.ssm.model.User;
import com.sky.ssm.model.vo.UserVO;

public interface IUserService {
	public User getUserById(int userId);

	public User getUserByUser(User user);

	public String GetUserList(UserVO userVO);

	public void Update(User user);

	public boolean Insert(User user);
}
