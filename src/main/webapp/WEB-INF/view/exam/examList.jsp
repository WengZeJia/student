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
        		window.location.href = "edit.action?examId="+rows[0].examId;
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
        		var examIds = "";
        		for(var i = 0; i < rows.length; i++) {
        			if(i == 0) {
        				examIds += rows[i].examId
        			} else {
        				examIds += "," + rows[i].examId
        			}
        		}
        		var url = "delete.action?examIds=" + examIds;
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
        		window.location.href = "edit.action?examId="+rows[0].examId + "&isReadOnly=" + true;
        	}
        }
        $(function () {
        	var getExamListUrl = "${ctx}/exam/getAll.action";
            window['g'] =
            $("#maingrid").ligerGrid({
            	checkbox: true,
                height:'auto',
                isScroll:false,
                allowAdjustColWidth:false,
                url: getExamListUrl,
                columns: [
                { display: '考试名称', name: 'examName', minWidth: 100 },
                { display: '考试科目', name: 'subject.name', minWidth: 100 }
                ], pageSize:30 ,rownumbers:true,
                toolbar: { items: [
                { text: '发起考试', click: addClick, icon: 'add' },
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
<body style="overflow:hidden; padding:2px;">
<div class="l-loading" style="display:block" id="pageloading"></div>

    <div id="maingrid"></div>
   
  <div style="display:none;">
  
</div>
 
</body>
</html>
