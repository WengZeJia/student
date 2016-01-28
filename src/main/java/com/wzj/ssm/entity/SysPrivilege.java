package com.wzj.ssm.entity;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.access.ConfigAttribute;

@Table(name = "t_sys_privilege")
public class SysPrivilege extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sysPrivilegeId;

    private String privilegeName;

    private String privilegeAlias;

    private String description;
    
    @Transient
    private Collection<ConfigAttribute> roleSet;//spring security在控制权限的时候是通过角色是否包含来比较的，所以权限表这里需要加入一个roleSet集合，查询数据库之后的权限后赋值于此，供决策管理器去判断

    public Integer getSysPrivilegeId() {
        return sysPrivilegeId;
    }

    public void setSysPrivilegeId(Integer sysPrivilegeId) {
        this.sysPrivilegeId = sysPrivilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    public String getPrivilegeAlias() {
        return privilegeAlias;
    }

    public void setPrivilegeAlias(String privilegeAlias) {
        this.privilegeAlias = privilegeAlias == null ? null : privilegeAlias.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Collection<ConfigAttribute> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Collection<ConfigAttribute> roleSet) {
		this.roleSet = roleSet;
	}

    
}