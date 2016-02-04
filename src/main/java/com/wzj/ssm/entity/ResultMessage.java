package com.wzj.ssm.entity;

import java.util.HashMap;
import java.util.Map;

public class ResultMessage {
	private static String DEFAULT_KEY = "returnMsg";
	private Map<String, Object> returnMap = null;

	public ResultMessage() {
		returnMap = new HashMap<String, Object>();
	}

	public ResultMessage addMessage(Object object) {
		this.returnMap.put(DEFAULT_KEY, object);
		return this;
	}
	
	public ResultMessage addMessage(String returnKey, Object object) {
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
