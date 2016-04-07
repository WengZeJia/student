<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>班级表编辑</title>
<%@ include file="/common/include/common.jsp"%>

<script type="text/javascript">
	$(function() {
		var isReadOnly = "${requestScope.isReadOnly}";
		if (isReadOnly != null && $.trim(isReadOnly).length > 0
				&& Boolean(isReadOnly)) {
			$(":input").attr("disabled", true);
		}

		$("#dataFormSave", $("div .panel-toolbar")).click(
				function() {
					console.info($("#saveForm").serializeArray());
					$.ajax({
						type : "POST",
						url : $("#saveForm").attr("action"),
						data : $("#saveForm").serializeArray(),
						dataType : "json",
						success : function(msg) {
							if (msg != null && msg.returnMsg != null) {
								alert(msg.returnMsg);
								window.location.href = "edit.action?gradeId="
										+ msg.gradeId;
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
			hideOnLoseFocus : false,
			onSelected : function(id, name) {
				$("#yearId").val(id);
			}
		});
		var manager = $("#yearBox").ligerComboBox({});
		manager.selectValue($('#yearId').val());

	})
</script>
</head>
<body>

	<div class="panel">
		<div class="panel-top">
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
		
		<input type="file" name="" />
	</div>
</body>
</html>
