<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>教师管理系统登录</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/images/login.js"></script>
<link href="${pageContext.request.contextPath }/css/login2.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	
	/* function doLogin() {
		$.ajax({
		   type: "POST",
		   url: $("#loginForm").attr("action"),
		   data: $("#loginForm").serializeArray(),
		   success: function(msg){
			   if(msg != null && msg.isLogin == true) {
				   window.location.href = "${pageContext.request.contextPath }/console/main.action"
			   } else {
				   alert("工号或密码错误，请重新登陆!");
				   window.location.reload();
			   }
		   }
		});
	} */
</script>


</head>
<body>
<h1>教师管理系统登录<sup>2016</sup></h1>

	<div class="login" style="margin-top: 50px;">
		<div class="header">
			<div style="line-height: 45px;height: 45px;font-size: 18px;text-align: center;">
				教师登录
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">

			<!--登录-->
			<div class="web_login" id="web_login">


				<div class="login-box">


					<div class="login_form">
						<form id="loginForm" action="${pageContext.request.contextPath }/login.action"
							accept-charset="utf-8" id="login_form" class="loginForm"
							method="post">
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">工号：</label>
								<div class="inputOuter" id="uArea">

									<input type="text" id="u" name="number" value="1" class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="p" name="password" value="admin@123456"
										class="inputstyle" />
								</div>
							</div>

							<div style="padding-left: 50px; margin-top: 20px;">
								<input type="submit" value="登 录" style="width: 150px;"
									class="button_blue" />
							</div>
						</form>
					</div>
				</div>

			</div>
			<!--登录end-->
		</div>

	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>