package com.wzj.ssm.dao.modelMapper;

import java.util.List;

import com.wzj.ssm.dao.BaseMapper;
import com.wzj.ssm.entity.TeacherInfo;

public interface TeacherInfoMapper extends BaseMapper<TeacherInfo> {

	public void deleteList(List<Integer> teacherInfoIds);

}
