package com.wzj.ssm.service;

import com.wzj.ssm.entity.SysUser;

public interface SysUserService extends BaseService<SysUser>  {

	/**
	 * 通过账号查询系统用户信息，并将关联的角色集合查询出来，赋值给roleSet属性
	 * @param account
	 * @return
	 */
	public SysUser getSysUserJoinRoleByAccount(String account);
}
