<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改销售/退货/采购订单</title>
</head>
<body>
<div>
	<div>占位盒子
	</div>
	<div class="UpdateOrder">
		<form action="OrderManagerServlet?action=updateOrder" method="post">
			<table>
				<caption>修改销售/退货订单</caption>
				<tr>
					<td>订单编号：</td>
					<td><input type="number" name="orderId" id="orderId" value="${order.orderId }" readonly></td>
					<td>订单种类：</td>
					<td><select name="orderType"><option id="orderType" value="sales" ${order.orderType eq "sales" ? "selected" : "" }>销售订单</option>
					<option  id="orderType" value="purchase" ${order.orderType eq "purchase" ? "selected" : "" } >采购订单</option>
					<option  id="orderType" value="return" ${order.orderType eq "return" ? "selected" : "" } >退货订单</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>商品编号：</td>
					<td><input type="text" name="goodId" id="goodId" value="${order.goodId }"></td>
				</tr>
				<tr>
					<td>数量：</td>
					<td><input type="number" name="goodNumber" id="goodNumber" value="${order.goodNumber }" readonly></td>
				</tr>
				<tr>
					<td>经办人：</td>
					<td><input type="text" name="orderOperator" id="orderOperator" value="${order.orderOperator }"></td>
					<td>制单人：</td>
					<td><input type="text" name="documentMaker" id="documentMaker" value="${order.documentMaker }"></td>
				</tr>
				<tr>
					<td>状态：</td>
					<td><input type="text" name="orderState" id="orderState" value="${order.orderState }"><td>
					<td>日期：</td>
					<td><input type="text" name="orderDate" id="orderDate" value="${order.orderDate }" readonly></td>
				</tr>
				<tr>
					<td><input type="submit" name="orderSubmit" id="orderSubmit" value=" 提 交 "></td>
					<td><input type="reset" name="orderReset" id="orderReset" value=" 重 置 "></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>