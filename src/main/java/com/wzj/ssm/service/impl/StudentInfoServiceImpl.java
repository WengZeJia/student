package com.wzj.ssm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wzj.ssm.entity.StudentInfo;
import com.wzj.ssm.service.StudentInfoService;

@Service("studentInfoService")
public class StudentInfoServiceImpl extends BaseServiceImpl<StudentInfo> implements StudentInfoService {

	public void deleteList(List<Integer> idsList) {
		this.studentInfoMapper.deleteList(idsList);
	}

	public List<StudentInfo> getStudentsByGradeId(Integer gradeId) {
		return this.studentInfoMapper.getStudentsByGradeId(gradeId);
	}

	public List<StudentInfo> getListJoinGrade() {
		return this.studentInfoMapper.getListJoinGrade();
	}

	public StudentInfo getStudentJoinGradeById(Integer studentInfoId) {
		return this.studentInfoMapper.getStudentJoinGradeById(studentInfoId);
	}

	public void saveStudentInfo(StudentInfo studentInfo) {
		if(studentInfo != null) {
			if(studentInfo.getStudentInfoId() == null) {
				this.studentInfoMapper.saveStudentInfoSelective(studentInfo);
			} else {
				this.studentInfoMapper.updateStudentInfo(studentInfo);
			}
		}
	}
}
