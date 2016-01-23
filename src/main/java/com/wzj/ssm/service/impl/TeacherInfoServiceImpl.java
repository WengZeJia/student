package com.wzj.ssm.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wzj.ssm.entity.TeacherInfo;
import com.wzj.ssm.service.TeacherInfoService;

@Service("teacherInfoService")
public class TeacherInfoServiceImpl extends BaseServiceImpl<TeacherInfo> implements TeacherInfoService,UserDetailsService {

	
	public TeacherInfo login(TeacherInfo teacherInfo) {
		return this.selectOne(teacherInfo);
	}

	public UserDetails loadUserByUsername(String paramString) throws UsernameNotFoundException {
		TeacherInfo teacherInfo = getTeacherByNumber(paramString);
		if(teacherInfo == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		return teacherInfo;
	}

	public TeacherInfo getTeacherByNumber(String number) {
		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setNumber(number);
		return this.teacherInfoMapper.selectOne(teacherInfo);
	}
}
