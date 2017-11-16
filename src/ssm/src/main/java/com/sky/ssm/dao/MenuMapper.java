package com.sky.ssm.dao;

import java.util.List;

import com.sky.ssm.model.Menu;
import com.sky.ssm.model.vo.MenuVO;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

	List<Menu> getAll();

	List<MenuVO> getAllMenuVO();

	int getMenuListCount(MenuVO menuVO);

	List<MenuVO> getMenuList(MenuVO menuVO);
}