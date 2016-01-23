package com.wzj.ssm.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Table(name = "t_mark")
public class Mark extends BaseModel {
	@Id
    private Long markId;

	@Transient
    private StudentInfo studentInfo;
	@Transient
    private Exam exam;

    private String examName;
    @Transient
    private Subject subject;

    private String subjectName;
    @Transient
    private Grade graded;

    private String gradeName;

    private Byte isAbsent;

    private Double score;

    public Long getMarkId() {
		return markId;
	}

	public void setMarkId(Long markId) {
		this.markId = markId;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public Grade getGraded() {
		return graded;
	}

	public void setGraded(Grade graded) {
		this.graded = graded;
	}

	public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public Byte getIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(Byte isAbsent) {
        this.isAbsent = isAbsent;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}