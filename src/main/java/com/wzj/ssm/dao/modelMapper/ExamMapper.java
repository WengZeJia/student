package com.wzj.ssm.dao.modelMapper;

import java.util.List;

import com.wzj.ssm.dao.BaseMapper;
import com.wzj.ssm.entity.Exam;

public interface ExamMapper extends BaseMapper<Exam> {

	public void deleteList(List<Integer> idsList);

}
