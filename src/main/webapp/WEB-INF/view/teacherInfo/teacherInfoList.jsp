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
        	var rows = $("#maingrid").ligerGetGridManager().getSelectedRows();
        	if (rows == null || rows.length == 0 || rows.length > 1) { 
        		var tip = $.ligerDialog.tip({  title: '提示信息',content:'请选择一行',isDrag:false }); 
        		setTimeout(function() {
        			tip.close();
        		},2000);
        		return ;
        	} else {
        		window.location.href = "edit.action?teacherInfoId="+rows[0].teacherInfoId;
        	}
        }
        function deleteClick() {
        	var rows = $("#maingrid").ligerGetGridManager().getSelectedRows();
        	if (rows == null || rows.length == 0) { 
        		var tip = $.ligerDialog.tip({  title: '提示信息',content:'请选择至少一行',isDrag:false }); 
        		setTimeout(function() {
        			tip.close();
        		},2000);
        		return ;
        	} else {
        		var teacherInfoIds = "";
        		for(var i = 0; i < rows.length; i++) {
        			if(i == 0) {
        				teacherInfoIds += rows[i].teacherInfoId
        			} else {
        				teacherInfoIds += "," + rows[i].teacherInfoId
        			}
        		}
        		var url = "delete.action?teacherInfoIds=" + teacherInfoIds;
        		$.ajax({
        			   type: "GET",
        			   url: url,
        			   success: function(msg){
        				   if(msg != null && msg.returnMsg != null) {
        					   alert(msg.returnMsg)
        				   } 
        				   window.location.reload();
        			   }
        		});
        	}
        }
        function viewClick() {
        	var rows = $("#maingrid").ligerGetGridManager().getSelectedRows();
        	if (rows == null || rows.length == 0 || rows.length > 1) { 
        		var tip = $.ligerDialog.tip({  title: '提示信息',content:'请选择一行',isDrag:false}); 
        		setTimeout(function() {
        			tip.close();
        		},2000);
        		return ;
        	} else {
        		window.location.href = "edit.action?teacherInfoId="+rows[0].teacherInfoId + "&isReadOnly=" + true;
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
                { display: '工号', name: 'number'},
                { display: '姓名', name: 'name' },
                { display: '性别', name: 'gender',  render:function(rowdata, index, value) {
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
                { display: '账户是否过期', name: 'isAccountNonExpired', render:function(rowdata, index, value) {
                		return value == 1 ? "否" : "是";
                	}
                },
                { display: '账户是否锁定', name: 'isAccountNonLocked',  render:function(rowdata, index, value) {
                		return value == 1 ? "否" : "是";
                	}
	            },
	            { display: '证书是否有效', name: 'isCredentialsNonExpired',  render:function(rowdata, index, value) {
	            		return value == 1 ? "是" : "否";
		        	}
		        },
                { display: '账号是否可用', name: 'isEnabled',  render:function(rowdata, index, value) {
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
