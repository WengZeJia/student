package com.wzj.ssm.service;

import com.wzj.ssm.entity.Grade;

public interface GradeService extends BaseService<Grade> {

	public void saveGrade(Grade grade);

	public Grade getGradeJoinYearById(Integer gradeId);
}
