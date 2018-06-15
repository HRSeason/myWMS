<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<%
	//获取request作用域中对于登录失败的提示信息
	Object errorInfo = request.getAttribute("errorInfo");
%>

<head>
<title>仓鼠管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Baxster Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!--webfonts-->
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
</head>

<body class="login-bg">
	<div class="login-body">
		<div class="login-heading">
			<h1>登陆</h1>
		</div>
		<div class="login-info">
			<form action="UserManagerServlet?action=login" method="post">
				<input type="text" class="user" name="userId" placeholder="输入用户编号"
					required> <input type="password" name="userPass"
					class="lock" placeholder="请输入密码"> <input type="text"
					name="validateCode" id="validateCode" placeholder="请输入验证码">
				<img src="ValidateCodeServlet" id="validateCode"> <input
					type="submit" name="Sign In" value="登陆">
				<hr>
			</form>
		</div>
	</div>
	<div class="error">
	<%=errorInfo == null ? "" : errorInfo%><br>

</div>
</body>

</html>