package com.wzj.ssm.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wzj.ssm.entity.TeacherInfo;

public interface TeacherInfoService extends BaseService<TeacherInfo> {

	
	public TeacherInfo login(TeacherInfo teacherInfo);

	public UserDetails loadUserByUsername(String paramString) throws UsernameNotFoundException;

	public TeacherInfo getTeacherByNumber(String paramString);
}
