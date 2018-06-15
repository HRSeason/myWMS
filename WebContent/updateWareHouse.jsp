<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改仓库订单</title>
</head>
<body>
<div>
	<div>占位盒子
	</div>
	<div class="UpdateWareHouse">
		<form action="WareHouseManagerServlet?action=updateWareHouse" method="post">
			<table>
				<caption>修改仓库订单</caption>
				<tr>
					<td>订单编号：</td>
					<td><input type="text" name="wareHouseId" id="wareHouseId" value="${wareHouse.wareHouseId}"readonly></td>
				</tr>
				<tr>
					<td>商品编号：</td>
					<td><input type="text" name="goodId" id="goodId" value="${wareHouse.goodId}"></td>
				</tr>
				<tr>
					<td>数量：</td>
					<td><input type="number" name="goodNumber" id="goodNumber" value="${wareHouse.goodNumber}"></td>
				</tr>
				<tr>
					<td>理由：</td>
					<td><input type="text" name="reason" id="reason" value="${wareHouse.reason}" readonly></td>
				</tr>
				<tr>
					<td>制单人：</td>
					<td><input type="text" name="manager" id="manager" value="${wareHouse.manager}"></td>
				</tr>
				<tr>
					<td>状态：</td>
					<td><input type="text" name="state" id="state" value="${wareHouse.state}"><td>
					<td>日期：</td>
					<td><input type="text" name="wareHouseDate" id="wareHouseDate" value="${wareHouse.wareHouseDate}"></td>
				</tr>
				<tr>
					<td><input type="submit" name="wareHouseSubmit" id="wareHouseSubmit" value=" 提 交 "></td>
					<td><input type="reset" name="wareHouseReset" id="wareHouseReset" value=" 重 置 "></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>