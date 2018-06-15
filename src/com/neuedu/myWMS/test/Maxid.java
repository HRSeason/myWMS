package com.neuedu.myWMS.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.neuedu.myWMS.util.JDBCUtil;

public class Maxid {
	
	public void MaxUserId() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NamingException{
		//获取数据库连接
		Connection conn = JDBCUtil.getConn();
		//创建sql语句的执行对象
		Statement stmt = conn.createStatement();
		//创建sql语句
		String sql = "select max(userid) from users";
		//创建resultset对象
		ResultSet rs = stmt.executeQuery(sql);
		//解析结果
		System.out.println(rs);
	}
}
