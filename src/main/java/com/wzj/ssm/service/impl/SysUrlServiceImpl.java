package com.wzj.ssm.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.wzj.ssm.entity.SysPrivilege;
import com.wzj.ssm.entity.SysRole;
import com.wzj.ssm.entity.SysUrl;
import com.wzj.ssm.service.SysUrlService;

@Service("sysUrlService")
public class SysUrlServiceImpl extends BaseServiceImpl<SysUrl>
		implements SysUrlService, FilterInvocationSecurityMetadataSource {

	
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 获取当前的URL地址
		System.out.println("object的类型为:" + object.getClass());
		FilterInvocation filterInvocation = (FilterInvocation) object;
		String url = filterInvocation.getRequestUrl();
		System.out.println("访问的URL地址为(包括参数):" + url);
		url = filterInvocation.getRequest().getServletPath();
		System.out.println("访问的URL地址为:" + url);
		SysUrl urlObject = getSysUrlJoinRoleByUrl(url);
		System.out.println("urlObject:" + urlObject);
		
		if (urlObject != null && urlObject.getSysPrivilege() != null) {
			return urlObject.getSysPrivilege().getRoleSet();
		} else {
			// 如果返回为null则说明此url地址不需要相应的角色就可以访问, 这样Security会放行
			return null;
		}
	}

	public SysUrl getSysUrlJoinRoleByUrl(String url) {
		SysUrl sysUrl = this.sysUrlMapper.selectOneJoinPrivilegeByUrl(url);
		if (sysUrl != null) {
			SysPrivilege sysPrivilege = sysUrl.getSysPrivilege();
			if (sysPrivilege != null) {
				List<SysRole> roleList = sysRoleMapper.selectListByPrivilegeId(sysPrivilege.getSysPrivilegeId());
				if (roleList != null && roleList.size() > 0) {
					Collection<ConfigAttribute> roleSet = new HashSet<ConfigAttribute>();
					roleSet.addAll(roleList);
					sysUrl.getSysPrivilege().setRoleSet(roleSet);
				}
			}
		}
		return sysUrl;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
