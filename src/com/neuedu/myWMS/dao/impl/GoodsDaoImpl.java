package com.neuedu.myWMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.neuedu.myWMS.dao.GoodsDao;
import com.neuedu.myWMS.util.Goods;
import com.neuedu.myWMS.util.JDBCUtil;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public int insertGoods(Goods goods) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;
		// 定义resultset
		ResultSet rs = null;
		// 定义返回结果
		int goodId = 0;
		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "insert into goods values(null,?,?,?,?)";
			//指定返回的主键
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, goods.getGoodName());
			pstmt.setInt(2, goods.getStockNumber());
			pstmt.setString(3, goods.getLocation());
			pstmt.setString(4, goods.getGoodType());
			// 执行语句
			pstmt.executeUpdate();
			//检索由于执行此 Statement 对象而创建的所有自动生成的键   
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				goodId = rs.getInt(1);
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
		return goodId;
	}

	@Override
	public int deleteGoods(int goodId) {

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
			String sql = "delete from goods where goodId=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, goodId);
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
	public int updateGoods(Goods goods) {
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
			String sql = "update goods set goodName=?,stockNumber=?,location=?,goodType=? where goodId=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);

			// 设置参数
			pstmt.setString(1, goods.getGoodName());
			pstmt.setInt(2, goods.getStockNumber());
			pstmt.setString(3, goods.getLocation());
			pstmt.setString(4, goods.getGoodType());
			pstmt.setInt(5, goods.getGoodId());

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
	public Goods queryGoodsByGoodId(int goodId) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;

		// 定义返回对象
		Goods good = null;
		// 定义resultset
		ResultSet rs = null;

		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "select * from goods where goodid=?";
			// 创建执行Sql语句的对象
			pstmt = conn.prepareStatement(sql);
			// 设置pstmt对象中的参数值
			pstmt.setInt(1, goodId);
			// 执行sql语句
			rs = pstmt.executeQuery();
			// 解析结果
			if (rs.next()) {
				int goodsId = rs.getInt(1);
				String goodsName = rs.getString(2);
				int stockNumber = rs.getInt(3);
				String location = rs.getString(4);
				String goodType = rs.getString(5);
				good = new Goods(goodsId, goodsName, stockNumber, location, goodType);
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
		return good;
	}

	@Override
	public List<Goods> queryAllGoods() {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		PreparedStatement pstmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		List<Goods> goods = new ArrayList<Goods>();

		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();
			// 定义执行的sql语句的对象
			String sql = "select * from goods";

			// 创建执行sql语句的对象
			pstmt = conn.prepareStatement(sql);

			// 执行sql语句
			rs = pstmt.executeQuery();

			// 解析结果
			while (rs.next()) {
				int goodId = rs.getInt(1);
				String goodName = rs.getString(2);
				int stockNumber = rs.getInt(3);
				String location = rs.getString(4);
				String goodType = rs.getString(5);
				Goods good = new Goods(goodId, goodName, stockNumber, location, goodType);
				goods.add(good);
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

		return goods;
	}

	@Override
	public Goods queryGoodsByGoodName(String goodName) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		PreparedStatement pstmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		Goods good = null;
		
		System.out.println("需要查询的货物名称是：" + goodName);
		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();	
					// 定义执行的sql语句的对象
			String sql = "select * from goods where goodname=?";
			// 创建执行sql语句的对象
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, goodName);
			// 执行sql语句
			rs = pstmt.executeQuery();
			// 解析结果
			if (rs.next()) {
				int goodId = rs.getInt(1);
				String goodsName = rs.getString(2);
				int stockNumber = rs.getInt(3);
				String location = rs.getString(4);
				String goodType = rs.getString(5);
				good = new Goods(goodId, goodsName, stockNumber, location, goodType);
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

		return good;
	}

	@Override
	public List<Goods> queryGoodsByCondition(String condition) {
		//定义Connection对象
		 Connection conn = null;
		//定义PreparedStatement对象
		Statement stmt = null;		
		//定义返回值
		ResultSet  rs= null;
		List<Goods> goods = new ArrayList<Goods>();
		//建立连接
		try {
			conn = JDBCUtil.getConn();
			//定义SQL语句
			String sql = "select * from goods " + condition;
			//创建执行sql语句的对象
			stmt = conn.createStatement();
			//执行sql语句
			rs = stmt.executeQuery(sql);
			//解析结果
			while(rs.next()){
				int goodId = rs.getInt(1);
				String goodsName = rs.getString(2);
				int stockNumber = rs.getInt(3);
				String location = rs.getString(4);
				String goodType = rs.getString(5);
				Goods good = new Goods(goodId, goodsName, stockNumber, location, goodType);
				goods.add(good);
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException
				| NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return goods;
	}

}
