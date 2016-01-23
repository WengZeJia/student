package com.wzj.ssm.service;

import com.wzj.ssm.entity.SysUrl;

public interface SysUrlService extends BaseService<SysUrl>  {

	/**
	 * 根据url地址查询SysUrl对象，并将关联的角色集合查询出来，赋值给roleSet属性
	 * @param url
	 * @return
	 */
	public SysUrl getSysUrlJoinRoleByUrl(String url);
}
