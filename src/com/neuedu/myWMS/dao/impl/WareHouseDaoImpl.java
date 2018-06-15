package com.neuedu.myWMS.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.neuedu.myWMS.dao.WareHouseDao;
import com.neuedu.myWMS.util.JDBCUtil;
import com.neuedu.myWMS.util.WareHouse;

public class WareHouseDaoImpl implements WareHouseDao {

	@Override
	public int insertWareHouse(WareHouse wareHouse) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;
		// 定义resultset
		ResultSet rs = null;
		// 定义返回结果
		int wareHouseId = 0;
		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "insert into warehouse values(null,?,?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'))";
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, wareHouse.getGoodId());
			pstmt.setInt(2, wareHouse.getGoodNumber());
			pstmt.setInt(3, wareHouse.getState());
			pstmt.setString(4, wareHouse.getReason());
			pstmt.setString(5, wareHouse.getManager());
			pstmt.setString(6, wareHouse.getWareHorseDate());

			// 执行语句
			pstmt.executeUpdate();
			//检索由于执行此 Statement 对象而创建的所有自动生成的键   
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				wareHouseId = rs.getInt(1);
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
		return wareHouseId;
	}

	@Override
	public int deleteWareHouse(int wareHouseId) {

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
			String sql = "delete from warehouse where warehouseid=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, wareHouseId);
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
	public int updateWareHouse(WareHouse wareHouse) {
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
			String sql = "update warehouse set goodId=?,goodNumber=?,state=?,reason=?,manager=?,wareHorseDate=DATE_FORMAT(?,'%Y-%m-%d') where wareHouseId=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, wareHouse.getGoodId());
			pstmt.setInt(2, wareHouse.getGoodNumber());
			pstmt.setInt(3, wareHouse.getState());
			pstmt.setString(4, wareHouse.getReason());
			pstmt.setString(5, wareHouse.getManager());
			pstmt.setString(6, wareHouse.getWareHorseDate());
			pstmt.setInt(7, wareHouse.getWareHouseId());

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
	public WareHouse queryWareHouseByWareHouseId(int wareHouseId) {
		// 定义数据库连接对象
				Connection conn = null;
				// 定义预编译的Sql对象
				PreparedStatement pstmt = null;

				// 定义返回对象
				WareHouse wareHouse = null;
				// 定义resultset
				ResultSet rs = null;

				// 创建数据库连接对象
				try {
					conn = JDBCUtil.getConn();
					// 定义Sql语句
					String sql = "select * from warehouse where wareHouseId=?";
					// 创建执行Sql语句的对象
					pstmt = conn.prepareStatement(sql);
					// 设置pstmt对象中的参数值
					pstmt.setInt(1, wareHouseId);
					// 执行sql语句
					rs = pstmt.executeQuery();
					if (rs.next()) {
						int wareHousesId = rs.getInt(1);
						int goodId = rs.getInt(2);
						int goodNumber = rs.getInt(3);
						int state = rs.getInt(4);
						String reason = rs.getString(5);
						String manager = rs.getString(6);
						String wareHorseDate = rs.getDate(7).toString();
						/**
						 *  WareHouse(String wareHouseId, int goodId, int goodNumber, int state,String reason, String manager, String wareHorseDate) {
						 */
						wareHouse = new WareHouse(wareHousesId,goodId,goodNumber,state,reason,manager,wareHorseDate);
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
				return wareHouse;
	}

	@Override
	public List<WareHouse> queryAllWareHouses() {
		// 定义数据库连接对象
				Connection conn = null;
				// 定义预编译的SQL对象
				PreparedStatement pstmt = null;
				// 定义结果集对象
				ResultSet rs = null;

				// 创建返回结果
				List<WareHouse> wareHouses = new ArrayList<WareHouse>();

				try {
					// 创建数据库连接对象
					conn = JDBCUtil.getConn();
					// 定义执行的sql语句的对象
					String sql = "select * from warehouse";

					// 创建执行sql语句的对象
					pstmt = conn.prepareStatement(sql);

					// 执行sql语句
					rs = pstmt.executeQuery();

					// 解析结果
					while (rs.next()) {
						int wareHouseId = rs.getInt(1);
						int goodId = rs.getInt(2);
						int goodNumber = rs.getInt(3);
						int state = rs.getInt(4);
						String reason = rs.getString(5);
						String manager = rs.getString(6);
						String wareHorseDate = rs.getDate(7).toString();

						/**
						 *  WareHouse(String wareHouseId, int goodId, int goodNumber, int state,String reason, String manager, String wareHorseDate) {
						 */
						WareHouse wareHouse = new WareHouse(wareHouseId,goodId,goodNumber,state,reason,manager,wareHorseDate);
						wareHouses.add(wareHouse);
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

				return wareHouses;
	}

	@Override
	public List<WareHouse> queryWareHouseByCondition(String condition) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		Statement stmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		List<WareHouse> wareHouses = new ArrayList<WareHouse>();

		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();
			// 定义执行的sql语句的对象
			String sql = "select * from warehouse " + condition;

			// 创建执行sql语句的对象
			stmt = conn.createStatement();

			// 执行sql语句
			rs = stmt.executeQuery(sql);

			// 解析结果
			while (rs.next()) {
				int wareHouseId = rs.getInt(1);
				int goodId = rs.getInt(2);
				int goodNumber = rs.getInt(3);
				int state = rs.getInt(4);
				String reason = rs.getString(5);
				String manager = rs.getString(6);
				String wareHorseDate = rs.getDate(7).toString();

				/**
				 *  WareHouse(String wareHouseId, int goodId, int goodNumber, int state,String reason, String manager, String wareHorseDate) {
				 */
				WareHouse wareHouse = new WareHouse(wareHouseId,goodId,goodNumber,state,reason,manager,wareHorseDate);
				wareHouses.add(wareHouse);
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
				JDBCUtil.closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return wareHouses;
	}

}
