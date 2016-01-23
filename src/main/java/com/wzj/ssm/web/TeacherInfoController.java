package com.wzj.ssm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.entity.TeacherInfo;
import com.wzj.ssm.util.ContextUtil;
import com.wzj.ssm.util.StringUtil;

/**
 * 
 * 实现如下功能: 1: 支持 session application 对象的存储 2: 返回 json格式, 解决乱码问题 3:
 * 采用拦截器,完成用户登陆的过滤
 * 
 */
@RequestMapping("/teacherInfo")
@Controller
// 开启注解扫描机制
public class TeacherInfoController extends BaseController {

	@RequestMapping("/list")
	public ModelAndView list() {
		try {
			System.out.println("TeacherInfoController.list()");
			System.out.println(ContextUtil.getCurrentTeacherId());
			return this.getAutoView();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@RequestMapping("/getAll")
	@ResponseBody
	public Object getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TeacherInfo> teacherList = teacherInfoService.selectAll();
		int total = teacherList.size();
		map.put("Rows", teacherList);
		map.put("Total", total);
		return map;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Object save(TeacherInfo teacherInfo) {
		String resultMsg = null;
		if (teacherInfo.getTeacherInfoId() == null || teacherInfo.getTeacherInfoId() == 0) {
			resultMsg = "添加数据成功";
		} else {
			resultMsg = "更新数据成功";
		}
		teacherInfoService.insert(teacherInfo);
		return resultMsg;

	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mv = null;
		try {
			String teacherInfoIdStr = request.getParameter("teacherInfoId");
			Integer teacherInfoId = StringUtil.parseIntIsNullGetDef(teacherInfoIdStr, 0);
			TeacherInfo teacherInfoDB = teacherInfoService.selectByPrimaryKey(teacherInfoId);
			mv = getAutoView().addObject("teacherInfo", teacherInfoDB);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return mv;
	}
}
