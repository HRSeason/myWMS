$(function(){
	//当id是useLoad的按钮点击后从服务器端发送数据
	$("#useLoad").click(function(){
		$("#useLoad").load("AjaxServlet?action=useLoad", 
				"userInfo=" + $("#userInfo").val(),
				//回调函数
				function(response, status, xhr){
					//xhr相当于XMLHttpRequest对象
					alert("服务器返回的数据是：" + xhr.responseText);
				});
	});
	
	//当id是usePost的按钮点击后返回从服务器端发送的数据
	$("#usePost").click(function(){
		$.post("AjaxServlet?action=usePost", {"userInfo":$("#userInfo").val()}, 
				function(data){
					alert(data);
				});
	});
	
	//当id是showUsers的按钮点击后根据用户提交的数据请求符合要求的用户
	$("#showUsers").click(function(){
		//获取用户提交的用户Id
		var userId = $("#userId").val();
		//获取用户提交的用户名
		var userName = $("#userName").val();
		//获取用户提交的部门
		var department = $("#department").val();
		//获取用户提交的职位
		var job = $("#job").val();
		
		
		//使用jQuery提交AJAX请求
		$.post("UserServlet?action=queryUser", 
				{"userId":userId, "userName":userName,
				"department":department, "job":job},
				function(data){
					alert(data);
					//先将字符串类型的JSON数组变为真正的JSON数组（使用eval方法）
					//使用jQuery的each方法遍历JSON数组
				});
	});
});