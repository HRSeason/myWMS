package com.neuedu.myWMS.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.myWMS.dao.UserDao;
import com.neuedu.myWMS.util.JDBCUtil;
import com.neuedu.myWMS.util.User;


public class UserDaoImpl implements UserDao {

	/**
	 * 
	 * 
	 * int userId, string userName,string password, string gender,int
	 * userState,int root, string department,string job
	 */
	@Override
	public int insertUser(User user) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;
		// 定义resultset
		ResultSet rs = null;
		// 定义返回结果
		int count = 0;
		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
//			String sql = "insert into users values(?,?,?,?,?,?,?,?)";
			String sql = "insert into users values(null,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

//			pstmt.setInt(1, user.getUserId());
//			pstmt.setString(2, user.getUserName());
//			pstmt.setString(3, user.getPassword());
//			pstmt.setString(4, user.getGender());
//			pstmt.setInt(5, user.getUserState());
//			pstmt.setInt(6, user.getRoot());
//			pstmt.setString(7, user.getDepartment());
//			pstmt.setString(8, user.getJob());
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getGender());
			pstmt.setInt(4, user.getUserState());
			pstmt.setInt(5, user.getRoot());
			pstmt.setString(6, user.getDepartment());
			pstmt.setString(7, user.getJob());

			// 执行语句
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int deleteUser(int userId) {
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
			String sql = "delete from users where userid=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, userId);
			// result
			count = pstmt.executeUpdate();
		} catch (Exception e) {
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
	public int updateUser(User user) {
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
			String sql = "update users set username=?,password=?,gender=?,userstate=?,root=?,department=?,job=? where userid=?";
			// 创建执行对象
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getGender());
			pstmt.setInt(4, user.getUserState());
			pstmt.setInt(5, user.getRoot());
			pstmt.setString(6, user.getDepartment());
			pstmt.setString(7, user.getJob());
			pstmt.setInt(8, user.getUserId());

			// result
			count = pstmt.executeUpdate();
		} catch (Exception e) {
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
	public User queryUserByUserId(int userId) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;

		// 定义返回对象
		User user = null;
		// 定义resultset
		ResultSet rs = null;

		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "select * from users where userid=?";
			// 创建执行Sql语句的对象
			pstmt = conn.prepareStatement(sql);
			// 设置pstmt对象中的参数值
			pstmt.setInt(1, userId);
			// 执行sql语句
			rs = pstmt.executeQuery();
//			user=(User)rs;
			while (rs.next()) {
				
				user.setUserId(Integer.valueOf((String)rs.getObject(1)));
				user.setUserName((String)rs.getObject(2));
				user.setPassword((String)rs.getObject(3));
				user.setGender((String)rs.getObject(4));
				user.setRoot(Integer.valueOf((String)rs.getObject(5)));
				user.setDepartment((String)rs.getObject(6));
				user.setJob((String)rs.getObject(7));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(userId+"~~~~");
		return user;

	}

	@Override
	public User queryUserByUserName(String userName) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;

		// 定义返回对象
		User user = null;
		// 定义resultset
		ResultSet rs = null;

		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "select * from users where username=?";
			// 创建执行Sql语句的对象
			pstmt = conn.prepareStatement(sql);
			// 设置pstmt对象中的参数值
			pstmt.setString(1, userName);
			// 执行sql语句
			rs = pstmt.executeQuery();
			user = (User) rs;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public User queryUserByUserIdAndPassword(int userId, String password) {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的Sql对象
		PreparedStatement pstmt = null;

		// 定义返回对象
//		User user = null;
		User user=new User();
		// 定义resultset
		ResultSet rs = null;

		// 创建数据库连接对象
		try {
			conn = JDBCUtil.getConn();
			// 定义Sql语句
			String sql = "select * from users where userId=? and password=?";
			// 创建执行Sql语句的对象
			pstmt = conn.prepareStatement(sql);
			// 设置pstmt对象中的参数值
			pstmt.setInt(1, userId);
			pstmt.setString(2, password);
			// 执行sql语句
			rs = pstmt.executeQuery();
//			user=(User)rs;
			while (rs.next()) {
				try {
					user.setUserId(Integer.parseInt(String.valueOf(rs.getObject(1))));
					user.setUserName((String)rs.getObject(2));
					user.setPassword((String)rs.getObject(3));
					user.setGender((String)rs.getObject(4));
					user.setUserState(Integer.parseInt(String.valueOf(rs.getObject(5))));
					user.setRoot(Integer.parseInt(String.valueOf(rs.getObject(6))));
					user.setDepartment((String)rs.getObject(7));
					user.setJob((String)rs.getObject(8));
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(conn, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(user);
		return user;
	}

	@Override
	public List<User> queryAllUsers() {
		// 定义数据库连接对象
		Connection conn = null;
		// 定义预编译的SQL对象
		PreparedStatement pstmt = null;
		// 定义结果集对象
		ResultSet rs = null;

		// 创建返回结果
		List<User> users = new ArrayList<User>();

		try {
			// 创建数据库连接对象
			conn = JDBCUtil.getConn();
			// 定义执行的sql语句的对象
			String sql = "select * from users";

			// 创建执行sql语句的对象
			pstmt = conn.prepareStatement(sql);

			// 执行sql语句
			rs = pstmt.executeQuery();

			// 解析结果
			while (rs.next()) {
				int userId = rs.getInt(1);
				String userName = rs.getString(2);
				String password = rs.getString(3);
				String gender = rs.getString(4);
				int userState = rs.getInt(5);
				int root = rs.getInt(6);
				String department = rs.getString(7);
				String job = rs.getString(8);

				User user = new User(userId, userName, password, gender, userState, root, department, job);
				users.add(user);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}
}
