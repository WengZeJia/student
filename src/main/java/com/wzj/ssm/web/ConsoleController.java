package com.wzj.ssm.web;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.entity.TeacherInfo;
import com.wzj.ssm.util.ContextUtil;
import com.wzj.ssm.util.MD5;


/**
 * 
 * 实现如下功能: 1: 支持 session application 对象的存储 2: 返回 json格式, 解决乱码问题 3:
 * 采用拦截器,完成用户登陆的过滤
 * 
 */
@RequestMapping("/console")
@Controller
// 开启注解扫描机制
public class ConsoleController extends BaseController {
	
	@RequestMapping("loginRedirect")
	public ModelAndView loginRedirect(){
		return new ModelAndView("redirect:/login");
	}
	

	@RequestMapping("/login")
	@ResponseBody
	public Object login(TeacherInfo teacherInfo) {
		HashMap<String, Object> returnMap = null;
		if(teacherInfo != null) {
			String password = teacherInfo.getPassword();
			if(password != null && password.trim().length() > 0) {
				teacherInfo.setPassword(MD5.GetMD5Code(password));
			}
			TeacherInfo teacherDB = teacherInfoService.login(teacherInfo);
			if (teacherDB != null) {
				returnMap = new HashMap<String,Object>();
				session.setAttribute("last_teacherInfo", teacherDB);
				returnMap.put("isLogin", true);
			}
			
			ContextUtil.cleanCurTeacher();
			ContextUtil.setCurrentTeacher(teacherDB);
			System.out.println("ConsoleController.login()");
			System.out.println(ContextUtil.getCurrentTeacherId());
		}
		return returnMap;
	}

	@RequestMapping("/main")
	public ModelAndView main() {
		try {
			System.out.println("ConsoleController.main()");
			System.out.println(ContextUtil.getCurrentTeacherId());
			return new ModelAndView("/console/main");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
