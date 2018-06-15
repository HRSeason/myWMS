package com.neuedu.myWMS.service;

import java.util.List;

import com.neuedu.myWMS.util.User;


public interface UserService {

	//用户注册
	public boolean register(User user);
	
	//判断用户名是否存在
	public boolean isExistUser(int userId);
	
	//用户登录
	//public boolean login(String userName, String userPass);
	public User login(int userId, String userPass);
	
	//获取所有的用户信息
	public List<User> getAllUsers();
	
	//更新用户
	public int updateUser(User user);
	
	//根据用户id查询用户
	public User queryUserByUserId(int userId) ;
	
	//根据用户名查询用户
	public User queryUserByUserName(String userName);
	
	//删除用户
	public boolean deleteUser(int userId);
	
	

}
