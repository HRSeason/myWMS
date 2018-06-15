package com.neuedu.myWMS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.myWMS.service.UserService;
import com.neuedu.myWMS.service.impl.UserServiceImpl;
import com.neuedu.myWMS.util.MD5Algroithm;
import com.neuedu.myWMS.util.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserManagerServlet")
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 注销方法
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 删除session中保存的用户登录数据
		HttpSession session = request.getSession(true);
		// 删除原先设置的username属性
		session.removeAttribute("username");
		session.invalidate();

		// 页面跳转到登录页面
		response.sendRedirect("index.jsp");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取用户提交的用户Id
		String userId = request.getParameter("userId");
		// String[] userIds = request.getParameterValues("userId");
		System.out.println("您要删除的用户编号是：" + userId);
	}

	// 获取所有的用户信息
	private void showAllUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 创建UserSerivce对象
		UserService userService = UserServiceImpl.getInstance();
		// 获取查询到的用户集合
		List<User> users = userService.getAllUsers();

		// 将集合对象添加到作用域中
		request.getSession().setAttribute("users", users);

		// 页面跳转
		response.sendRedirect("queryAllUsers.jsp");
	}

	// 修改用户个人信息
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, NoSuchAlgorithmException {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");

		// 设置contenttype(同时设置MIME类型和字符集)
		response.setContentType("text/plain;charset=utf-8");
		// 获取输出流对象，向客户端写入数据
		PrintWriter out = response.getWriter();

		// 获取用户输入
		// 获取用户输入的员工姓名
		String userName = request.getParameter("userName");
		// 获取用户的性别
		String gender = request.getParameter("gender");
		// 获取用户的在职状态
		String userState = request.getParameter("userState");
		// 获取用户的权限（0是管理员，1是普通用户）
		int root = Integer.parseInt(request.getParameter("root"));
		// 获取用户所在的部门
		String department = request.getParameter("department");
		// 获取用户的职位
		String job = request.getParameter("job");
		System.out.println("\n+updateUser:用户名：" + userName  + "，性别是：" + gender+",在职状态："+userState+",部门："+department+",工作："+job);

		// 创建User对象
		User user = new User();
		user.setUserName(userName);		
		user.setPassword(user.getPassword());
		user.setGender(gender);
		user.setRoot(root);
		user.setUserState(Integer.parseInt(userState));
		user.setDepartment(department);
		user.setJob(job);

		System.out.println(user);
		// 创建UserService对象
		UserService userService = UserServiceImpl.getInstance();

		if (userService.isExistUser(user.getUserId())) {
			
			// 用户名已经存在，重新注册
			// 页面跳转（请求转发）
			request.getRequestDispatcher("addUser.html").forward(request, response);
		} else {
			// 调用注册方法
			boolean isRegisterSuccess = userService.register(user);

			System.out.println(isRegisterSuccess ? "注册成功" : "注册失败");

			// 向客户端浏览器输出注册结果
			// out.println(isRegisterSuccess ? "注册成功" : "注册失败");
			if (isRegisterSuccess) {
				// 注册成功，跳转到hello.html页面
				// 重定向
				response.sendRedirect("main.jsp");
			} else {
				// 注册失败，跳转到注册页面
				response.sendRedirect("index.jsp");
			}
		}
	}

	private void queryUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, NoSuchAlgorithmException {
		// 设置request对象的编码方式
		request.setCharacterEncoding("utf-8");
		// 设置response对象的字符编码方式
		// resp.setCharacterEncoding("GBK");

		// 设置contenttype(同时设置MIME类型和字符集)
		response.setContentType("text/plain;charset=utf-8");

		// 获取输出流对象，向客户端写入数据
		PrintWriter out = response.getWriter();

		// 获取用户输入
		// 获取用户输入的员工编号
		int userId = Integer.parseInt(request.getParameter("userId"));
		// 获取用户输入的密码
		String userPass = MD5Algroithm.md("000000");

		// 获取用户输入的员工姓名
		String userName = request.getParameter("userName");
		// 获取用户的性别
		String gender = request.getParameter("gender");
		// 获取用户的在职状态
		String userState = request.getParameter("userState");
		// 获取用户的权限（0是管理员，1是普通用户）
		int root = Integer.parseInt(request.getParameter("root"));
		// 获取用户所在的部门
		String department = request.getParameter("department");
		// 获取用户的职位
		String job = request.getParameter("job");
		System.out.println("\n用户名：" + userName + ",用户密码：" + userPass + "，性别是：" + gender);

		// 创建User对象
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(userPass);
		user.setGender(gender);
		user.setRoot(root);
		user.setUserState(Integer.parseInt(userState));
		user.setDepartment(department);
		user.setJob(job);

		System.out.println(user);
		// 创建UserService对象
		UserService userService = UserServiceImpl.getInstance();

		if (userService.isExistUser(userId)) {
			// out.println("用户名已经存在不能注册");
			// 用户名已经存在，重新注册
			// 页面跳转（请求转发）
			request.getRequestDispatcher("addUser.html").forward(request, response);
		} else {
			// 调用注册方法
			boolean isRegisterSuccess = userService.register(user);

			System.out.println(isRegisterSuccess ? "注册成功" : "注册失败");

			// 向客户端浏览器输出注册结果
			// out.println(isRegisterSuccess ? "注册成功" : "注册失败");
			if (isRegisterSuccess) {
				// 注册成功，跳转到hello.html页面
				// 重定向
				response.sendRedirect("main.jsp");
				
			} else {
				
				// 注册失败，跳转到注册页面
				response.sendRedirect("index.jsp");
			}
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException {
		// 设置request作用域的字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取用户提交的用户名和密码
		int userId = Integer.valueOf(request.getParameter("userId"));
		String userPass = request.getParameter("userPass");

		UserService userService = UserServiceImpl.getInstance();
		// 调用方法实现登录功能
		// boolean isLoginSuccess = userService.login(userName, userPass);
		// 修改上面的代码，业务层的login方法返回User对象
		User user = userService.login(userId, MD5Algroithm.md(userPass));

		// 验证码是否正确
		// 先获取用户提交的验证码
		String validateCode = request.getParameter("validateCode");
		System.out.println("用户输入的验证码是：" + validateCode);

		// 获取服务器生成的验证码
		String serverValidateCode = (String) request.getSession().getAttribute("serverValidateCode");

		if (null != validateCode && null != serverValidateCode) {
			// 客户端提交的验证码和服务器一致
			if (!validateCode.equals(serverValidateCode)) {
				request.setAttribute("errorInfo", "验证码错误，请重新填写");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				// 判断登录是否成功
				if (user.getUserId() != 0) {
					// 设置用户的用户名
					// request.setAttribute("username", userName);
					// 将userName的值设置到范围更大的对象中，比如Session
					HttpSession sess = request.getSession();
					// 设置属性
					sess.setAttribute("username", userId);
					// 将当前User对象添加到session作用域中
					sess.setAttribute("user", user);

					// 如果登录成功跳转到首页
					request.getRequestDispatcher("main.jsp").forward(request, response);
				} else {
					// 设置错误信息
					request.setAttribute("errorInfo", "用户名或密码错误，请重新登录");
					// 登录不成功，重新登录
					request.getRequestDispatcher("index.jsp").forward(request, response);
					// response.sendRedirect("login.jsp");
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码x
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取客户端提交的数据
		String action = request.getParameter("action");
		try {
			if ("logout".equals(action)) {
				// 调用方法实现注销
				logout(request, response);
			} else if ("login".equals(action)) {
				login(request, response);
			} else if ("update".equals(action)) {
				updateUser(request, response);
			} else if ("showAllUser".equals(action)) {
				showAllUser(request, response);
			} else if ("delete".equals(action)) {
				deleteUser(request, response);
			} else if ("addUser".equals(action)) {
				addUser(request, response);
			} else if ("queryUser".equals(action)) {
				queryUser(request, response);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
