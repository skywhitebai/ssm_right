<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH }/static/jquery-easyui-1.5.3/themes/icon.css"
	rel="stylesheet">
<link
	href="${APP_PATH }/static/jquery-easyui-1.5.3/themes/default/easyui.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script
	src="${APP_PATH }/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<title>登录</title>
<style type="text/css">
.wrap {
	position: fixed;
	top: 50%;
	left: 0;
	width: 100%;
}

.cen {
	position: relative;
	height: 200px;
	top: -100px;
	width: 300px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="cen">
			<div>
				<span>用户名：</span><input type="text" name="userName" id="userName"
					placeholder="用户名">
			</div>
			<div>
				<span>密&nbsp;&nbsp;&nbsp;码：</span><input type="password"
					name="password" id="password" placeholder="密码">
			</div>
			<div style="text-align: center;">
				<input type="button" value="登录" id="btnLogin" />
			</div>
		</div>
	</div>
</body>
<script src="${APP_PATH }/static/js/User/Login.js"></script>
</html>