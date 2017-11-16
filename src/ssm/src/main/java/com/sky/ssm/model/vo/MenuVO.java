package com.sky.ssm.model.vo;

import com.sky.ssm.model.Menu;

public class MenuVO extends Menu {

	private int rows;
	private int page;
	private int startRow=0;
	String createTimeStr;
	String updateTimeStr;
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		changeStartRow();
		this.rows = rows;
	}
	public int getPage() {
		changeStartRow();
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public String getUpdateTimeStr() {
		return updateTimeStr;
	}
	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}
	
	private void changeStartRow(){
		this.startRow=(page-1)*rows;
		if(startRow<0){
			startRow=0;
		}
	}
	
}
