package com.wzj.ssm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.entity.Grade;
import com.wzj.ssm.entity.ResultMessage;
import com.wzj.ssm.entity.StudentInfo;
import com.wzj.ssm.util.StringUtil;

/**
 * 
 * 实现如下功能: 1: 支持 session application 对象的存储 2: 返回 json格式, 解决乱码问题 3:
 * 采用拦截器,完成用户登陆的过滤
 * 
 */
@RequestMapping("/grade")
@Controller
// 开启注解扫描机制
public class GradeController extends BaseController {

	@RequestMapping("/list")
	public ModelAndView list() {
		try {
			return this.getAutoView();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping("/getAll")
	@ResponseBody
	public Object getList() {
		Map<String, Object> map = new HashMap<String, Object>();
//		List<Grade> gradeList = gradeService.selectAll();
		List<Grade> gradeList = gradeService.getListJoinYear();
		int total = gradeList.size();
		map.put("Rows", gradeList);
		map.put("Total", total);
		return map;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Object save(Grade grade) {
		String resultMsg = null;
		ResultMessage resultMessage = new ResultMessage();
		Integer gradeId = grade.getGradeId();
		if (gradeId == null || gradeId == 0) {
			resultMsg = "添加数据成功";
		} else {
			resultMsg = "更新数据成功";
		}
		gradeService.saveGrade(grade);
		resultMessage.addMessage(resultMsg).addMessage("gradeId", grade.getGradeId());
		return resultMessage.getReturnMap();
	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mv = null;
		try {
			String gradeIdStr = request.getParameter("gradeId");
			String isReadOnly = request.getParameter("isReadOnly");
			Integer gradeId = StringUtil.parseIntIsNullGetDef(gradeIdStr, 0);
			Grade gradeDB = gradeService.getGradeJoinYearById(gradeId);
			mv = getAutoView().addObject("grade", gradeDB).addObject("isReadOnly", isReadOnly);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return mv;
	}
	
	@RequestMapping("/call")
	public ModelAndView call() {
		try {
			String gradeIdStr = request.getParameter("gradeId");
			Integer gradeId = StringUtil.parseIntIsNullGetDef(gradeIdStr, 0);
			List<StudentInfo> studentList = studentInfoService.getStudentsByGradeId(gradeId);
			return this.getAutoView().addObject("studentList", studentList);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping("/getYearList")
	@ResponseBody
	public Object getYearList() {
		return yearService.selectAll();
	}
}
