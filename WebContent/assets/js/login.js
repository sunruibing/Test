function login(){
	//获取参数
	var phone = $.trim($("#phone").val());
	var password = $.trim($("#password").val());
		if(phone && password ==""){
			$.ajax({
				url : 'http://localhost:8080/admin/adminLogin',
				data : {'phone': phone,'password': password},
				dataType : 'json',
				success : function(data) {
					if (data.msg == "") {
						alert("用户名或密码错误");
					}else{
						
						$.cookies.set("phone", phone);
				    	$.cookies.set("password", password);
				    	window.location.href = "index.html";
					}
				},
				error : function() {
					alert("系统错误");
				}
			});
	}
}