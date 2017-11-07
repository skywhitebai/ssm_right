package com.sky.ssm.common;

public class CommHelper {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean StringIsNullOrEmpety(String str){
		if(str==null||str==""){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 判断两个值是否相等
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean dataEquals(Object a, Object b) {
		if (a == null) {
			if (b == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return a.equals(b);
		}
	}

}
