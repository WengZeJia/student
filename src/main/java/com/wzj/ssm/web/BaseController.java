package com.wzj.ssm.web;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.service.ExamService;
import com.wzj.ssm.service.GradeService;
import com.wzj.ssm.service.MarkService;
import com.wzj.ssm.service.SchoolService;
import com.wzj.ssm.service.StudentInfoService;
import com.wzj.ssm.service.SubjectService;
import com.wzj.ssm.service.TeacherInfoService;
import com.wzj.ssm.service.YearService;
import com.wzj.ssm.util.StringUtil;


@Controller
public class BaseController {

	@Resource
	protected HttpServletRequest request;
	@Resource
	protected HttpServletResponse response;
	@Resource
	protected HttpSession session;
	@Resource
	protected ServletContext application;
	@Resource
	protected ExamService examService;
	@Resource
	protected GradeService gradeService;
	@Resource
	protected MarkService markService;
	@Resource
	protected YearService yearService;
	@Resource
	protected SchoolService schoolService;
	@Resource
	protected StudentInfoService studentInfoService;
	@Resource
	protected SubjectService subjectService;
	@Resource
	protected TeacherInfoService teacherInfoService;
	
	public ModelAndView getAutoView() throws Exception {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		requestURI = requestURI.replace(".action", "");
		int cxtIndex = requestURI.indexOf(contextPath);
		if (cxtIndex != -1) {
			requestURI = requestURI.substring(cxtIndex + contextPath.length());
		}
		String[] paths = requestURI.split("[/]");
		if ((paths != null) && (paths.length == 4)) {
			String jspPath = "/" + paths[1] + "/" + paths[2] + "/" + paths[2] + StringUtil.makeFirstLetterUpperCase(paths[3]);

			return new ModelAndView(jspPath);
		}
		if ((paths != null) && (paths.length == 3)) {
			String jspPath = "/" + paths[1] + "/" + paths[1] + StringUtil.makeFirstLetterUpperCase(paths[2]);

			return new ModelAndView(jspPath);
		}
		throw new Exception("url:[" + requestURI + "] is not in this pattern:[/子系统/表对应实体名/实体操作方法名.action]");
	
	}
	
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}
}
