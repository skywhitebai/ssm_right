package com.sky.ssm.model.vo;

import com.sky.ssm.model.User;

public class UserVO extends User {

	int pageSize=10;
	int pageIndex=1;
	int startRow=0;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		changeStartRow();
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		changeStartRow();
		this.pageIndex = pageIndex;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	private void changeStartRow(){
		this.startRow=(pageIndex-1)*pageSize;
		if(startRow<0){
			startRow=0;
		}
	}
	
}
