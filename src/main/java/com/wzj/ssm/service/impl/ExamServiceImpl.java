package com.wzj.ssm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wzj.ssm.entity.Exam;
import com.wzj.ssm.service.ExamService;

@Service("examService")
public class ExamServiceImpl extends BaseServiceImpl<Exam> implements ExamService  {

	public void deleteList(List<Integer> idsList) {
		this.examMapper.deleteList(idsList);
	}
}
