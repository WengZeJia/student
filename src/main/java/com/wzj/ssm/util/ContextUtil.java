package com.wzj.ssm.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wzj.ssm.entity.TeacherInfo;

public class ContextUtil {

	private static ThreadLocal<TeacherInfo> curTeacher = new ThreadLocal<TeacherInfo>();

	public static TeacherInfo getCurrentTeacher() {
		TeacherInfo teacherInfo = null;
		if (curTeacher.get() != null) {
			teacherInfo = (TeacherInfo) curTeacher.get();
		} else {
			// TODO 在这里需要抛出异常，处理异常，为不浪费时间，现在此处做一个注释
			SecurityContext securityContext = SecurityContextHolder.getContext();
			if (securityContext != null) {
				Authentication auth = securityContext.getAuthentication();
				if (auth != null) {
					Object principal = auth.getPrincipal();
					if (principal instanceof TeacherInfo) {
						teacherInfo = (TeacherInfo) principal;
					}
				}
			}
		}
		return teacherInfo;
	}

	public static TeacherInfo getCurrentTeacher(HttpServletRequest request) {
		TeacherInfo teacher = null;
		if (curTeacher.get() != null) {
			teacher = (TeacherInfo) curTeacher.get();
		} else {
			teacher = (TeacherInfo) request.getSession().getAttribute("last_teacherInfo");
		}
		return teacher;
	}

	public static Integer getCurrentTeacherId() {
		TeacherInfo curTeacher = getCurrentTeacher();
		if (curTeacher != null) {
			return curTeacher.getTeacherInfoId();
		}
		return 0;
	}

	public static void setCurrentTeacher(TeacherInfo teacherInfo) {
		curTeacher.set(teacherInfo);
	}

	public static void cleanCurTeacher() {
		curTeacher.remove();
	}

}
