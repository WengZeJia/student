package com.wzj.ssm.service.impl;

import org.springframework.stereotype.Service;

import com.wzj.ssm.entity.Grade;
import com.wzj.ssm.service.GradeService;

@Service("gradeService")
public class GradeServiceImpl extends BaseServiceImpl<Grade> implements GradeService {

	public void saveGrade(Grade grade) {
		if(grade != null) {
			if(grade.getGradeId() == null) {
				this.gradeMapper.saveGradeSelective(grade);
			} else {
				this.gradeMapper.updateGradeSelective(grade);
			}
		}
	}

	public Grade getGradeJoinYearById(Integer gradeId) {
		return this.gradeMapper.getGradeJoinYearById(gradeId);
	}
}
