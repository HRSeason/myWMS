package com.neuedu.myWMS.dao;

import java.util.List;

import com.neuedu.myWMS.util.User;

public interface UserDao {
	/**
	 * 
	 * @param user:要添加的图书对象
	 * @return:数据库中受影响的行数
	 */
	public int insertUser(User user);
	
	/**
	 * 删除图书的方法
	 * @param userId:要删除的用户编号
	 * @return:数据库中受影响的行数
	 */
	public int deleteUser(int userId);
	/**
	 * 更新图书的方法
	 * @param user:要更新的用户对象
	 * @return:数据库中受影响的行数
	 */
	public int updateUser(User user);
	
	/**
	 * 根据用户编号查询用户对象
	 * @param userId:要删除的用户编号
	 * @return:查询到的用户信息
	 */
	public User queryUserByUserId(int userId);
	
	/**
	 * 根据用户名字查询用户对象
	 * @param userId:要删除的用户编号
	 * @return:查询到的用户信息
	 */
	public User queryUserByUserName(String userName);
	
	/**
	 * 根据用户名字查询用户对象
	 * @param userId:要删除的用户编号
	 * @return:查询到的用户信息
	 */
	public User queryUserByUserIdAndPassword(int userId,String password);
	
	/**
	 * 查询所有用户对象
	 * @return:查询到的用户信息
	 */
	public List<User> queryAllUsers();
	
//	/**
//	 * 根据条件查询用户信息
//	 * @param condition:模糊匹配的条件
//	 * @return:根据条件查询到的用户信集合
//	 */
//	public List<User> queryUsersByCondition(String condition);
	
}
