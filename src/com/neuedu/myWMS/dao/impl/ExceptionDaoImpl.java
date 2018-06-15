package com.neuedu.myWMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.neuedu.myWMS.dao.ExceptionDao;
import com.neuedu.myWMS.util.ErrorInfo;
import com.neuedu.myWMS.util.JDBCUtil;

public class ExceptionDaoImpl implements ExceptionDao {

	@Override
	public int insertException(ErrorInfo exception) {
		/*
		 * Exception(exceptionId,reporter,situation,reportDate,holder,
		 * exceptionResult,resultDate)
		 */

		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;
		// 定义resultset
		ResultSet rs = null;
		// 定义返回结果
		int exceptionId = 0;
		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "insert into exceptioninfo values(null,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,DATE_FORMAT(?,'%Y-%m-%d'))";

			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, exception.getReporter());
			pstmt.setString(2, exception.getSituation());
			pstmt.setString(3, exception.getReportDate());
			pstmt.setString(4, exception.getHolder());
			pstmt.setString(5, exception.getExceptionResult());
			pstmt.setString(6, exception.getResultDate());

			// 执行语句
			pstmt.executeUpdate();
			//检索由于执行此 Statement 对象而创建的所有自动生成的键   
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				exceptionId = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exceptionId;
	}

	@Override
	public int deleteException(int exceptionId) {

		// 定义数据库连接对象
		Connection conn = null;
		// 定义PreparedStatement对象
		PreparedStatement pstmt = null;
		// 定义返回值
		int count = 0;
		// 创建连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义sql语句
			String sql = "delete from exceptioninfo where exceptionId=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, exceptionId);
			// result
			count = pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int updateException(ErrorInfo exception) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义PreparedStatement对象
		PreparedStatement pstmt = null;
		// 定义返回值
		int count = 0;
		// 创建连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义sql语句I
			String sql = "update goods set reporter=?,situation=?,reportDate=DATE_FORMAT(?,'%Y-%m-%d'),holder=?,exceptionResult=?,resultDate=DATE_FORMAT(?,'%Y-%m-%d') from urse where exceptionid=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);

			// 设置参数
			pstmt.setString(1, exception.getReporter());
			pstmt.setString(2, exception.getSituation());
			pstmt.setString(3, exception.getReportDate());
			pstmt.setString(4, exception.getHolder());
			pstmt.setString(5, exception.getExceptionResult());
			pstmt.setString(6, exception.getResultDate());
			pstmt.setInt(7, exception.getExceptionId());

			// result
			count = pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public ErrorInfo queryExceptionByExceptionId(int exceptionId) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;

		// 定义返回对象
		ErrorInfo exception = null;
		// 定义resultset
		ResultSet rs = null;
		

		// 创建数据库连接对象
		try {
			try {
				conn = JDBCUtil.getConn();
			} catch (InstantiationException | IllegalAccessException | NamingException e) {
				e.printStackTrace();
			}
			// 定义Sql语句
			String sql = "select * from exceptioninfo where exceptionId=?";
			// 创建执行Sql语句的对象
			pstmt = conn.prepareStatement(sql);
			// 设置pstmt对象中的参数值
			pstmt.setInt(1, exceptionId);
			// 执行sql语句
			rs = pstmt.executeQuery();
			// 解析结果
			if (rs.next()) {
				
				exceptionId = rs.getInt(1);
				String reporter = rs.getString(2);
				String situation = rs.getString(3);
				String reportDate = rs.getDate(6).toString();
				String holder = rs.getString(4);
				String exceptionResult = rs.getString(5);
				String resultDate = rs.getDate(7).toString();
				exception= new ErrorInfo(exceptionId,reporter,situation,reportDate,holder,exceptionResult,resultDate);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exception;
	}

	@Override
	public List<ErrorInfo> queryAllExceptions() {

		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		PreparedStatement pstmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		List<ErrorInfo> exceptions = new ArrayList<ErrorInfo>();

		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();
			// 定义执行的sql语句的对象
			String sql = "select * from exceptioninfo";

			// 创建执行sql语句的对象
			pstmt = conn.prepareStatement(sql);

			// 执行sql语句
			rs = pstmt.executeQuery();

			// 解析结果
			while (rs.next()) {
				
				int exceptionId = rs.getInt(1);
				String reporter = rs.getString(2);
				String situation = rs.getString(3);
				String reportDate = rs.getDate(6).toString();
				String holder = rs.getString(4);
				String exceptionResult = rs.getString(5);
				String resultDate = rs.getDate(7).toString();
				ErrorInfo order = new ErrorInfo(exceptionId,reporter,situation,reportDate,holder,exceptionResult,resultDate);
				exceptions.add(order);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return exceptions;
	}

	@Override
	public List<ErrorInfo> queryErrorInfoByCondition(String condition) {

		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		Statement stmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		List<ErrorInfo> exceptions = new ArrayList<ErrorInfo>();

		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();
			// 定义执行的sql语句的对象
			String sql = "select * from exceptioninfo " + condition;

			// 创建执行sql语句的对象
			stmt = conn.createStatement();

			// 执行sql语句
			rs = stmt.executeQuery(sql);

			// 解析结果
			while (rs.next()) {
				int exceptionId = rs.getInt(1);
				String reporter = rs.getString(2);
				String situation = rs.getString(3);
				String reportDate = rs.getDate(6).toString();
				String holder = rs.getString(4);
				String exceptionResult = rs.getString(5);
				String resultDate = rs.getDate(7).toString();
				ErrorInfo order = new ErrorInfo(exceptionId,reporter,situation,reportDate,holder,exceptionResult,resultDate);
				exceptions.add(order);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
		return exceptions;
	}

}
