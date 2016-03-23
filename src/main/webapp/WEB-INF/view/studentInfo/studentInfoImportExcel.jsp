<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>导入excel</title>
    <%-- <%@ include file="/common/include/common.jsp" %> --%>
    <script src="${ctx}/common/ligerui_lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script> 
    <script src="${ctx}/common/webuploader/webuploader.js" type="text/javascript"></script>
	<link href="${ctx}/common/webuploader/webuploader.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	.letCenter {position:absolute; left:50%; top:50%;margin-left: -80px;margin-top:-40px; } 
	</style>
    <script type="text/javascript">
		$(function() {
			var uploader = WebUploader.create({
			    // swf文件路径
			    swf: '${ctx}/common/webuploader/Uploader.swf',

			    // 文件接收服务端。
			    server: 'http://webuploader.duapp.com/server/fileupload.php',

			    // 选择文件的按钮。可选。
			    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
			    pick: '#picker',

			    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
			    resize: false
			});
		})
	 
	</script>
</head>
<body style="overflow:hidden;padding: 0">
	<div id="uploader" class="wu-example letCenter">
	    <!--用来存放文件信息-->
	    <div id="thelist" class="uploader-list"></div>
	    <div class="btns">
	        <div id="picker">点击选择选择文件</div>
	    </div>
	</div>
</body>
</html>
