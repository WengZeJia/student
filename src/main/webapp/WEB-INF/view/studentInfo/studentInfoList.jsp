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
        		window.location.href = "edit.action?studentInfoId="+rows[0].studentInfoId;
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
        		var studentInfoIds = "";
        		for(var i = 0; i < rows.length; i++) {
        			if(i == 0) {
        				studentInfoIds += rows[i].studentInfoId
        			} else {
        				studentInfoIds += "," + rows[i].studentInfoId
        			}
        		}
        		var url = "delete.action?studentInfoIds=" + studentInfoIds;
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
        		window.location.href = "edit.action?studentInfoId="+rows[0].studentInfoId + "&isReadOnly=" + true;
        	}
        }
        
        function intoGradeClick() {
        	var rows = $("#maingrid").ligerGetGridManager().getSelectedRows();
        	if (rows == null || rows.length == 0) { 
        		var tip = $.ligerDialog.tip({  title: '提示信息',content:'请选择至少一行',isDrag:false }); 
        		setTimeout(function() {
        			tip.close();
        		},2000);
        		return ;
        	} else {
        		var studentInfoIds = "";
        		for(var i = 0; i < rows.length; i++) {
        			if(i == 0) {
        				studentInfoIds += rows[i].studentInfoId
        			} else {
        				studentInfoIds += "," + rows[i].studentInfoId
        			}
        		}
        		
        		var url = "intoGrade.action";
        		$.ligerDialog.open({
                    height: 300,
                    width: 600,
                    title: '学生入班',
                    data: rows,
                    url: url, 
                    isDrag: false,
                    showMax: false,
                    showToggle: false,
                    showMin: false,
                    isResize: false,
                    slide: false, 
                });

        	}
        }
        
        $(function () {
        	var getStudentListUrl = "${ctx}/studentInfo/getAll.action";
            window['g'] =
            $("#maingrid").ligerGrid({
            	checkbox: true,
                height:'auto',
                isScroll:false,
                allowAdjustColWidth:false,
                url: getStudentListUrl,
                columns: [
                { display: '学号', name: 'number' },
                { display: '姓名', name: 'studentName'},
                { display: '性别', name: 'gender', render:function(rowdata, index, value) {
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
                { display: '班级', name: 'grade.gradeName' }
                ], pageSize:30 ,rownumbers:true,
                toolbar: { items: [
                { text: '增加', click: addClick, icon: 'add' },
                { line: true },
                { text: '编辑', click: modifyClick, icon: 'modify' },
                { line: true },
                { text: '删除', click: deleteClick, icon: 'delete' },
                { line: true },
                { text: '查看', click: viewClick, icon: 'view' },
                { line: true },
                { text: '入班', click: intoGradeClick, icon: 'role' }
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
