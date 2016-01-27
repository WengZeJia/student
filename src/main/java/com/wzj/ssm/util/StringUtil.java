package com.wzj.ssm.util;

public class StringUtil {

	/**
	 * 判断字符串是否为空或空串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0 || "null".equals(str.trim())) ? true : false;
	}

	/**
	 * 将字符串的第一个字母转成大写表示
	 * @param newStr
	 * @return
	 */
	public static String makeFirstLetterUpperCase(String newStr) {
		if (newStr.length() == 0) {
			return newStr;
		}
		char[] oneChar = new char[1];
		oneChar[0] = newStr.charAt(0);
		String firstChar = new String(oneChar);
		return firstChar.toUpperCase() + newStr.substring(1);
	}
	
	/**
	 * 判断传入的字符串是否为空，
	 * @param source
	 * @param defaultInt
	 * @return
	 */
	public static Integer parseIntIsNullGetDef(String source, Integer defaultInt) {
		return isEmpty(source) ? defaultInt : Integer.valueOf(source);
	}
	
	
}
