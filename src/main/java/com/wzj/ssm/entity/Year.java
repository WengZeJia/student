package com.wzj.ssm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "t_year")
public class Year extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer yearId;

    private String name;

    private String description;
    

	public Integer getYearId() {
		return yearId;
	}

	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}