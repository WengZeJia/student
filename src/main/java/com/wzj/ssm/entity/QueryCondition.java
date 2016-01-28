package com.wzj.ssm.entity;

import java.util.HashMap;
import java.util.Map;

public class QueryCondition {
	private Map<String,Object> queryConditions = null;
	public QueryCondition() {
		queryConditions = new HashMap<String,Object>();
	}
	
	public QueryCondition addCondition(String conditionName, Object params) {
		queryConditions.put(conditionName, params);
		return this;
	}
	
	public Map<String, Object> getQueryConditions() {
		return queryConditions;
	}
}
