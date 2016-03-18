<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>学生入班</title>
    <%@ include file="/common/include/common.jsp" %>
    <script type="text/javascript">
	

	 
	$(function () {
		//从父窗口页面获取选中的数组，然后用ligerCheckBoxList加载数据
	    var parentDialog = frameElement.dialog;
        var parentDialogData = parentDialog.get('data');//获取data参数
        if(parentDialogData.length > 0) {
        	$("#checkedStudent").ligerCheckBoxList({
        		rowSize: 6,
                data: parentDialogData,
                name: "studentInfoId",
                valueField: "studentInfoId",
                textField: 'name'
            });
        }
        $(":checkbox","#checkedStudent").attr("checked", true);
        
		var getGradeListUrl = "${ctx}/grade/getAll.action";
	    window['g'] =
	    $("#maingrid").ligerGrid({
	        height: '80%',
	        inWindow: true,
	        checkbox: true,
	    	isSingleCheck: true,
	        allowAdjustColWidth: false,
	        url: getGradeListUrl,
	        columns: [
	        { display: '班级名称', name: 'name', minWidth: 100 },
	        { display: '学生数量', name: 'studentCount', minWidth: 100 }
	        ], pageSize:10 ,rownumbers:true
	        });
	        
	        $("#btn").ligerButton(
            {
                click: function ()
                {
                    alert('111');
                }
            });

	});
	</script>
</head>
<body style="overflow:hidden; padding:2px;">
    <h4>入班学生：</h4><div id="checkedStudent"></div>
	<div id="maingrid"></div>
	<div id="btn" style="margin-top: 10px;"></div>
</body>
</html>
