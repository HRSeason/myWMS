package com.neuedu.myWMS.util;

/**
 * user表格的工具类
 * @author 雨小陌童靴
 *
 */
public class User {
	
	//定义私有的变量，用户编号
	private int userId;
	
	//定义私有的变量，用户姓名
	private String userName;
	
	//定义私有的变量，用户密码
	private String password;
	
	//定义私有的变量，用户编号
	private String gender;
	
	//定义私有的变量，用户状态（0是离职状态，1是在职状态）
	private int userState;
	
	//定义私有的变量，用户权限（0表示管理员，1表示普通用户，2表示无权限用户）
	private int root;
	
	//定义私有的变量，用户部门
	private String department;
	
	//定义私有的变量，用户职位
	private String job;

	public User() {
		super();
	}

	public User(int userId, String userName, String password, String gender,
			int userState, int root, String department, String job) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.userState = userState;
		this.root = root;
		this.department = department;
		this.job = job;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", userState=" + userState + ", root=" + root + ", department=" + department + ", job=" + job + "]";
	}
	
	
}
