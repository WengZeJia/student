package com.wzj.ssm.service;

import java.util.List;

import com.wzj.ssm.entity.StudentInfo;

public interface StudentInfoService extends BaseService<StudentInfo>  {

	public void deleteList(List<Integer> idsList);

	public List<StudentInfo> getStudentsByGradeId(Integer gradeId);

	public List<StudentInfo> getListJoinGrade();

	public StudentInfo getStudentJoinGradeById(Integer studentInfoId);

	public void saveStudentInfo(StudentInfo studentInfo);
}
