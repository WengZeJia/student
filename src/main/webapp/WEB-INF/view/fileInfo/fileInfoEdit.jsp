<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>导入文件表编辑</title>
<%@ include file="/common/include/common.jsp"%>

<script type="text/javascript">
	$(function() {
		var isReadOnly = "${requestScope.isReadOnly}";
		if(isReadOnly != null && $.trim(isReadOnly).length > 0 && Boolean(isReadOnly)) {
			$(":input").attr("disabled", true);
		}
		
		$("#dataFormSave",$("div .panel-toolbar")).click(function() {
			$("#saveForm").ajaxSubmit({
				   type: "POST",
				   url: $("#saveForm").attr("action"),
				   dataType: "json",
				   success: function(msg) {
					   if(msg != null && msg.returnMsg != null) {
						   alert(msg.returnMsg);
						   window.location.href = "edit.action?fileInfoId=" + msg.fileInfoId;
					   }
				   }
				});
				//$("#saveForm").submit();
		})
	})
</script>
</head>
<body>

	<div class="panel">
		<div class="panel-top">
			<div class="tbar-title">
				<c:choose>
					<c:when test="${fileInfo.fileInfoId != null}">
						<span class="tbar-label"><span></span>编辑导入文件表</span>
					</c:when>
					<c:otherwise>
						<span class="tbar-label"><span></span>添加导入文件表</span>
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
		<form id="saveForm" action="save.action" method="post" enctype="multipart/form-data" >
			<table class="table-detail" cellpadding="0" cellspacing="0"
				border="0" type="main">
				<tr>
					<th width="20%">文件:<span class="required"
						style="color: red;">*</span></th>
					<td width="30%"><input type="file" style="width: 63%"  name="file" accept="application/vnd.ms-excel"/></td>
					<th width="20%">文件别名:<span class="required"
						style="color: red;">*</span></th>
					<td width="30%"><input type="text" style="width: 93%"  name="fileAliasName" value="${fileInfo.fileAliasName }" /></td>
				</tr>
				<tr>
					<th width="20%">导入类型:<span class="required"
						style="color: red;">*</span></th>
					<td>
						<input type="text" id="fileTypeBox" />
						<input type="hidden" id="fileType" name="fileType" value="${fileInfo.fileType }" />
					</td>
					<th width="20%"></th>
					<td></td>
				</tr>
				<tr>
					<th width="20%">导入说明:</th>
					<td colspan="3"><textarea rows="8" cols="5" style="width: 84%"
							name="description">${fileInfo.description }</textarea></td>
				</tr>
				<tr>
					<th width="20%">创建人:</th>
					<td><input type="hidden" name="createby" value="${fileInfo.createby }"/><f:teacherName teacherInfoId="${fileInfo.createby }" /></td>
					<th width="20%">创建时间:</th>
					<td><input type="hidden" name="createtime" value="<fmt:formatDate type='date' dateStyle='medium' value='${fileInfo.createtime }' />"/><fmt:formatDate type="date" dateStyle="medium" value="${year.createtime }" /></td>
				</tr>
				<tr>
					<th width="20%">更新人:</th>
					<td><f:teacherName teacherInfoId="${fileInfo.updateby }" /></td>
					<th width="20%">更新时间:</th>
					<td><fmt:formatDate type="date" dateStyle="medium" value="${fileInfo.updatetime }" /></td>
				</tr>
			</table>
			<input type="hidden" name="yearId" value="${fileInfo.yearId }"/>
		</form>
	</div>
</body>
</html>
