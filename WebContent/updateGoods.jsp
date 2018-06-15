<%@page import="com.neuedu.myWMS.util.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改货物信息</title>
</head>
<body>
<div>
	<div>占位盒子
	</div>
	<div class="UpdateGoods">
		<c:if test="${errorInfo != null}">
			<div>${errorInfo }</div>
		</c:if>
		<form action="GoodsManagerServlet?action=updateGoods" method="post">
			<table>
				<caption>修改货物信息</caption>
				<tr>
					<td>货物编号：</td>
					<td><input type="number" name="goodId" id="goodId" readonly value="${good.goodId}"></td>
				</tr>
				<tr>
					<td>货物名称：</td>
					<td><input type="text" name="goodName" id="goodName" value="${good.goodName}"></td>
				</tr>
				<tr>
					<td>库存位置：</td>
					<td><select name="locationwarehouse" value=${good.location.split("-")[0] }>
							<option value="A仓" ${good.location.split("-")[0] eq "A仓" ? "selected" : "" }>A</option>
							<option value="B仓" ${good.location.split("-")[0] eq "B仓" ? "selected" : "" }>B</option>
							<option value="C仓" ${good.location.split("-")[0] eq "C仓" ? "selected" : "" }>C</option>
						</select>仓
						<select name="locationdepart" value=${good.location.split("-")[1] }>
							<option value="A区" ${good.location.split("-")[1] eq "A区" ? "selected" : "" }>A</option>
							<option value="B区" ${good.location.split("-")[1] eq "B区" ? "selected" : "" }>B</option>
							<option value="C区" ${good.location.split("-")[1] eq "C区" ? "selected" : "" }>C</option>
							<option value="D区" ${good.location.split("-")[1] eq "D区" ? "selected" : "" }>D</option>
							<option value="E区" ${good.location.split("-")[1] eq "E区" ? "selected" : "" }>E</option>
						</select>区
						<select name="locationfloor" value=${good.location.split("-")[2] }>
							<option value="一层"  ${good.location.split("-")[2] eq "一层" ? "selected" : "" } >一</option>
							<option value="二层"  ${good.location.split("-")[2] eq "二层" ? "selected" : "" } >二</option>
							<option value="三层"  ${good.location.split("-")[2] eq "三层" ? "selected" : "" } >三</option>
							<option value="四层"  ${good.location.split("-")[2] eq "四层" ? "selected" : "" } >四</option>
						</select>层
						<input type="text" name="locationdetal" id="locationdetal" value=${good.location.split("-")[3] }>
					</td>
				</tr>
				<tr>
					<td>库存数量：</td>
					<td><input type="number" name="stockNumber" id="stockNumber" value="${good.stockNumber }"></td>
					<td>类型：</td>
					<td>
						<select name="goodType" id="goodType" value="${good.goodType}">
							<option value="家用电器" ${good.goodType eq "家用电器" ? "selected" : "" }>家用电器</option>
							<option value="办公用品" ${good.goodType eq "办公用品" ? "selected" : "" }>办公用品</option>
							<option value="特殊物品" ${good.goodType eq "特殊物品" ? "selected" : "" }>特殊物品</option>
						</select>						
					</td>
				</tr>
				<tr>
					<td><input type="submit" name="goodsSubmit" id="goodsSubmit" value=" 提 交 "></td>
					<td><input type="reset" name="goodsReset" id="goodsReset" value=" 重 置 "></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>