package com.neuedu.myWMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.neuedu.myWMS.dao.OrderDao;
import com.neuedu.myWMS.util.Order;
import com.sun.xml.internal.ws.client.dispatch.PacketDispatch;
import com.neuedu.myWMS.util.JDBCUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int insertOrder(Order order) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;
		// 定义resultset
		ResultSet rs = null;
		// 定义返回结果
		int orderId = 0;
		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "insert into orders values(null,?,?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?)";

			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, order.getGoodId());
			pstmt.setInt(2, order.getGoodNumber());
			pstmt.setString(3, order.getOrderOperator());
			pstmt.setString(4, order.getDocumentMaker());
			pstmt.setInt(5, order.getOrderState());
			pstmt.setString(6, order.getOrderDate());
			pstmt.setString(7, order.getOrderType());
			// 执行语句
			pstmt.executeUpdate();
			//检索由于执行此 Statement 对象而创建的所有自动生成的键   
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				orderId = rs.getInt(1);
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
		return orderId;
	}

	@Override
	public int deleteOrder(int orderId) {
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
			String sql = "delete from orders where orderId=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, orderId);
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
	public int updateOrder(Order order) {

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
			String sql = "update orders set goodid=?,goodnumber=?,orderOperator=?,documentMaker=?,orderState=DATE_FORMAT(?,'%Y-%m-%d'),orderDate=?,ordertype=?,"
					+ "where orderid=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);

			// 设置参数
			pstmt.setInt(1, order.getGoodId());
			pstmt.setInt(2, order.getGoodNumber());
			pstmt.setString(3, order.getOrderOperator());
			pstmt.setString(4, order.getDocumentMaker());
			pstmt.setInt(5, order.getOrderState());
			pstmt.setString(6, order.getOrderDate());
			pstmt.setString(7, order.getOrderType());
			pstmt.setInt(8, order.getOrderId());

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
	public Order queryOrderByOrderId(int orderId) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;

		// 定义返回对象
		Order order = null;
		// 定义resultset
		ResultSet rs = null;

		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "select * from orders where orderId=?";
			// 创建执行Sql语句的对象
			pstmt = conn.prepareStatement(sql);
			// 设置pstmt对象中的参数值
			pstmt.setInt(1, orderId);
			// 执行sql语句
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int ordersId = rs.getInt(1);
				int goodId = rs.getInt(2);
				int goodNumber = rs.getInt(3);
				String orderOperator = rs.getString(4);
				String documentMaker = rs.getString(5);
				int orderState = rs.getInt(6);
				String orderDate = rs.getDate(7).toString();
				String orderType=rs.getString(8);
				order = new Order(ordersId,orderType,goodId,goodNumber,orderOperator,documentMaker,
						orderState,orderDate);
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
		return order;
	}

	@Override
	public List<Order> queryAllOrders() {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		PreparedStatement pstmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		List<Order> orders = new ArrayList<Order>();

		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();
			// 定义执行的sql语句的对象
			String sql = "select * from orders";

			// 创建执行sql语句的对象
			pstmt = conn.prepareStatement(sql);

			// 执行sql语句
			rs = pstmt.executeQuery();

			// 解析结果
			while (rs.next()) {
				int orderId = rs.getInt(1);
				int goodId = rs.getInt(2);
				int goodNumber = rs.getInt(3);
				String orderOperator = rs.getString(4);
				String documentMaker = rs.getString(5);
				int orderState = rs.getInt(6);
				String orderDate = rs.getDate(7).toString();
				String orderType=rs.getString(8);
				Order order = new Order(orderId,orderType,goodId,goodNumber,orderOperator,documentMaker,
						orderState,orderDate);
				orders.add(order);
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

		return orders;
	}

	@Override
	public List<Order> queryOrderByCondition(String condition) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		Statement stmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		List<Order> orders = new ArrayList<Order>();

		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();
			// 定义执行的sql语句的对象
			String sql = "select * from orders " + condition;

			// 创建执行sql语句的对象
			stmt = conn.createStatement();

			// 执行sql语句
			rs = stmt.executeQuery(sql);

			// 解析结果
			while (rs.next()) {
				int orderId = rs.getInt(1);
				int goodId = rs.getInt(2);
				int goodNumber = rs.getInt(3);
				String orderOperator = rs.getString(4);
				String documentMaker = rs.getString(5);
				int orderState = rs.getInt(6);
				String orderDate = rs.getDate(7).toString();
				String orderType=rs.getString(8);
				Order order = new Order(orderId,orderType,goodId,goodNumber,orderOperator,documentMaker,
						orderState,orderDate);
				orders.add(order);
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

		return orders;

	}

}
