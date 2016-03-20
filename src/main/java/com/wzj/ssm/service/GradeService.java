package com.wzj.ssm.service;

import java.util.List;

import com.wzj.ssm.entity.Grade;

public interface GradeService extends BaseService<Grade> {

	public void saveGrade(Grade grade);

	public Grade getGradeJoinYearById(Integer gradeId);

	public List<Grade> getListJoinYear();
}
