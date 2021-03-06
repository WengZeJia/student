package com.wzj.ssm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Table(name = "t_grade")
public class Grade extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;

    private String gradeName;

    private Integer studentCount;
    
    @Transient
    private Year year;//所属年级
    
    @Transient
    private School school;
    
    private String description;

    public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

    public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}