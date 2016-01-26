package com.wzj.ssm.dao.modelMapper;

import java.util.List;

import com.wzj.ssm.dao.BaseMapper;
import com.wzj.ssm.entity.StudentInfo;

public interface StudentInfoMapper extends BaseMapper<StudentInfo> {

	public void deleteList(List<Integer> idsList);

}
