package com.wzj.ssm.service;



import java.io.Serializable;
import java.util.List;

import com.wzj.ssm.entity.QueryCondition;



/**
 * @Title: BaseServiceImpl.java
 */
public interface BaseService<T> {

	public int insert(T t);

	public void updateByPrimaryKey(T t);

	public void updateByPrimaryKeySelective(T t);

	public void deleteByPrimaryKey(Serializable id);

	public T selectByPrimaryKey(Serializable id);

	public List<T> selectAll();
	
	public List<T> selectListByCondition(QueryCondition condition);

	public T selectOne(T t);
}
