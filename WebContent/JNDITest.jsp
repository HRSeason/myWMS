<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.myWMS.util.JDBCUtil" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "javax.naming.Context" %>
<%@ page import = "javax.naming.InitialContext" %>
<%@ page import = "javax.sql.DataSource" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JNDI测试页：数据库连接状态查询</title>
</head>
<body>
<%
	Connection conn = JDBCUtil.getConn();
	out.println("现在数据库的链接状态：" + (conn.isClosed()==false ? "开启状态" : "关闭状态"));
 %>

</body>
</html>