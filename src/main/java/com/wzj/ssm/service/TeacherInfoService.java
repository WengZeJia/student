package com.wzj.ssm.service;

import java.util.List;

import com.wzj.ssm.entity.TeacherInfo;

public interface TeacherInfoService extends BaseService<TeacherInfo> {

	/**
	 * 根据工号查询教师信息，并关联角色信息roleSet
	 * @param number
	 * @return
	 */
	public TeacherInfo getTeacherJoinRoleByNumber(String number);
	
	/**
	 * 批量删除
	 * @param teacherInfoIds
	 */
	public void deleteList(List<Integer> teacherInfoIds);
}
