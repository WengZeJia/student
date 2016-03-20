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
        		window.location.href = "edit.action?gradeId="+rows[0].gradeId;
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
        		var gradeIds = "";
        		for(var i = 0; i < rows.length; i++) {
        			if(i == 0) {
        				gradeIds += rows[i].gradeId
        			} else {
        				gradeIds += "," + rows[i].gradeId
        			}
        		}
        		var url = "delete.action?gradeIds=" + gradeIds;
        		$.ajax({
        			   type: "GET",
        			   url: url,
        			   dataType: "json",
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
        		window.location.href = "edit.action?gradeId="+rows[0].gradeId + "&isReadOnly=" + true;
        	}
        }
        
        function callClick() {
        	var rows = $("#maingrid").ligerGetGridManager().getSelectedRows();
        	if (rows == null || rows.length != 1) { 
        		var tip = $.ligerDialog.tip({  title: '提示信息',content:'请选择一行',isDrag:false }); 
        		setTimeout(function() {
        			tip.close();
        		},2000);
        		return ;
        	} else {
        		var gradeIds = "";
        		for(var i = 0; i < rows.length; i++) {
        			if(i == 0) {
        				gradeIds += rows[i].gradeId
        			} else {
        				gradeIds += "," + rows[i].gradeId
        			}
        		}
        		var askBool = window.confirm("现在是要点名"+rows[0].gradeName+"的小盆友吗？");
				if (askBool) {
					var url = "call.action?gradeId="+rows[0].gradeId;
	        		window.open(url); 
				}
        	}
        }
        
        $(function () {
        	var getTeacherListUrl = "${ctx}/grade/getAll.action";
            window['g'] =
            $("#maingrid").ligerGrid({
            	checkbox: true,
                height:'auto',
                isScroll:false,
                allowAdjustColWidth:false,
                url: getTeacherListUrl,
                columns: [
                { display: '班级名称', name: 'gradeName', minWidth: 100 },
                { display: '年级', name: 'year.yearName', minWidth: 100 },
                { display: '学生数量', name: 'studentCount', minWidth: 100 }
                ], pageSize:30 ,rownumbers:true,
                toolbar: { items: [
                { text: '添加', click: addClick, icon: 'add' },
                { line: true },
                { text: '编辑', click: modifyClick, icon: 'modify' },
                { line: true },
                { text: '删除', click: deleteClick, icon: 'delete' },
                { line: true },
                { text: '查看', click: viewClick, icon: 'view' },
                { line: true },
                { text: '点名', click: callClick, icon: 'memeber' }
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
<body style="overflow:hidden; padding:2px;">
<div class="l-loading" style="display:block" id="pageloading"></div>

    <div id="maingrid"></div>
   
  <div style="display:none;">
  
</div>
 
</body>
</html>
