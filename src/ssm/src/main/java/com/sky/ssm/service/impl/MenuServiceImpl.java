package com.sky.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.ssm.common.CommHelper;
import com.sky.ssm.common.PageInfo;
import com.sky.ssm.dao.MenuMapper;
import com.sky.ssm.model.Menu;
import com.sky.ssm.model.vo.MenuVO;
import com.sky.ssm.model.vo.UserVO;
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
	
	/**
	 * 获取treeGrid数据
	 */
	public String listTree() {
		
		List<MenuVO> menuList=menuMapper.getAllMenuVO();
		StringBuilder sbListTree=new StringBuilder();
		sbListTree.append("[{menuId:0,menuName:'菜单',url:'',parentId:null,remark:'',orderBy:null,createTimeStr:'',updateTimeStr:''");			
		getListTree(menuList,0,sbListTree);		
		sbListTree.append("}]");	
		return sbListTree.toString();
	}
	private void getListTree(List<MenuVO> menuList,int parentId,StringBuilder sbListTree){
		int childrenCount = 0;
		for (MenuVO menu : menuList) {
			if(CommHelper.dataEquals(menu.getParentId(),parentId)){
				childrenCount++;
				//第一个
				if(childrenCount==1){
					sbListTree.append(",children:[");	
				}
				else{
					sbListTree.append(",");
				}
				sbListTree.append("{menuId:")
					.append(menu.getMenuId())
					.append(",menuName:'")
					.append(menu.getMenuName())
					.append("',url:'")
					.append(menu.getUrl())
					.append("',parentId:")
					.append(menu.getParentId())
					.append(",remark:'")
					.append("',orderBy:")
					.append(menu.getOrderBy())
					.append(",createTimeStr:'")
					.append(menu.getCreateTimeStr())
					.append("',updateTimeStr:'")
					.append(menu.getUpdateTimeStr())
					.append("'");
				
				getListTree(menuList,menu.getMenuId(),sbListTree);
				sbListTree.append("}");
			}
		}
		if(childrenCount>0){
			sbListTree.append("]");			
		}
	}
	public String menuList(MenuVO menuVO) {
		PageInfo<MenuVO> pageInfo=new PageInfo<MenuVO>();
		int menuListCount=menuMapper.getMenuListCount(menuVO);
		pageInfo.setTotal(menuListCount);
		if(menuListCount>menuVO.getStartRow()){
			List<MenuVO> menuList=menuMapper.getMenuList(menuVO);
			pageInfo.setRecords(menuList);
		}
		return pageInfo.jsonPage();
	}
	
	
	public String getMenuComboTree() {
		List<Menu> menuList=menuMapper.getAll();
		StringBuilder sbMenuComboTree = new StringBuilder();
		sbMenuComboTree.append("[{id:0,text:'菜单'");			
		menuComboTree(menuList,0,sbMenuComboTree);		
		sbMenuComboTree.append("}]");		
		//递归获取数据
		return sbMenuComboTree.toString();
	}
	private void menuComboTree(List<Menu> menuList,int parentId,StringBuilder sbMenuTree){
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
				sbMenuTree.append("',id:");
				sbMenuTree.append(menu.getMenuId());
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
	public boolean Insert(Menu menu) {
		int result=menuMapper.insert(menu);
		return result>0;
	}
	public Menu getMenuByMenuId(Integer menuId) {
		return menuMapper.selectByPrimaryKey(menuId);
	}
	public boolean updateByPrimaryKeySelective(Menu menu) {
		int result=menuMapper.updateByPrimaryKeySelective(menu);
		return result>0;
	}
}
