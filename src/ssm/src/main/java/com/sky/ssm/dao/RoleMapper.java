package com.sky.ssm.dao;

import java.util.List;

import com.sky.ssm.model.Role;
import com.sky.ssm.model.vo.RoleVO;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	int getRoleListCount(RoleVO roleVO);

	List<RoleVO> getRoleList(RoleVO roleVO);
}