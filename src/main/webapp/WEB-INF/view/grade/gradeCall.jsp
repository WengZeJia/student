<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级点名</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath}/css/gradeCall.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
var namelist=[
"蔡俊潮","陈铱静","陈泳诗","孙九","赵十","刘一"];
var mytime=null;

function doit(){
	var bt=window.document.getElementById("bt");
	if(mytime==null){
		bt.innerHTML="停止点名";
		show();                    
	}else{
		bt.innerHTML="开始点名";
		clearTimeout(mytime);
		mytime=null;                    
	}
}

function show(){
	var box=window.document.getElementById("box");
	var num=Math.floor((Math.random()*100000))%namelist.length;
	box.innerHTML=namelist[num];
	mytime=setTimeout("show()",100);
} 
</script>
</head>
<body id="bodybj">

<div id="box">亲，准备好点名了吗？</div>
<div id="bt" onClick="doit()">开始点名</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>