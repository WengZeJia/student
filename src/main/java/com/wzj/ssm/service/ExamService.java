package com.wzj.ssm.service;

import java.util.List;

import com.wzj.ssm.entity.Exam;

public interface ExamService extends BaseService<Exam>  {

	public void deleteList(List<Integer> idsList);
}
