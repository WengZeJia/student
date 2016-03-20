<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>班级表编辑</title>
<%@ include file="/common/include/common.jsp"%>

<script type="text/javascript">
	$(function() {
		var isReadOnly = "${requestScope.isReadOnly}";
		if(isReadOnly != null && $.trim(isReadOnly).length > 0 && Boolean(isReadOnly)) {
			$(":input").attr("disabled", true);
		}
		
		$("#dataFormSave",$("div .panel-toolbar")).click(function() {
			console.info($("#saveForm").serializeArray());
			$.ajax({
				   type: "POST",
				   url: $("#saveForm").attr("action"),
				   data: $("#saveForm").serializeArray(),
				   dataType: "json",
				   success: function(msg) {
					   if(msg != null && msg.returnMsg != null) {
						   alert(msg.returnMsg);
						   window.location.href = "edit.action?gradeId=" + msg.gradeId;
					   }
				   }
				});
		});
		
		
	$("#yearBox").ligerComboBox({
			url : 'getYearList.action',
			valueField : 'yearId',
			textField : 'yearName',
			selectBoxWidth : 250,
			width : 250,
			hideOnLoseFocus: false,
			onSelected: function(id, name) {
				$("#yearId").val(id);
			}
		});
		var manager=$("#yearBox").ligerComboBox({});
		manager.selectValue($('#yearId').val()); 

	})
</script>
</head>
<body>

	<div class="panel">
		<div class="panel-top">
			<div class="tbar-title">
				<c:choose>
					<c:when test="${grade.gradeId != null}">
						<span class="tbar-label"><span></span>编辑班级表</span>
					</c:when>
					<c:otherwise>
						<span class="tbar-label"><span></span>添加班级表</span>
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
					<th width="20%">班级名称:<span class="required"
						style="color: red;">*</span></th>
					<td><input type="text" style="width: 93%"  name="gradeName" value="${grade.gradeName }" /></td>
					<th width="20%">学生数量:</th>
					<td><input type="text" style="width: 93%" name="studentCount"
						value="${grade.studentCount }" /></td>
				</tr>
				<tr>
					<th width="20%">所属年级<span class="required"
						style="color: red;">*</span></th>
					<td>
						<input type="text" id="yearBox" />
						<input type="hidden" id="yearId" name="year.yearId" value="${grade.year.yearId }" />
					</td>
					<th width="20%"></th>
					<td></td>
				</tr>
				<tr>
					<th width="20%">备注:</th>
					<td colspan="3"><textarea rows="8" cols="5" style="width: 84%"
							name="description">${grade.description }</textarea></td>
				</tr>
				<tr>
					<th width="20%">创建人:</th>
					<td><input type="hidden" name="createby" value="${grade.createby }"/><f:teacherName teacherInfoId="${grade.createby }" /></td>
					<th width="20%">创建时间:</th>
					<td><input type="hidden" name="createtime" value="<fmt:formatDate type='date' dateStyle='medium' value='${grade.createtime }' />"/><fmt:formatDate type="date" dateStyle="medium" value="${grade.createtime }" /></td>
				</tr>
				<tr>
					<th width="20%">更新人:</th>
					<td><f:teacherName teacherInfoId="${grade.updateby }" /></td>
					<th width="20%">更新时间:</th>
					<td><fmt:formatDate type="date" dateStyle="medium" value="${grade.updatetime }" /></td>
				</tr>
			</table>
			<input type="hidden" name="gradeId" value="${grade.gradeId }"/>
		</form>
</body>
</html>
