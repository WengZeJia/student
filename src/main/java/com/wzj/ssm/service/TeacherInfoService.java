package com.wzj.ssm.service;

import com.wzj.ssm.entity.TeacherInfo;

public interface TeacherInfoService extends BaseService<TeacherInfo> {

	public TeacherInfo getTeacherJoinRoleByNumber(String number);
}
