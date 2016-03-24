package com.wzj.ssm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

public class FileInfo extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileInfoId;

    private String fileName;

    private String fileAliasName;

    private Integer fileType;

    private String filePath;

    @Transient
    private TeacherInfo teacherInfo;

    private String description;

    public Integer getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(Integer fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileAliasName() {
        return fileAliasName;
    }

    public void setFileAliasName(String fileAliasName) {
        this.fileAliasName = fileAliasName == null ? null : fileAliasName.trim();
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public TeacherInfo getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}