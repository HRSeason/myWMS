<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单栏页面</title>
<script src="js/jquery-latest.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/stylepc.css">
</head>
<body>
<div class="container" width="300" height="1200">
	<div class="menu">
		<div class="userManager">
			<div>
				<h2><i class="q-menu-img positionIicon"></i>用户管理</h2>
			</div>
			<div>
				<h3><i class="q-menu-three positionIicon"></i>新增用户信息</h3>
				<ul class="ulmenu1">
					<li><a class="selected" href="addUser.jsp" target="mainContant">新增用户信息</a></li>
				</ul>
				<h3><i class="q-menu-three positionIicon"></i>修改信息</h3>
				<ul class="ulmenu1">
					<li><a class="selected" href="updateUser.jsp" target="mainContant">修改基本信息</a></li>
					<li><a href="updatePassword.jsp" target="mainContant">修改个人密码</a></li>
				</ul>
				<h3><i class="q-menu-three positionIicon"></i>查询用户信息</h3>
				<ul class="ulmenu1">
					<li><a class="selected" href="queryUser.jsp" target="mainContant" }>查询用户信息</a></li>
				</ul>
				<h3><i class="q-menu-three positionIicon"></i>注销用户信息</h3>
				<ul class="ulmenu1">
					<li><a class="selected" href="updateUser.jsp" target="mainContant">注销用户信息</a></li>
				</ul>
			</div>
		</div>
		<div class="goodManager">
			<div>
				<h2><i class="q-menu-img positionIicon"></i>货物管理</h2>
			</div>
			<div>
				<h3><i class="q-menu-three positionIicon"></i>销售/采购管理</h3>
				<ul class="ulmenu1">
					<li><a class="selected" href="addOrder.jsp" target="mainContant">新增销售/退货/采购订单</a></li>
					<li><a href="queryOrder.jsp" target="mainContant">查询销售/退货/采购订单</a></li>
				</ul>

				<h3><i class="q-menu-three positionIicon"></i>仓库管理</h3>
				<ul class="ulmenu2">
					<li><a class="selected" href="addWareHouse.jsp" target="mainContant">新增仓库信息</a></li>
					<li><a href="addGoods.jsp" target="mainContant">新增货物信息</a></li>
					<li><a href="queryGoods.jsp" target="mainContant">查询货物信息</a></li>
					<li><a href="queryWareHouse.jsp" target="mainContant">查询仓库订单信息</a></li>
					<li><a href="inventory.jsp" target="mainContant">盘点货物信息</a></li>
				</ul>

				<h3><i class="q-menu-three positionIicon"></i>异常管理</h3>
				<ul class="ulmenu3">
					<li><a class="selected" href="addExceptionInfo.jsp" target="mainContant">新增异常情况</a></li>
					<li><a href="queryExceptionInfo.jsp" target="mainContant">查询异常情况</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/pc.js"></script>
</body>
</html>