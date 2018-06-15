package com.neuedu.myWMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.myWMS.service.OrderService;
import com.neuedu.myWMS.service.impl.OrderServiceImpl;
import com.neuedu.myWMS.util.Order;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SalesManagerServlet
 */
@WebServlet("/OrderManagerServlet")
public class OrderManagerServlet extends HttpServlet {
	
	private OrderService orderService = OrderServiceImpl.getInstance();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取action的值
		String action = request.getParameter("action");
		System.out.println("用户对于订单管理提交的action的值是：" + action);
		//根据action的值的不同进行不同的操作
		if("addOrder".equals(action)){
			AddOrder(request,response);
		} else if("preUpdate".equals(action)){
			preUpdate(request,response);
		} else if("updateOrder".equals(action)){
			updateOrder(request,response);
		} else if("showOrderInfoById".equals(action)){
			showOrderInfoById(request,response);
		} else if("queryOrderByCondition".equals(action)){
			queryOrderByCondition(request,response);
		}
	}

	private void queryOrderByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取用户提交的参数
		String orderId = request.getParameter("orderId");
		String orderType = request.getParameter("orderType");
		String goodsId = request.getParameter("goodsId");
		String orderOperator = request.getParameter("orderOperator");
		String documentMaker = request.getParameter("documentMaker");
		String orderDate = request.getParameter("orderDate");
		String condition = "where ";
		if("" != orderId){
			condition = "orderId=" + Integer.parseInt(orderId) + " and ";
		}
		if("" != orderType){
			condition += "orderType='" + orderType + "' and ";
		}
		if("" != goodsId){
			condition += "goodsId=" + goodsId + " and ";
		}
		if("" != orderOperator){
			condition += "orderOperator='" + orderOperator + "' and ";
		}
		if("" != documentMaker){
			condition += "documentMaker='" + documentMaker + "' and ";
		}
		if("" != orderDate){
			condition += "orderDate<=DATE_FORMAT('" + orderType + "','%Y-%m-%d') and ";
		}
		//去掉字符串最后一个and
		condition = condition.substring(0, condition.length()-4);
		System.out.println("condition:" + condition);
		//调用方法
		List<Order> orders = orderService.queryOrdersByCondition(condition);
		System.out.println(orders);
		String result = JSONArray.fromObject(orders).toString();
		response.getWriter().write(result);
	}

	private void showOrderInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取orderId
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		System.out.println("提交的订单的编号是：" + orderId);
		//调用方法
		if(null != orderService.queryOrderById(orderId)){
			//将查询到的order对象添加到request中去
			request.setAttribute("order", orderService.queryOrderById(orderId));
			request.getRequestDispatcher("showOrder.jsp").forward(request, response);
		} else {
			request.setAttribute("errorInfo", "没有对应编号的订单信息");
			request.getRequestDispatcher("queryOrder.jsp").forward(request, response);
		}
		
	}

	private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户输入的数据
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String orderType = request.getParameter("orderType");
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		int goodNumber = Integer.parseInt(request.getParameter("goodNumber"));
		String orderOperator = request.getParameter("orderOperator");
		String documentMaker = request.getParameter("documentMaker");
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		String orderDate = request.getParameter("orderDate");
		//创建一个order对象
		Order order = new Order(orderId,orderType,goodId,goodNumber,orderOperator,documentMaker,orderState,orderDate);
		if (1==orderService.updateOrder(order)) {
			request.setAttribute("orderId", orderId);
			request.getRequestDispatcher("resultOfAction.jsp").forward(request, response);
		} else {
			request.setAttribute("errorInfo", "订单修改失败");
			request.getRequestDispatcher("updateOrder.jsp").forward(request, response);
		}
	}

	private void preUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取orderId
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		System.out.println("提交的订单的编号是：" + orderId);
		Order order = orderService.queryOrderById(orderId);
		System.out.println("查询到的订单对象的信息是：" + order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("updateOrder.jsp").forward(request, response);
	}

	private void AddOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户输入的数据
		String orderType = request.getParameter("orderType");
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		int goodNumber = Integer.parseInt(request.getParameter("goodNumber"));
		String orderOperator = request.getParameter("orderOperator");
		String documentMaker = request.getParameter("documentMaker");
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		String orderDate = request.getParameter("orderDate");
		//创建一个order对象
		Order order = new Order(orderType,goodId,goodNumber,orderOperator,documentMaker,orderState,orderDate);
		//调用方法
		int orderId = orderService.insertOrder(order);
		//解析结果
		if(0 != orderId){
			request.setAttribute("orderId", orderId);
			request.setAttribute("orderType", orderType);
			request.setAttribute("goodNumber", goodNumber);
			request.getRequestDispatcher("addWareHouse.jsp").forward(request, response);
		} else {
			String errorInfo = "操作失败";
			request.setAttribute("errorInfo", errorInfo);
			request.getRequestDispatcher("addOrder.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	
}
