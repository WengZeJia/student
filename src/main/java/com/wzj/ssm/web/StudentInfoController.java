package com.wzj.ssm.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.entity.ResultMessage;
import com.wzj.ssm.entity.StudentInfo;
import com.wzj.ssm.util.StringUtil;

/**
 * 
 * 实现如下功能: 1: 支持 session application 对象的存储 2: 返回 json格式, 解决乱码问题 3:
 * 采用拦截器,完成用户登陆的过滤
 * 
 */
@RequestMapping("/studentInfo")
@Controller
// 开启注解扫描机制
public class StudentInfoController extends BaseController {

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
//		List<StudentInfo> studentList = studentInfoService.selectAll();
		List<StudentInfo> studentList = studentInfoService.getListJoinGrade();
		int total = studentList.size();
		map.put("Rows", studentList);
		map.put("Total", total);
		return map;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Object save(StudentInfo studentInfo) {
		String resultMsg = null;
		ResultMessage resultMessage = new ResultMessage();
		Integer studentInfoId = studentInfo.getStudentInfoId();
		if (studentInfoId == null || studentInfoId == 0) {
			resultMsg = "添加数据成功";
		} else {
			resultMsg = "更新数据成功";
		}
		studentInfoService.saveStudentInfo(studentInfo);
		resultMessage.addMessage(resultMsg).addMessage("studentInfoId", studentInfo.getStudentInfoId());
		return resultMessage.getReturnMap();
	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mv = null;
		try {
			String studentInfoIdStr = request.getParameter("studentInfoId");
			String isReadOnly = request.getParameter("isReadOnly");
			Integer studentInfoId = StringUtil.parseIntIsNullGetDef(studentInfoIdStr, 0);
//			StudentInfo studentInfoDB = studentInfoService.selectByPrimaryKey(studentInfoId);
			StudentInfo studentInfoDB = studentInfoService.getStudentJoinGradeById(studentInfoId);
			mv = getAutoView().addObject("studentInfo", studentInfoDB).addObject("isReadOnly", isReadOnly);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return mv;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Object delete() {
		String resultMsg = null;
		ResultMessage resultMessage = new ResultMessage();
		String ids = request.getParameter("studentInfoIds");
		if(ids != null && ids.trim().length() > 0) {
			String[] ids_str = ids.split(",");
			Integer[] ids_int=new Integer[ids_str.length];
			for(int i=0; i < ids_str.length; i++){
				ids_int[i]=Integer.parseInt(ids_str[i]);
			}
			List<Integer> idsList = Arrays.asList(ids_int);
			this.studentInfoService.deleteList(idsList);
			resultMsg = "删除数据成功";
			resultMessage.addMessage(resultMsg);
			return resultMessage.getReturnMap();
		}
		resultMsg = "删除数据失败";
		resultMessage.addMessage(resultMsg);
		return resultMessage.getReturnMap();
	}
	
	@RequestMapping("/intoGrade")
	public ModelAndView intoGrade() {
		try {
			return this.getAutoView();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping("/getGradeList")
	@ResponseBody
	public Object getGradeList() {
		return gradeService.selectAll();
	}
	
	
	@RequestMapping("/importExcel")
	public ModelAndView importExcel() {
		try {
			return this.getAutoView();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
