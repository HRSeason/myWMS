<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>占位盒子
	</div>
	<div class="UpdateGoods">
		<form action="TestServlet?action=showMe&goodId=1002" method="post">
			<table>
				<caption>新增货物信息</caption>
				<tr>
					<td>货物名称：</td>
					<td><input type="text" name="goodName" id="goodName"></td>
				</tr>
				<tr>
					<td>库存数量：</td>
					<td><input type="number" name="stockNumber" id="stockNumber"></td>
				</tr>
				<tr>
					<td>库存位置：</td>
					<td><select name="locationwarehouse">
							<option value="A仓">A</option>
							<option value="B仓">B</option>
							<option value="C仓">C</option>
						</select>仓
						<select name="locationdepart">
							<option value="A区">A</option>
							<option value="B区">B</option>
							<option value="C区">C</option>
							<option value="D区">D</option>
							<option value="E区">E</option>
						</select>区
						<select name="locationfloor">
							<option value="一层">一</option>
							<option value="二层">二</option>
							<option value="三层">三</option>
							<option value="四层">四</option>
						</select>层
						<input type="text" name="locationdetal" id="locationdetal">
					</td>
				</tr>
				<tr>
					<td>类型：</td>
					<td><input type="text" name="goodType" id="goodType"></td>
				</tr>
				<tr>
					<td><input type="button" src="TestServlet?action=showMe&amp;goodid=1002" value="tiaozhuan"></td>
					<td><input type="submit" name="goodsSubmit" id="goodsSubmit" value=" 提 交 "></td>
					<td><input type="reset" name="goodsReset" id="goodsReset" value=" 重 置 "></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>