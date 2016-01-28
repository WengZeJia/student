package com.wzj.ssm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;
@Table(name = "t_sys_role")
public class SysRole extends BaseModel implements GrantedAuthority, ConfigAttribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sysRoleId;

    private String roleName;

    private String roleAlias;

    private String description;

    public Integer getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleAlias() {
        return roleAlias;
    }

    public void setRoleAlias(String roleAlias) {
        this.roleAlias = roleAlias == null ? null : roleAlias.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public String getAuthority() {
		return this.getRoleAlias();
	}

	public String getAttribute() {
		return this.getRoleAlias();
	}
}