package com.wzj.ssm.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_sys_url")
public class SysUrl extends BaseModel {
	@Id
    private Integer sysUrlId;

    private String url;

    @Transient
    private SysPrivilege sysPrivilege;

    private String description;

    public Integer getSysUrlId() {
        return sysUrlId;
    }

    public void setSysUrlId(Integer sysUrlId) {
        this.sysUrlId = sysUrlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public SysPrivilege getSysPrivilege() {
		return sysPrivilege;
	}

	public void setSysPrivilege(SysPrivilege sysPrivilege) {
		this.sysPrivilege = sysPrivilege;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}