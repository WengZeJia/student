<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>教师入班</title>
    <%@ include file="/common/include/common.jsp" %>
    <script type="text/javascript">
	$(function () {
		var getGradeListUrl = "${ctx}/grade/getAll.action";
	    window['g'] =
	    $("#maingrid").ligerGrid({
	        height: '100%',
	        inWindow: true,
	        checkbox: true,
	    	isSingleCheck: true,
	        allowAdjustColWidth: false,
	        url: getGradeListUrl,
	        columns: [
	        { display: '班级名称', name: 'name', minWidth: 100 },
	        { display: '学生数量', name: 'studentCount', minWidth: 100 }
	        ], pageSize:10 ,rownumbers:true
	        })
	});
	</script>
</head>
<body style="overflow:hidden; padding:2px;">
	<div id="maingrid"></div>
</body>
</html>
