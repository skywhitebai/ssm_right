$(document).ready(function() {
	// 初始化加载菜单

	getMenuTree();
});

function getMenuTree() {
	$.ajax({
		type : "Post",
		url : "menu/menutree",
		data : {},
		dataType : "json",
		success : function(data) {

			if (data.status == 1) {
				//实例化树菜单
				$("#menu_tree").tree({
					data:eval(data.data),
					lines:true,
					onClick:function(node){
						if(node.attributes){
							openTab(node.text,node.attributes.url);
						}
					}
				});
			} else {
				$.messager.alert('提示', data.message);
			}
		}
	});
}
// 新增Tab
function openTab(text,url){
	if($("#tabs").tabs('exists',text)){
		$("#tabs").tabs('select',text);
	}else{
		var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
		$("#tabs").tabs('add',{
			title:text,
			closable:true,
			content:content
		});
	}
}