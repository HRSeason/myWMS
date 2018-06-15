package com.neuedu.myWMS.service.impl;

import java.util.List;

import com.neuedu.myWMS.dao.UserDao;
import com.neuedu.myWMS.dao.impl.UserDaoImpl;
import com.neuedu.myWMS.service.UserService;
import com.neuedu.myWMS.util.User;

public class UserServiceImpl implements UserService {

private UserDao userDao = new UserDaoImpl();
	
	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserServiceImpl getInstance() {
		if(null == instance) {
			instance = new UserServiceImpl();
		}
		
		return instance;
	}
	@Override
	public boolean register(User user) {
		
		return userDao.insertUser(user) > 0;
	}

	/**
	 * 返回true表示用户名已经存在，不能注册该用户
	 * 返回false表示用户名不存在，可以注册
	 */
	@Override
	public boolean isExistUser(int userId) {
		return userDao.queryUserByUserId(userId)!= null;
	}

	//返回true表示用户存在，登录成功，否则就是登录失败
	@Override
	public User login(int userId, String userPass) {
		return userDao.queryUserByUserIdAndPassword(userId, userPass);
	}

	@Override
	public List<User> getAllUsers() {
		//调用userdao中查询所有用户信息的方法
		return userDao.queryAllUsers();
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User queryUserByUserId(int userId) {
		return userDao.queryUserByUserId(userId);
	}

	@Override
	public User queryUserByUserName(String userName) {
		return userDao.queryUserByUserName(userName);
	}

	@Override
	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId)!=0;
	}

}
