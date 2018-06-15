<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增异常情况</title>
</head>
<body>
<div>
	<div>占位盒子
	</div>
	<div class="AddExceptionInfo">
		<form action="OrderManagerServlet?action=addOrder" method="post">
			<table>
				<caption>新增异常情况</caption>
				<tr>
					<td>报告人：</td>
					<td><input type="text" name="reporter" id="reporter"></td>
				</tr>
				<tr>
					<td>异常情况：</td>
					<td><textarea name="exceptionSituation" id="exceptionSituation" rows="5" cols="20"></textarea></td>
				</tr>
				<tr>
					<td>经办人：</td>
					<td><input type="text" name="holder" id="holder"></td>
				</tr>
				<tr>
					<td>处理结果：</td>
					<td><textarea name="exceptionResult" id="exceptionResult" rows="5" cols="20"></textarea></td>
				</tr>
				<tr>
					<td>报告日期：</td>
					<td><input type="text" name="reportDate" id="reportDate"><td>
					<td>处理日期：</td>
					<td><input type="text" name="resultDate" id="resultDate"></td>
				</tr>
				<tr>
					<td><input type="submit" name="exceptionSubmit" id="exceptionSubmit" value=" 提 交 "></td>
					<td><input type="reset" name="exceptionReset" id="exceptionReset" value=" 重 置 "></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>