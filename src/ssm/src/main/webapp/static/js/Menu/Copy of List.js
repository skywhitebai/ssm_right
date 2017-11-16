$(document).ready(function() {
	// 初始化加载数据
	bindData();
});

$('#btn_search').click(function() {
	bindData()
});

function bindData() {
	dg =  '#dg';;
	url = "listtree";
	title = "菜单管理";
	$(dg).treegrid({ // 定位到Table标签，Table标签的ID是grid
		url : url, // 指向后台的Action来获取当前菜单的信息的Json格式的数据
		title : title,
		idField : 'menuId',
		treeField : 'menuName',
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
		} ] ]
	})
}