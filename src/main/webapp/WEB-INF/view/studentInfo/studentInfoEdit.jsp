<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>教师信息表编辑</title>
<%@ include file="/common/include/common.jsp"%>

<script type="text/javascript">
	$(function() {
		var isReadOnly = "${requestScope.isReadOnly}";
		if(isReadOnly != null && $.trim(isReadOnly).length > 0 && Boolean(isReadOnly)) {
			$(":input").attr("disabled", true);
		}
		
		$("#dataFormSave",$("div .panel-toolbar")).click(function() {
			$.ajax({
				   type: "POST",
				   url: $("#saveForm").attr("action"),
				   data: $("#saveForm").serializeArray(),
				   success: function(msg){
					   if(msg != null && msg.returnMsg != null) {
						   alert(msg.returnMsg);
					   }
				   }
				});
		})
	})
</script>
</head>
<body>

	<div class="panel">
		<div class="panel-top">
			<div class="tbar-title">
				<c:choose>
					<c:when test="${studentInfo.studentInfoId != null}">
						<span class="tbar-label"><span></span>编辑教师主信息表</span>
					</c:when>
					<c:otherwise>
						<span class="tbar-label"><span></span>添加教师主信息表</span>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="panel-toolbar">
				<div class="toolBar">
					<div class="group">
						<a class="link save" id="dataFormSave" href="javascript:void(0);"><span></span>保存</a>
					</div>
					<div class="l-bar-separator"></div>
					<div class="group">
						<a class="link back" href="list.action"><span></span>返回</a>
					</div>
				</div>
			</div>
		</div>
		<form id="saveForm" action="save.action" method="post" >
			<table class="table-detail" cellpadding="0" cellspacing="0"
				border="0" type="main">
				<tr>
					<th width="20%">学号:<span class="required"
						style="color: red;">*</span></th>
					<td><input type="text" style="width: 93%" name="number"
						value="${studentInfo.number }" /></td>
					<th width="20%">姓名:</th>
					<td><input type="text" style="width: 93%" name="name"
						value="${studentInfo.name }" /></td>
				</tr>
				<tr>
					<th width="20%">性别:</th>
					<td><input type="radio" name="gender" value="m" ${studentInfo.gender=='m'?'checked':null } /> 男
						<input type="radio" name="gender" value="w" ${studentInfo.gender=='w'?'checked':null } /> 女
					</td>
					<th width="20%">年龄:</th>
					<td><input type="text" style="width: 93%" name="age"
						value="${studentInfo.age }" /></td>
				</tr>
				<tr>
					<th width="20%">电话:</th>
					<td><input type="text" style="width: 93%" name="phone"
						value="${studentInfo.phone }" /></td>
					<th width="20%">邮箱:</th>
					<td><input type="text" style="width: 93%" name="email"
						value="${studentInfo.email }" /></td>
				</tr>
				<tr>
					<th width="20%">备注:</th>
					<td colspan="3"><textarea rows="8" cols="5" style="width: 84%"
							name="description">${studentInfo.description }</textarea></td>
				</tr>
				<tr>
					<th width="20%">创建人:</th>
					<td><input type="hidden" name="createby" value="${studentInfo.createby }"/><f:teacherName teacherInfoId="${studentInfo.createby }" /></td>
					<th width="20%">创建时间:</th>
					<td><input type="hidden" name="createtime" value="<fmt:formatDate type='date' dateStyle='medium' value='${studentInfo.createtime }' />"/><fmt:formatDate type="date" dateStyle="medium" value="${studentInfo.createtime }" /></td>
				</tr>
				<tr>
					<th width="20%">更新人:</th>
					<td><f:teacherName teacherInfoId="${studentInfo.updateby }" /></td>
					<th width="20%">更新时间:</th>
					<td><fmt:formatDate type="date" dateStyle="medium" value="${studentInfo.updatetime }" /></td>
				</tr>
			</table>
			<input type="hidden" name="studentInfoId" value="${studentInfo.studentInfoId }"/>
		</form>
</body>
</html>
