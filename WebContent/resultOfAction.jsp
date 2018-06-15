<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>
	</div>
	<div>
		<p>恭喜你，操作成功！</p>
		<c:if test="${goodId != null}">
			<p>您所操作的货物的编号是：
			<a href="GoodsManagerServlet?action=showGoodInfoById&goodId=${goodId}">${goodId}</a></p>
		</c:if>
		<c:if test="${orderId != null}">
			<p>您所操作的订单的编号是：
			<a href="OrderManagerServlet?action=showOrderInfoById&orderId=${orderId}">${orderId}</a></p>
		</c:if>
		<c:if test="${wareHouseId != null}">
			<p>您所操作的仓库订单的的编号是：
			<a href="/WareHouseManagerServlet?action=showWareHouseInfoById&wareHouseId=${wareHouseId}">${wareHouseId}</a></p>
		</c:if>
		<c:if test="${userId != null}">
			<p>您所操作的用户的编号是：
			<a href="UserManagerServlet?action=showUserInfoById&userId=${userId}">${userId}</a></p>
		</c:if>
		<c:if test="${exceptionId != null}">		
			<p>您所操作的异常订单的的编号是：
			<a href="ExceptionManagerServlet?action=showExceptionInfoById&exceptionId=${exceptionId}">${exceptionId}</a></p>
		</c:if>
	</div>
</div>
</body>
</html>