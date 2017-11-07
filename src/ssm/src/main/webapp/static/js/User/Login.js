$("#btnLogin").click(function () {
	var userName= $("#userName").val();
    var password= $("#password").val();
    if (userName == '') {
        $.messager.alert('提示', '用户名不能为空');
        $('#userName').focus();
        return;
    }
    if (password == '') {
        $.messager.alert('提示', '密码不能为空');
        $('#password').focus();
        return;
    }
    $.ajax({
        type: "Post",
        url: "logindo",
        data: { userName: userName, password: password },
        dataType: "json",
        success: function (data) {

            if (data.status == 1) {
                window.location.href = "\index";
            }
            else {
                $.messager.alert('提示', data.message);
            }
        },
        error: function (XmlHttpRequest, textStatus, errorThrown) {
        	 $.messager.alert('提示', "登陆失败");
           // alert(XmlHttpRequest.responseText);
        }
    });
});