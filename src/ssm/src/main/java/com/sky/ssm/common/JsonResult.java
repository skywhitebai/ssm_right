package com.sky.ssm.common;

import java.util.HashMap;
import java.util.Map;


public class JsonResult {
	//返回数据
	private Object data;
	//状态
	private int status;
	//返回信息
	private String message;
	//用户要返回给浏览器的数据
	private Map<String, Object> extend = new HashMap<String, Object>();
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	public static JsonResult successData(Object data){
		JsonResult result=new JsonResult();
		result.setData(data);
		result.status=1;
		return result;
	}
	public static JsonResult successMessage(String message){
		JsonResult result=new JsonResult();
		result.setMessage(message);
		result.status=1;
		return result;
	}
	public static JsonResult  fail(String message){
		JsonResult result=new JsonResult();
		result.setMessage(message);
		result.status=-1;
		return result;
	}	
	public JsonResult add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	
	
}
