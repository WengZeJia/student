﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        	var manager = $("#maingrid").ligerGetGridManager();
        	var row = manager.getSelectedRow();
        	if (!row) { 
        		$.ligerDialog.tip({  title: '提示信息',content:'请选择行',isDrag:false }); 
        	} else {
        		window.location.href = "edit.action?teacherInfoId="+row.teacherInfoId;
        	}
        }
        function deleteClick() {
        	var manager = $("#maingrid").ligerGetGridManager();
        	var row = manager.getSelectedRow();
        	if (!row) { 
        		$.ligerDialog.tip({  title: '提示信息',content:'请选择行',isDrag:false }); 
        	} else {
        		window.location.href = "delete.action?teacherInfoId="+row.teacherInfoId;
        	}
        }
        function viewClick() {
        	var manager = $("#maingrid").ligerGetGridManager();
        	var row = manager.getSelectedRow();
        	if (!row) { 
        		$.ligerDialog.tip({  title: '提示信息',content:'请选择行',isDrag:false }); 
        	} else {
        		window.location.href = "edit.action?teacherInfoId="+row.teacherInfoId + "&isReadOnly=" + true;
        	}
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
                { display: '姓名', name: 'name', minWidth: 100 },
                { display: '性别', name: 'gender', minWidth: 20, render:function(rowdata, index, value) {
	           		if (value != null) {
	           			if(value == "m") {
	           				return "男";
	           			}
	           			if(value == "w") {
	           				return "女";
	           			}
	        		} 
	           		 return null;
	        		}
                },
                { display: '账户是否过期', name: 'isAccountNonExpired', minWidth: 20, render:function(rowdata, index, value) {
                		return value == 1 ? "否" : "是";
                	}
                },
                { display: '账户是否锁定', name: 'isAccountNonLocked', minWidth: 20, render:function(rowdata, index, value) {
                		return value == 1 ? "否" : "是";
                	}
	            },
	            { display: '证书是否有效', name: 'isCredentialsNonExpired', minWidth: 20, render:function(rowdata, index, value) {
	            		return value == 1 ? "是" : "否";
		        	}
		        },
                { display: '账号是否可用', name: 'isEnabled', minWidth: 20, render:function(rowdata, index, value) {
                		return value == 1 ? "是" : "否";
                	}
           	 	}
                ], pageSize:30 ,rownumbers:true,
                toolbar: { items: [
                { text: '增加', click: addClick, icon: 'add' },
                { line: true },
                { text: '编辑', click: modifyClick, icon: 'modify' },
                { line: true },
                { text: '删除', click: deleteClick, icon: 'delete' },
                { line: true },
                { text: '查看', click: viewClick, icon: 'view' }
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
