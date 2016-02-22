package com.wzj.ssm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.entity.ResultMessage;
import com.wzj.ssm.entity.Year;
import com.wzj.ssm.util.StringUtil;

/**
 * 
 * 实现如下功能: 1: 支持 session application 对象的存储 2: 返回 json格式, 解决乱码问题 3:
 * 采用拦截器,完成用户登陆的过滤
 * 
 */
@RequestMapping("/year")
@Controller
// 开启注解扫描机制
public class YearController extends BaseController {

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
		List<Year> yearList = yearService.selectAll();
		int total = yearList.size();
		map.put("Rows", yearList);
		map.put("Total", total);
		return map;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Object save(Year year) {
		String resultMsg = null;
		ResultMessage resultMessage = new ResultMessage();
		Integer yearId = year.getYearId();
		if (yearId == null || yearId == 0) {
			resultMsg = "添加数据成功";
			yearService.insertSelective(year);
		} else {
			resultMsg = "更新数据成功";
			yearService.updateByPrimaryKeySelective(year);
		}
		resultMessage.addMessage(resultMsg).addMessage("yearId", year.getYearId());
		return resultMessage.getReturnMap();
	}

	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mv = null;
		try {
			String yearIdStr = request.getParameter("yearId");
			String isReadOnly = request.getParameter("isReadOnly");
			Integer yearId = StringUtil.parseIntIsNullGetDef(yearIdStr, 0);
			Year yearDB = yearService.selectByPrimaryKey(yearId);
			mv = getAutoView().addObject("year", yearDB).addObject("isReadOnly", isReadOnly);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return mv;
	}
	
}
