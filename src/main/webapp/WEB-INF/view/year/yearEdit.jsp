﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>年级表编辑</title>
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
				   dataType: "json",
				   success: function(msg) {
					   if(msg != null && msg.returnMsg != null) {
						   alert(msg.returnMsg);
						   window.location.href = "edit.action?yearId=" + msg.yearId;
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
					<c:when test="${year.yearId != null}">
						<span class="tbar-label"><span></span>编辑年级表</span>
					</c:when>
					<c:otherwise>
						<span class="tbar-label"><span></span>添加年级表</span>
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
					<th width="20%">年级名称:<span class="required"
						style="color: red;">*</span></th>
					<td width="30%"><input type="text" style="width: 93%"  name="yearName" value="${year.yearName }" /></td>
					<th width="20%"></th>
					<td></td>
				</tr>
				<tr>
					<th width="20%">备注:</th>
					<td colspan="3"><textarea rows="8" cols="5" style="width: 84%"
							name="description">${year.description }</textarea></td>
				</tr>
				<tr>
					<th width="20%">创建人:</th>
					<td><input type="hidden" name="createby" value="${year.createby }"/><f:teacherName teacherInfoId="${year.createby }" /></td>
					<th width="20%">创建时间:</th>
					<td><input type="hidden" name="createtime" value="<fmt:formatDate type='date' dateStyle='medium' value='${year.createtime }' />"/><fmt:formatDate type="date" dateStyle="medium" value="${year.createtime }" /></td>
				</tr>
				<tr>
					<th width="20%">更新人:</th>
					<td><f:teacherName teacherInfoId="${year.updateby }" /></td>
					<th width="20%">更新时间:</th>
					<td><fmt:formatDate type="date" dateStyle="medium" value="${year.updatetime }" /></td>
				</tr>
			</table>
			<input type="hidden" name="yearId" value="${year.yearId }"/>
		</form>
	</div>
</body>
</html>
