<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/jquery-easyui-1.5.3/themes/icon.css"
	rel="stylesheet">
<link
	href="${APP_PATH }/static/jquery-easyui-1.5.3/themes/default/easyui.css"
	rel="stylesheet">
	
<script type="text/javascript"
	src="${APP_PATH }/static/jquery-easyui-1.5.3/jquery.min.js"></script>
<script
	src="${APP_PATH }/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script
	src="${APP_PATH }/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理系统</title>
</head>
<body class="easyui-layout">	
		<div data-options="region:'north'" style="height: 50px">权限管理系统--欢迎${loginUser.userName }</div>
		<!-- <div data-options="region:'south',split:true" style="height: 50px;">skywhite权限管理系统</div> -->
		<!-- <div data-options="region:'east',split:true" title="右"
			style="width: 100px;">
			隐藏不要
		</div> -->
		
		<div data-options="region:'west',split:true" title="菜单"
			style="width: 150px;">
			<ul id="menu_tree"></ul>			
		</div>
		<div
			data-options="region:'center'">
			<div class="easyui-tabs" fit="true" border="false" id="tabs">
				<div title="首页">
					<div align="center" style="padding-top: 100px;">
						<font color="red" size="8">欢迎使用权限管理系统（java版本）</font>
					</div>
					<div align="center">
						<font color="red" size="8">请使用IE9,谷歌，火狐，不支持IE低版本</font>
					</div>
					<div align="center">
						<font color="red" size="6">版权所有skywhite，侵权必究
						</font>
					</div>
				</div>
			</div>

		</div>
</body>
<script src="${APP_PATH }/static/js/Index.js"></script>
</html>