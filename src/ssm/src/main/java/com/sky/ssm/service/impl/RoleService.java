package com.sky.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.ssm.common.PageInfo;
import com.sky.ssm.dao.RoleMapper;
import com.sky.ssm.model.Role;
import com.sky.ssm.model.vo.RoleVO;
import com.sky.ssm.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	RoleMapper roleMapper;
	public String roleList(RoleVO roleVO) {
		PageInfo<RoleVO> pageInfo=new PageInfo<RoleVO>();
		int listCount=roleMapper.getRoleListCount(roleVO);
		pageInfo.setTotal(listCount);
		if(listCount>roleVO.getStartRow()){
			List<RoleVO> list=roleMapper.getRoleList(roleVO);
			pageInfo.setRecords(list);
		}
		return pageInfo.jsonPage();
	}
	public boolean Insert(Role role) {
		int result=roleMapper.insert(role);
		return result>0;
	}
	public Role getRoleByRoleId(Integer roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}
	public void updateByPrimaryKeySelective(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}
	public void deleteByRoleId(Integer roleId) {
		roleMapper.deleteByPrimaryKey(roleId);
	}

	
}
