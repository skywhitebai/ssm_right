package com.sky.ssm.service;

import com.sky.ssm.common.JsonResult;
import com.sky.ssm.model.Menu;
import com.sky.ssm.model.vo.MenuVO;

public interface IMenuService {

	String getMenuTree();

	String listTree();

	String menuList(MenuVO menuVO);

	String getMenuComboTree();

	boolean Insert(Menu menu);

	Menu getMenuByMenuId(Integer menuId);

	boolean updateByPrimaryKeySelective(Menu menu);

	void deleteByArray(Integer[] idArray);

	boolean deleteByMenuId(Integer menuId);

}
