package com.wzj.ssm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wzj.ssm.entity.SysRole;
import com.wzj.ssm.entity.TeacherInfo;
import com.wzj.ssm.service.TeacherInfoService;

@Service("teacherInfoService")
public class TeacherInfoServiceImpl extends BaseServiceImpl<TeacherInfo> implements TeacherInfoService,UserDetailsService {

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.getTeacherJoinRoleByNumber(username);
	}
	
	public TeacherInfo getTeacherJoinRoleByNumber(String number) {
		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setNumber(number);
		TeacherInfo teacherInfoDB = this.teacherInfoMapper.selectOne(teacherInfo);
		if(teacherInfoDB != null) { //若改账号的系统用户不为空，则根据用户ID查询用户拥有的角色集合
			List<SysRole> roleList = sysRoleMapper.selectListByUserId(teacherInfoDB.getTeacherInfoId());
			if(roleList != null && roleList.size() > 0) {
				Set<SysRole> roleSet = new HashSet<SysRole>();
				roleSet.addAll(roleList);
				teacherInfoDB.setSysRoleSet(roleSet);
			}
		}
		return teacherInfoDB;
	}
}
