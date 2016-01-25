package com.wzj.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wzj.ssm.util.ContextUtil;


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
