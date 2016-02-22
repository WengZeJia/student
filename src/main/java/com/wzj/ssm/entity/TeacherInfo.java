package com.wzj.ssm.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Table(name = "t_teacher_info")
public class TeacherInfo extends BaseModel implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherInfoId;

    private String number;

    private String password;

    private String name;

    private String gender;
    
    private Integer age;

    private String subjectIds;

    private String phone;

    private String email;

    private Boolean isAccountNonExpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentialsNonExpired;

    private Boolean isEnabled;

    private String description;
    
    //spring security要求实现userDetails接口的类需要返回一个GrantedAuthority列表
    @Transient
    private Set<SysRole> sysRoleSet;
    
    @Transient
    private List<Grade> gradeList;

    public Integer getTeacherInfoId() {
        return teacherInfoId;
    }

    public void setTeacherInfoId(Integer teacherInfoId) {
        this.teacherInfoId = teacherInfoId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }
    
    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(String subjectIds) {
        this.subjectIds = subjectIds == null ? null : subjectIds.trim();
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

    public Boolean getIsAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setIsAccountNonExpired(Boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
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

	public String getUsername() {
		return this.number;
	}

	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	public boolean isEnabled() {
		return this.isEnabled;
	}

	public Set<SysRole> getSysRoleSet() {
		return sysRoleSet;
	}

	public void setSysRoleSet(Set<SysRole> sysRoleSet) {
		this.sysRoleSet = sysRoleSet;
	}

	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}
	
}