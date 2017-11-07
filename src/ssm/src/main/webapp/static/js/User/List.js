$(document).ready(function() {
	// 初始化加载数据
	
});

$('#btn_search').click(function () { bindData() });

function bindData() {
    dg = '#dg';
    url = "GetUserList";
    title = "用户管理";
    userName = $('#userName').val();
    realName= $('#realName').val();
    queryParams = {userName:userName,realName: realName };
    $(dg).datagrid({   //定位到Table标签，Table标签的ID是grid  
        url: url,   //指向后台的Action来获取当前菜单的信息的Json格式的数据  
        title: title,
        iconCls: 'icon-view',
        nowrap: true,
        autoRowHeight: false,
        striped: true,
        collapsible: true,
        pagination: true,
        //singleSelect:true, 
        pageSize: 10,
        pageList: [10,15, 20,30, 50],
        rownumbers: true,
        //sortName: 'ID',    //根据某个字段给easyUI排序  
        //sortOrder: 'asc',
        remoteSort: false,
        idField: 'userID',
        queryParams: queryParams,  //异步查询的参数  
        columns: [[
            { field: 'ck', checkbox: true },   //选择  
             { title: '用户名称', field: 'userName', width: 200 },
             { title: '用户姓名', field: 'realName', width: 200 },
             { title: '性别', field: 'sex', width: 200,
            	 formatter : function(value, row, index) {
					if (value==1) {
						return '男';
					} else if (value==2){
						return '女';
					}
				} 
             },
             { title: 'email', field: 'email', width: 200 },
             { title: '手机', field: 'moblie', width: 200 },
             { title: '微信', field: 'wechat', width: 200 },
             { title: 'qq', field: 'qq', width: 200 },
             { title: '备注', field: 'remark', width: 200 },
             { title: '是否删除', field: 'deleted', width: 200 ,
            	 formatter : function(value, row, index) {
 					if (value==1) {
 						return '已删除';
 					} else {
 						return '正常';
 					}
 				} 
             },
             { title: '最后登录时间', field: 'lastLoginTime', width: 200 },
             { title: '创建时间', field: 'CreateTime', width: 180 },
             { title: '修改时间', field: 'UpdateTime', width: 180 },
             { title: '备注', field: 'Remark', width: 300 }
        ]],
        toolbar: [{
            id: 'btnAdd',
            text: '添加',
            iconCls: 'icon-add',
            handler: function () {
                ShowAddDialog_Area();//实现添加记录的页面  
            }
        }, '-', {
            id: 'btnEdit',
            text: '修改',
            iconCls: 'icon-edit',
            handler: function () {
                ShowEditDialog_Area();//实现修改记录的方法  
            }
        }, '-', {
            id: 'btnDelete',
            text: '删除',
            iconCls: 'icon-remove',
            handler: function () {
                Delete_Area();//实现直接删除数据的方法  
            }
        }, '-', {
            id: 'btnView',
            text: '查看',
            iconCls: 'icon-search',
            handler: function () {
                ShowViewDialog_Area();//实现查看记录详细信息的方法  
            }
        }, '-', {
            id: 'btnReload',
            text: '刷新',
            iconCls: 'icon-reload',
            handler: function () {
                //实现刷新栏目中的数据  
                $(dg).datagrid("reload");
            }
        }],
        onDblClickRow: function (rowIndex, rowData) {
            $(dg).datagrid('uncheckAll');
            $(dg).datagrid('checkRow', rowIndex);
            ShowViewDialog_Area();
        }
    })
}