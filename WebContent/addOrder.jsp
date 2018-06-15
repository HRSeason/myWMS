<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.myWMS.util.User"%>
<!DOCTYPE HTML>
<html>
<%
	User user = (User) session.getAttribute("user");
%>

<head>
<title>Home</title>
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
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!--webfonts-->
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css"
	media="all">
<script src="js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head>

<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class="sidebar" role="navigation">
			<div class="navbar-collapse">
				<nav
					class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right dev-page-sidebar mCustomScrollbar _mCS_1 mCS-autoHide mCS_no_scrollbar"
					id="cbp-spmenu-s1">
					<div class="scrollbar scrollbar1">
						<ul class="nav" id="side-menu">
							<li><a href="addUser.jsp" class="active"><i
									class="fa fa-home nav_icon"></i>新增用户信息</a></li>
							<li><a href="#"><i class="fa fa-cogs nav_icon"></i>修改信息<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse">
									<li><a href="updateUser.jsp">修改基本信息</a></li>
									<li><a href="updatePassword.jsp">修改个人密码</a></li>
								</ul> <!-- /nav-second-level --></li>
							<li><a href="queryUser.jsp"><i
									class="fa fa-book nav_icon"></i>查询用户信息</a> <!-- /nav-second-level -->
							</li>
							<li><a href="updateUser.jsp"><i
									class="fa fa-th-large nav_icon"></i>注销用户信息</a></li>

							<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i>销售/采购管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse">
									<li><a href="addOrder.jsp">新增销售/退货/采购订单</a></li>
									<li><a href="queryOrder.jsp">查询销售/退货/采购订单</a></li>
								</ul> <!-- //nav-second-level --></li>
							<li><a href="#"><i class="fa fa-envelope nav_icon"></i>仓库管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse">
									<li><a href="addWareHouse.jsp">新增仓库信息</a></li>
									<li><a href="addGoods.jsp">新增货物信息</a></li>
									<li><a href="queryGoods.jsp">查询货物信息</a></li>
									<li><a href="queryWareHouse.jsp">查询仓库订单信息</a></li>
									<li><a href="inventory.jsp">盘点货物信息</a></li>
								</ul> <!-- //nav-second-level --></li>
							<li><a href="#"><i class="fa fa-file-text-o nav_icon"></i>异常管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level collapse">
									<li><a href="addExceptionInfo.jsp">新增异常情况</a></li>
									<li><a href="queryExceptionInfo.jsp">查询异常情况</a></li>
									<li class="hiden"><a href="updateExceptionInfo.jsp">修改异常情况</a></li>
								</ul> <!-- //nav-second-level --></li>
						</ul>
					</div>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--logo -->
				<div class="logo">
					<a href="index.html">
						<ul>
							<li><img src="images/logo1.png" alt="" /></li>
							<li>
								<h1 id="time"></h1>
							</li>
							<div class="clearfix"></div>
						</ul>
					</a>
				</div>
				<div class="clearfix"></div>
			</div>

			<!--//end-search-box-->
			<div class="header-right">

				<!--notification menu end -->
				<div class="profile_details">
					<ul>
						<li class="dropdown profile_details_drop"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false">
								<div class="profile_img">
									<span style="display:inline-block;margin-top:15px">欢迎您，<%=user.getUserName()%></span>
									<div class="clearfix"></div>
								</div>
						</a></li>
					</ul>
				</div>
				<!--toggle button start-->
				<button id="showLeftPush">
					<i class="fa fa-bars"></i>
				</button>
				<!--toggle button end-->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div id="page-wrapper">
			<div class="main-page">
				<!--grids-->
				<div class="grids">
					<div class="progressbar-heading grids-heading">
						<h2>新增销售/退货/采购订单</h2>
					</div>
					<%
						Object errorInfo = request.getAttribute("errorInfo");
					%>
					<%=errorInfo == null ? "" : errorInfo%>
				</div>
				<div class="forms-grids">
					<div class="col-md-6">
						<div class="panel panel-widget">
							<div class="validation-grids widget-shadow"
								data-example-id="basic-forms">
								<div class="form-body form-body-info">
									<form data-toggle="validator" novalidate="true"
										action="OrderManagerServlet?action=addOrder" method="post">
										<div class="form-group">
											订单种类： <select name="orderType" class="form-control"><option
													id="orderType" value="sales">销售订单</option>
												<option id="orderType" value="purchase">采购订单</option>
												<option id="orderType" value="return">退货订单</option>
											</select>
										</div>

										<div class="form-group valid-form">
											商品编号： <input type="text" class="form-control" name="goodId"
												id="goodId" placeholder="请输入商品编号" required="">
										</div>
										<div class="form-group valid-form">
											数量： <input type="number" name="goodNumber" id="goodNumber"
												class="form-control" placeholder="请输入商品数量" min="0"
												required="">
										</div>

										<div class="form-group">
											经办人： <input type="text" name="orderOperator"
												id="orderOperator" class="form-control" placeholder="请输入经办人">
										</div>
										<div class="form-group">
											制单人： <input type="text" name="documentMaker"
												id="documentMaker" class="form-control" placeholder="请输入制单人">
										</div>
										<div class="form-group">
											状态： <input type="number" name="orderState" id="orderState"
												class="form-control" min="0" max="1" placeholder="请选择状态">
										</div>
										<div class="form-group">
											日期： <input type="date" name="orderDate" id="orderDate"
												class="form-control">
										</div>
										<div class="form-group">
											<button type="submit" class="btn btn-primary">提交</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!--//grids-->

		</div>
	</div>
	</div>
	<script src="js/classie.js"></script>
	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1'),
			showLeftPush = document.getElementById('showLeftPush'),
			body = document.body;
	
		showLeftPush.onclick = function() {
			classie.toggle(this, 'active');
			classie.toggle(body, 'cbp-spmenu-push-toright');
			classie.toggle(menuLeft, 'cbp-spmenu-open');
			disableOther('showLeftPush');
		};
	
		function disableOther(button) {
			if (button !== 'showLeftPush') {
				classie.toggle(showLeftPush, 'disabled');
			}
		}
	</script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/dev-loaders.js"></script>
	<script type="text/javascript" src="js/dev-layout-default.js"></script>
	<script type="text/javascript" src="js/jquery.marquee.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">

	<!-- candlestick -->
	<script type="text/javascript" src="js/jquery.jqcandlestick.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jqcandlestick.css" />
	<script>
		Date.prototype.Format = function(fmt) {
			var o = {
				'M+' : this.getMonth() + 1, //月份
				'd+' : this.getDate(), //日
				'h+' : this.getHours(), //小时
				'm+' : this.getMinutes(), //分
				's+' : this.getSeconds(), //秒
				'q+' : Math.floor((this.getMonth() + 3) / 3), //季度
				S : this.getMilliseconds() //毫秒
			}
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(
					RegExp.$1,
					(this.getFullYear() + '').substr(4 - RegExp.$1.length)
			)
			for (var k in o)
				if (new RegExp('(' + k + ')').test(fmt))
					fmt = fmt.replace(
						RegExp.$1,
						RegExp.$1.length == 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length)
			)
			return fmt
		}
	
		function gettime() {
			return new Date().Format('yyyy-MM-dd hh:mm:ss ');
		}
		setInterval(function() {
			var time = gettime();
			$('#time').html(time)
		}, 1000)
	</script>
</body>

</html>