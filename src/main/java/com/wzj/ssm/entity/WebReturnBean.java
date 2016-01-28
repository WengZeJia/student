package com.wzj.ssm.entity;

import java.util.HashMap;
import java.util.Map;

public class WebReturnBean {
	private static String DEFAULT_KEY = "returnMsg";
	private Map<String, Object> returnMap = null;

	public WebReturnBean() {
		returnMap = new HashMap<String, Object>();
	}

	public WebReturnBean addMessage(Object object) {
		this.returnMap.put(DEFAULT_KEY, object);
		return this;
	}
	
	public WebReturnBean addMessage(String returnKey, Object object) {
		this.returnMap.put(returnKey, object);
		return this;
	}

	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}
	
}
