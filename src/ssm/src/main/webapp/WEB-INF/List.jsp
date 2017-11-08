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
	<div id="dlg" class="easyui-dialog"
		style="width: 600px; height: 280px; padding: 10px 20px"
		data-options="closed:true, resizable:true, modal:true, buttons:'#dlg-buttons', align:'center'">
		
		<div class="ftitle">
			<b>用户管理</b>
			<hr />
			
	<form id="frm" method="post">
			<table>
				<tr style="display: none">
					<td>userId：</td>
					<td><input class="easyui-validatebox textbox" name="userId">
					</td>
				</tr>
				<tr>
					<td>用户名称：</td>
					<td><input class="easyui-textbox" id="frm_userName" name="userName"
						data-options="required:true"></td>
					<td>用户姓名：</td>
					<td><input class="easyui-textbox" id="frm_realName"  name="realName"
						data-options="required:true"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><select class="easyui-combobox" name="sex"
						style="width: 180px;">
							<option value="1">男</option>
							<option value="2">女</option>
					</select></td>
					<td>email：</td>
					<td><input class="easyui-textbox" name="email"></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input class="easyui-textbox" name="moblie"></td>
					<td>微信：</td>
					<td><input class="easyui-textbox" name="wechat"></td>
				</tr>
				<tr>
					<td>QQ：</td>
					<td><input class="easyui-textbox" name="qq"></td>
				</tr>
				<tr id="tr_time">
					<td>创建时间：</td>
					<td><input class="easyui-validatebox textbox"
						readonly="readonly" name="createTime"></td>

					<td>更新时间：</td>
					<td><input class="easyui-validatebox textbox"
						readonly="readonly" name="updateTime"></td>
				</tr>
				<tr>
					<td>备注:</td>
					<td colspan="3"><input class="easyui-textbox" type="text"
						name="remark" style="width: 90%"></td>
				</tr>
			</table>
			<div class="div_btn_manager">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" id="btn_save"
					onclick="Save()">确定</a> <a href="javascript:void(0)"
					class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
					onclick="Close_JdSite()">关闭</a>
			</div>
		</form>
		</div>
		
	</div>
</body>
</html>