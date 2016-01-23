package com.wzj.ssm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wzj.ssm.entity.SysRole;
import com.wzj.ssm.entity.SysUser;
import com.wzj.ssm.service.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService, UserDetailsService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.getSysUserJoinRoleByAccount(username);
	}
	
	public SysUser getSysUserJoinRoleByAccount(String account) {
		SysUser sysUser = new SysUser();
		sysUser.setSysAccount(account);
		SysUser sysUserDB = this.sysUserMapper.selectOne(sysUser);
		if(sysUserDB != null) { //若改账号的系统用户不为空，则根据用户ID查询用户拥有的角色集合
			List<SysRole> roleList = sysRoleMapper.selectListByUserId(sysUserDB.getSysUserId());
			if(roleList != null && roleList.size() > 0) {
				Set<SysRole> roleSet = new HashSet<SysRole>();
				roleSet.addAll(roleList);
				sysUserDB.setSysRoleSet(roleSet);
			}
		}
		return sysUserDB;
	}
}
