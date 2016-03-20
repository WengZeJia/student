package com.wzj.ssm.dao.modelMapper;

import java.util.List;

import com.wzj.ssm.dao.BaseMapper;
import com.wzj.ssm.entity.Grade;

public interface GradeMapper extends BaseMapper<Grade> {
	
	public void saveGradeSelective(Grade grade);

	public void updateGradeSelective(Grade grade);

	public Grade getGradeJoinYearById(Integer gradeId);

	public List<Grade> getListJoinYear();

}
