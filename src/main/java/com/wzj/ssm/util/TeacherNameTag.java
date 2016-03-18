package com.wzj.ssm.util;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.wzj.ssm.entity.TeacherInfo;
import com.wzj.ssm.service.TeacherInfoService;

public class TeacherNameTag extends BodyTagSupport {


	private static final long serialVersionUID = 1L;
	private Integer teacherInfoId = 0;
	private Boolean isDefaultUser = Boolean.valueOf(false);

	public int doStartTag() throws JspTagException {
		return 2;
	}

	public int doEndTag() throws JspTagException {
		try {
			String str = getTeacherName();
			this.pageContext.getOut().print(str);
		} catch (Exception e) {
			throw new JspTagException(e.getMessage());
		}
		return 0;
	}

	private String getTeacherName() {
		String noData = "暂无";
		String teacherName = null;
		if (this.isDefaultUser.booleanValue()) {
			TeacherInfo teacherInfo = ContextUtil.getCurrentTeacher();
			if (teacherInfo != null) {
				noData = teacherInfo.getTeacherName();
			}
		}
		if (this.teacherInfoId.intValue() != 0) {
			TeacherInfoService teacherInfoService = (TeacherInfoService) AppUtil.getBean("teacherInfoService");
			TeacherInfo teacherInfo = (TeacherInfo) teacherInfoService.selectByPrimaryKey(this.teacherInfoId);
			if (teacherInfo == null) {
				return noData;
			}
			teacherName = teacherInfo.getTeacherName();
			if (StringUtils.isEmpty(teacherInfo.getTeacherName())) {
				teacherName = teacherInfo.getNumber();
			}
		}
		return StringUtil.isEmpty(teacherName) ? noData : teacherName;
	}


	public void setTeacherInfoId(Integer teacherInfoId) {
		this.teacherInfoId = teacherInfoId;
	}
	
	public void setIsDefaultUser(Boolean isDefaultUser) {
		this.isDefaultUser = isDefaultUser;
	}

}
