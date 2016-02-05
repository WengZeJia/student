package com.wzj.ssm.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.entity.Exam;
import com.wzj.ssm.entity.ResultMessage;
import com.wzj.ssm.util.StringUtil;

/**
 * 
 * 实现如下功能: 1: 支持 session application 对象的存储 2: 返回 json格式, 解决乱码问题 3:
 * 采用拦截器,完成用户登陆的过滤
 * 
 */
@RequestMapping("/exam")
@Controller
// 开启注解扫描机制
public class ExamController extends BaseController {

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
		List<Exam> examList = examService.selectAll();
		int total = examList.size();
		map.put("Rows", examList);
		map.put("Total", total);
		return map;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Object save(Exam exam) {
		String resultMsg = null;
		ResultMessage resultMessage = new ResultMessage();
		Integer examId = exam.getExamId();
		if (examId == null || examId == 0) {
			resultMsg = "添加数据成功";
			examService.insertSelective(exam);
		} else {
			resultMsg = "更新数据成功";
			examService.updateByPrimaryKeySelective(exam);
		}
		resultMessage.addMessage(resultMsg).addMessage("examId", exam.getExamId());
		return resultMessage.getReturnMap();
	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mv = null;
		try {
			String examIdStr = request.getParameter("examId");
			String isReadOnly = request.getParameter("isReadOnly");
			Integer examId = StringUtil.parseIntIsNullGetDef(examIdStr, 0);
			Exam examDB = examService.selectByPrimaryKey(examId);
			mv = getAutoView().addObject("exam", examDB).addObject("isReadOnly", isReadOnly);
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
		String ids = request.getParameter("examIds");
		if(ids != null && ids.trim().length() > 0) {
			String[] ids_str = ids.split(",");
			Integer[] ids_int=new Integer[ids_str.length];
			for(int i=0; i < ids_str.length; i++){
				ids_int[i]=Integer.parseInt(ids_str[i]);
			}
			List<Integer> idsList = Arrays.asList(ids_int);
			this.examService.deleteList(idsList);
			resultMsg = "删除数据成功";
			resultMessage.addMessage(resultMsg);
			return resultMessage.getReturnMap();
		}
		resultMsg = "删除数据失败";
		resultMessage.addMessage(resultMsg);
		return resultMessage.getReturnMap();
	}
}
