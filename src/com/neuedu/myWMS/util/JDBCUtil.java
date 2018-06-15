package com.neuedu.myWMS.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class JDBCUtil {
	/*
	 * 创建数据库连接对象
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NamingException {
		// 定义数据库连接对象
		Connection conn = null;
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/myWMS");
		conn = ds.getConnection();
		// 返回连接
		return conn;
	}

	/*
	 * 关闭数据库资源
	 */
	public static void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		// 7、关闭资源(先打开的后关闭)
		if (null != rs) {
			rs.close();
			rs = null;
		}

		if (null != stmt) {
			stmt.close();
			stmt = null;
		}

		if (null != conn) {
			conn.close();
			conn = null;
		}
	}

}
