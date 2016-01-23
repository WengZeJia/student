package com.wzj.ssm.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Table(name = "t_sys_user")
public class SysUser extends BaseModel implements UserDetails {
	@Id
    private Integer sysUserId;

    private String sysAccount;

    private String sysPassword;

    private String fullName;

    private String gender;

    private String phone;

    private String email;

    private Boolean isAccountNonEpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentialsNonExpired;

    private Boolean isEnabled;

    private String description;
    
    
    //spring security要求实现userDetails接口的类需要返回一个GrantedAuthority列表
    @Transient
    private Set<SysRole> sysRoleSet;

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getSysAccount() {
        return sysAccount;
    }

    public void setSysAccount(String sysAccount) {
        this.sysAccount = sysAccount == null ? null : sysAccount.trim();
    }

    public String getSysPassword() {
        return sysPassword;
    }

    public void setSysPassword(String sysPassword) {
        this.sysPassword = sysPassword == null ? null : sysPassword.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getIsAccountNonEpired() {
        return isAccountNonEpired;
    }

    public void setIsAccountNonEpired(Boolean isAccountNonEpired) {
        this.isAccountNonEpired = isAccountNonEpired;
    }

    public Boolean getIsAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public Boolean getIsCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setIsCredentialsNonExpired(Boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.sysRoleSet;
	}

	
	public String getPassword() {
		return this.sysPassword;
	}

	
	public String getUsername() {
		return this.sysAccount;
	}

	
	public boolean isAccountNonExpired() {
		return this.isAccountNonEpired;
	}

	
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	
	public boolean isEnabled() {
		return this.isEnabled();
	}

	public Set<SysRole> getSysRoleSet() {
		return sysRoleSet;
	}

	public void setSysRoleSet(Set<SysRole> sysRoleSet) {
		this.sysRoleSet = sysRoleSet;
	}
	
}