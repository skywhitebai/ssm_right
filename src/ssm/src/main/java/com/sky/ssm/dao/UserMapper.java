package com.sky.ssm.dao;

import java.util.List;

import com.sky.ssm.model.User;
import com.sky.ssm.model.vo.UserVO;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectByUser(User user);

	List<UserVO> GetUserList(UserVO userVO);

	int GetUserListCount(UserVO userVO);
}