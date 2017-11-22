package com.sky.ssm.service;

import com.sky.ssm.model.Role;
import com.sky.ssm.model.vo.RoleVO;

public interface IRoleService {

	String roleList(RoleVO roleVO);

	boolean Insert(Role role);

	Role getRoleByRoleId(Integer roleId);

	void updateByPrimaryKeySelective(Role role);

	void deleteByRoleId(Integer roleId);

}
