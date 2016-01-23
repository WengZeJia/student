package com.wzj.ssm.dao.modelMapper;

import java.util.List;

import com.wzj.ssm.dao.BaseMapper;
import com.wzj.ssm.entity.SysRole;

public interface SysRoleMapper extends BaseMapper<SysRole> {
	/**
	 * 根据用户ID查询角色集合
	 * @param userId
	 * @return
	 */
	public List<SysRole> selectListByUserId(Integer userId);
	
	/**
	 * 根据权限ID查询角色集合
	 * @param privilegeId
	 * @return
	 */
	public List<SysRole> selectListByPrivilegeId(Integer privilegeId);
}
