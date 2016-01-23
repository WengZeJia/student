package com.wzj.ssm.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "t_school")
public class School extends BaseModel {
	@Id
    private Integer schoolId;

    private String name;

    private String schoolType;

    private String description;

    public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType == null ? null : schoolType.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}