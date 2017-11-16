$(document).ready(function() {
	// 初始化加载数据
	bindData();
	bindParentId();
});

$('#btn_search').click(function() {
	bindData()
});

function bindData() {
	dg = '#dg';
	url = "menuList";
	title = "菜单管理";
	$(dg).datagrid({ // 定位到Table标签，Table标签的ID是grid
		url : url, // 指向后台的Action来获取当前菜单的信息的Json格式的数据
		title : title,
		iconCls : 'icon-view',
		nowrap : true,
		autoRowHeight : false,
		striped : true,
		collapsible : true,
		pagination : true,
		// singleSelect:true,
		pageSize : 10,
		pageList : [ 10, 15, 20, 30, 50 ],
		rownumbers : true,
		// sortName: 'ID', //根据某个字段给easyUI排序
		// sortOrder: 'asc',
		remoteSort : false,
		columns : [ [ {
			title : '菜单名称',
			field : 'menuName',
			width : 200
		}, {
			title : 'url',
			field : 'url',
			width : 200
		}, {
			title : '排序',
			field : 'orderBy',
			width : 200
		}, {
			title : '创建时间',
			field : 'createTimeStr',
			width : 180
		}, {
			title : '修改时间',
			field : 'updateTimeStr',
			width : 180
		}, {
			title : '备注',
			field : 'remark',
			width : 300
		} ] ],
		toolbar : [ {
			id : 'btnAdd',
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				ShowAddDialog();// 实现添加记录的页面
			}
		}, '-', {
			id : 'btnEdit',
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				ShowEditDialog();// 实现修改记录的方法
			}
		}, '-', {
			id : 'btnDelete',
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				Delete();// 实现直接删除数据的方法
			}
		}, '-', {
			id : 'btnView',
			text : '查看',
			iconCls : 'icon-search',
			handler : function() {
				ShowViewDialog();// 实现查看记录详细信息的方法
			}
		}, '-', {
			id : 'btnReload',
			text : '刷新',
			iconCls : 'icon-reload',
			handler : function() {
				// 实现刷新栏目中的数据
				$(dg).datagrid("reload");
				// $(dg).datagrid('clearSelections');
			}
		} ],
		onDblClickRow : function(rowIndex, rowData) {
			$(dg).datagrid('uncheckAll');
			$(dg).datagrid('checkRow', rowIndex);
			ShowViewDialog();
		}
	})
}

function ShowEditDialog() {
	var rows = $('#dg').datagrid('getSelections');
	if (rows && rows.length == 1) {
		$('#dlg').dialog('open').dialog('setTitle', '修改');
		$('#frm').form('load', rows[0]);
		$(".tr_edit_hide").hide();
		$("#btn_save").show();
	} else {
		$.messager.alert("提示", "请选择一条记录.");
	}
}
function ShowViewDialog() {
	var rows = $('#dg').datagrid('getSelections');
	if (rows && rows.length == 1) {
		$('#dlg').dialog('open').dialog('setTitle', '查看');
		$('#frm').form('load', rows[0]);
		$(".tr_edit_hide").show();
		$("#btn_save").hide();
	} else {
		$.messager.alert("提示", "请选择一条记录.");
	}
}
function ShowAddDialog() {
	$('#dlg').dialog('open').dialog('setTitle', '添加');
	$('#frm').form('clear');
	$(".tr_edit_hide").hide();
	$("#btn_save").show();
}

function Save() {
	var menuName = $("#frm_menuName").val();
	var parentId = $("#frm_parentId").val();
	var orderBy = $("#frm_orderBy").val();
	if (menuName == '') {
		$.messager.alert("提示", '请填写菜单名称');
		return;
	}
	if (parentId == '') {
		$.messager.alert("提示", '请选择父菜单');
		return;
	}
	if (orderBy == '') {
		$.messager.alert("提示", '请填写排序');
		return;
	}
	$('#frm').form('submit', {
		url : 'save',
		onSubmit : function() {
			var validate = $(this).form('validate');
			return validate;
		},
		success : function(data) {
			res = eval('(' + data + ')');
			if (res.status == 1) {
				$('#dlg').dialog('close');
				bindData();
			} else {
				$.messager.alert("提示", res.message);
			}
		}
	});
}
function Close() {
	$('#dlg').dialog('close');
}
function Delete() {
	var rows = $('#dg').datagrid('getSelections');
	if (!rows && rows.length == 0) {
		$.messager.alert("提示", "请选择要删除的数据.");
		return;
	}
	$.messager.confirm('提示', '确认删除这' + rows.length + '条数据吗？', function(r) {
		if (r) {
			var IDS = '';
			for (var i = 0; i < rows.length; i++) {
				IDS += ',' + rows[i].id;
			}
			$.post('delete', {
				IDS : IDS
			}, function(data) {
				if (data.status == 1) {
					$('#dlg').dialog('close');
					bindData();
				} else {
					$.messager.alert("提示", data.message);
				}
			});
		}
	});
}
function bindParentId(){
	 $.post('menucombotree', function (data) {
         var res = eval('(' + data.data + ')');
         $("#frm_parentId").combotree('loadData', res);
     });
}