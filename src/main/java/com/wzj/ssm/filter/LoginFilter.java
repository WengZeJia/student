package com.wzj.ssm.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wzj.ssm.entity.TeacherInfo;


public class LoginFilter implements Filter {

	public void destroy() {
		
	}

	private String[] urls_signin_no;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;  
		HttpServletResponse res = (HttpServletResponse) response; 
		res.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession(true);  // 
		TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("last_teacherInfo");

		boolean flag = urlValidate(req,urls_signin_no);
		if (flag) {
//			log.debug("不需要屏蔽的URL");
			chain.doFilter(request, response);
		} else {
			if (teacherInfo == null) { 
				PrintWriter out = res.getWriter();
				String redirectURL = req.getRequestURL().toString().substring(0, req.getRequestURL().toString().lastIndexOf(":")+5);
				redirectURL = redirectURL + req.getContextPath()+"/login.jsp";
	            out.write("<script>window.parent.location.href='"+redirectURL+"';</script>");
//				req.getRequestDispatcher("/login.jsp").forward(req,res);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig config) throws ServletException {
		urls_signin_no = new StringBuffer()
		.append("/console/login.action,")
		.append("/console/loginOut.action").toString()
		.split(",", -1);
	}

	public boolean urlValidate(HttpServletRequest request, String[] urls) {
		//return false;
		String url = request.getServletPath().substring(1);
		int index = indexOfArray(urls, url);
		if (index > -1) {//验证请求
			//验证参数
			List<String[]> sArrList = getParameterMapFromURL(urls[index]);
			for (String[] sArr : sArrList) {
				if (!request.getParameter(sArr[0]).equals(sArr[1])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * 说明：在arr中查找str  模糊查询，不要求精确匹配
	 *
	 * @param arr
	 * @param str
	 * @return
	 */
	public int indexOfArray(String[] arr, String str) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].indexOf(str) > -1) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * 说明：从url中获取参数列表
	 *
	 * @param url
	 * @return
	 */
	public List<String[]> getParameterMapFromURL(String url) {
		url = url.replace("?", "&");
		List<String[]> l = new ArrayList<String[]>();
		while (url.lastIndexOf("&") > -1) {
			String name = url.substring(url.lastIndexOf("&") + 1, url.lastIndexOf("="));
			String value = url.substring(url.lastIndexOf("=") + 1);
			String[] s = new String[2];
			s[0] = name;
			s[1] = value;
			l.add(s);
			url = url.substring(0, url.lastIndexOf("&"));
		}
		return l;
	}
	
}
