package com.sky.ssm.common;

import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class PageInfo<T> {

	int total;
	List<T> records= Collections.emptyList();
	int rows;
	int page;
	int rowStart;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public int getRows() {
		if(rowStart<1){
			rowStart=10;
		}
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRowStart() {
		
		this.rowStart=(page-1)*rows;
		if(rowStart<0){
			rowStart=0;
		}
		return rowStart;
	}
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}
	public String jsonPage() {
		JSONObject jo = new JSONObject();
		jo.put("total", this.getTotal());
		jo.put("rows", this.getRecords());		
		return JSON.toJSONString(jo, SerializerFeature.BrowserCompatible);
	}
	
}
