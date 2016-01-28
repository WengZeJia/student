package com.wzj.ssm.service.impl;



import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.wzj.ssm.dao.BaseMapper;
import com.wzj.ssm.dao.modelMapper.ExamMapper;
import com.wzj.ssm.dao.modelMapper.GradeMapper;
import com.wzj.ssm.dao.modelMapper.MarkMapper;
import com.wzj.ssm.dao.modelMapper.SchoolMapper;
import com.wzj.ssm.dao.modelMapper.StudentInfoMapper;
import com.wzj.ssm.dao.modelMapper.SubjectMapper;
import com.wzj.ssm.dao.modelMapper.SysPrivilegeMapper;
import com.wzj.ssm.dao.modelMapper.SysRoleMapper;
import com.wzj.ssm.dao.modelMapper.SysUrlMapper;
import com.wzj.ssm.dao.modelMapper.TeacherInfoMapper;
import com.wzj.ssm.entity.QueryCondition;
import com.wzj.ssm.service.BaseService;



/**
 * @Title: BaseServiceImpl.java
 */
@Service("baseService")
@Lazy
public class BaseServiceImpl<T> implements BaseService<T>{

	@Autowired
	protected BaseMapper<T> baseMapper;
	
	@Resource
	protected ExamMapper examMapper;
	@Resource
	protected GradeMapper gradeMapper;
	@Resource
	protected MarkMapper markMapper;
	@Resource
	protected SchoolMapper schoolMapper;
	@Resource
	protected StudentInfoMapper studentInfoMapper;
	@Resource
	protected SubjectMapper subjectMapper;
	@Resource
	protected TeacherInfoMapper teacherInfoMapper;
	@Resource
	protected SysRoleMapper sysRoleMapper;
	@Resource
	protected SysPrivilegeMapper sysPrivilegeMapper;
	@Resource
	protected SysUrlMapper sysUrlMapper;
	
	

	public int insert(T t) {
		return baseMapper.insert(t);
	}
	
	public int insertSelective(T t) {
		return baseMapper.insertSelective(t);
	}

	public void updateByPrimaryKey(T t) {
		baseMapper.updateByPrimaryKey(t);
	}

	public void updateByPrimaryKeySelective(T t) {
		baseMapper.updateByPrimaryKeySelective(t);
	}

	public void deleteByPrimaryKey(Serializable id) {
		baseMapper.deleteByPrimaryKey(id);
	}

	public T selectByPrimaryKey(Serializable id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	public List<T> selectAll() {
		return baseMapper.selectAll();
	}
	
	public List<T> selectListByCondition(QueryCondition condition) {
		return baseMapper.selectByCondition(condition.getQueryConditions());
	}

	public T selectOne(T t) {
		return baseMapper.selectOne(t);
	}
	
	public int selectCountByCondition(QueryCondition condition) {
		return baseMapper.selectCountByCondition(condition);
	}
	
}
