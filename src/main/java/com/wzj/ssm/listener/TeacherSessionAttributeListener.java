package com.wzj.ssm.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wzj.ssm.entity.TeacherInfo;

public class TeacherSessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		if (event.getName().equals("SPRING_SECURITY_CONTEXT")) {
			SecurityContext context = SecurityContextHolder.getContext();
			TeacherInfo login_teacherInfo = (TeacherInfo) context.getAuthentication().getPrincipal();
			event.getSession().setAttribute("login_teacherInfo", login_teacherInfo);
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		if (event.getName().equals("SPRING_SECURITY_CONTEXT")) {
			event.getSession().removeAttribute("login_teacherInfo");
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		if (event.getName().equals("SPRING_SECURITY_CONTEXT")) {
			SecurityContext context = SecurityContextHolder.getContext();
			TeacherInfo login_teacherInfo = (TeacherInfo) context.getAuthentication().getPrincipal();
			event.getSession().setAttribute("login_teacherInfo", login_teacherInfo);
		}
	}

}
