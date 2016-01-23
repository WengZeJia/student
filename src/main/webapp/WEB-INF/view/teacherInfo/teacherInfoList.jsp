<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <%@ include file="/common/include/common.jsp" %>
    <script type="text/javascript">
        function addClick() {
        	window.location.href = "edit.action";
        }
        function modifyClick() {
        	window.location.href = "edit.action";
        }
        function deleteClick() {
        	window.location.href = "edit.action";
        }
        $(function () {
        	var getTeacherListUrl = "${ctx}/teacherInfo/getAll.action";
            window['g'] =
            $("#maingrid").ligerGrid({
            	checkbox: true,
                height:'auto',
                url: getTeacherListUrl,
                columns: [
                { display: '工号', name: 'number', width: 100, minWidth: 30 },
                { display: '姓名', name: 'name', minWidth: 120 },
                { display: '性别', name: 'gender', minWidth: 140 },
                { display: '科目', formatter:function(){
                	
                } }
                ], pageSize:30 ,rownumbers:true,
                toolbar: { items: [
                { text: '增加', click: addClick, icon: 'add' },
                { line: true },
                { text: '修改', click: modifyClick, icon: 'modify' },
                { line: true },
                { text: '删除', click: deleteClick, icon: 'delete'/* img: '../../../lib/ligerUI/skins/icons/delete.gif' */ }
                ]
                }
            });
             

            $("#pageloading").hide();
        });

        function deleteRow()
        {
            g.deleteSelectedRow();
        }

    </script>
</head>
<body style="overflow-x:hidden; padding:2px;">
<div class="l-loading" style="display:block" id="pageloading"></div>
 <a class="l-button" style="width:120px;float:left; margin-left:10px; display:none;" onclick="deleteRow()">删除选择的行</a>

 
 <div class="l-clear"></div>

    <div id="maingrid"></div>
   
  <div style="display:none;">
  
</div>
 
</body>
</html>
