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
<title>Insert title here</title>
</head>
<body>
	<!--查询条件-->
	<div class="easyui-panel">
		用户名： <input id="userName" class="easyui-textbox" style="width: 180px;">
		姓名： <input id="userName" class="easyui-textbox" style="width: 180px;">
		<a href="javascript:void(0)" id="btn_search" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" style="width: 80px">查 询</a>
	</div>
	 <!--数据列表-->
    <table id="dg" style="width: 100%; height: auto">
    </table>
    <!--编辑页面-->
    <div id="dlg" class="easyui-dialog" style="width: 600px; height: 280px; padding: 10px 20px"
        data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
    </div>
</body>
</html>