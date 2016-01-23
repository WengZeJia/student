package com.wzj.ssm.dao.modelMapper;

import com.wzj.ssm.dao.BaseMapper;
import com.wzj.ssm.entity.SysUrl;

public interface SysUrlMapper extends BaseMapper<SysUrl> {

	/**
	 * 根据url地址查询SysUrl对象，并将关联的权限对象查询出来
	 * @param url
	 * @return
	 */
	public SysUrl selectOneJoinPrivilegeByUrl(String url);
}
