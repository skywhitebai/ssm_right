package com.sky.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.ssm.common.CommHelper;
import com.sky.ssm.dao.MenuMapper;
import com.sky.ssm.model.Menu;
import com.sky.ssm.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	MenuMapper menuMapper;
	public String getMenuTree() {
		List<Menu> menuList=menuMapper.getAll();
		StringBuilder sbMenuTree = new StringBuilder();
		sbMenuTree.append("[{text:'菜单'");			
		getTree(menuList,0,sbMenuTree);		
		sbMenuTree.append("}]");		
		//递归获取menuTree数据
		return sbMenuTree.toString();
	}
	private void getTree(List<Menu> menuList,int parentId,StringBuilder sbMenuTree){
		int childrenCount = 0;
		for (Menu menu : menuList) {
			if(CommHelper.dataEquals(menu.getParentId(),parentId)){
				childrenCount++;
				//第一个
				if(childrenCount==1){
					sbMenuTree.append(",children:[");
					sbMenuTree.append("{text:'");					
				}
				else{
					sbMenuTree.append(",{text:'");
				}
				sbMenuTree.append(menu.getMenuName());
				sbMenuTree.append("'");
				if(!CommHelper.StringIsNullOrEmpety(menu.getUrl())){
					sbMenuTree.append(",attributes:{url:'");
					sbMenuTree.append(menu.getUrl());
					sbMenuTree.append("'}");
				}
				getTree(menuList,menu.getMenuId(),sbMenuTree);
				sbMenuTree.append("}");
			}
		}
		if(childrenCount>0){
			sbMenuTree.append("]");			
		}
	}

}
