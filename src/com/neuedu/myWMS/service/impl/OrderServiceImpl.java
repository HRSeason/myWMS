package com.neuedu.myWMS.service.impl;

import java.util.List;

import com.neuedu.myWMS.dao.OrderDao;
import com.neuedu.myWMS.dao.impl.OrderDaoImpl;
import com.neuedu.myWMS.service.OrderService;
import com.neuedu.myWMS.util.Order;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class OrderServiceImpl implements OrderService {

	//定义私有的构造方法
	private OrderDao orderDao = new OrderDaoImpl();
	
	private static OrderServiceImpl instance;
	
	private OrderServiceImpl(){};
	
	public static OrderServiceImpl getInstance(){
		if(null == instance){
			instance = new OrderServiceImpl();
		}
		return instance;
	}

	@Override
	public int insertOrder(Order order) {
		return orderDao.insertOrder(order);
	}

	@Override
	public Order queryOrderById(int orderId) {
		return orderDao.queryOrderByOrderId(orderId);
	}

	@Override
	public List<Order> queryOrdersByCondition(String condition) {
		return orderDao.queryOrderByCondition(condition);
	}

	@Override
	public int updateOrder(Order order) {
		return orderDao.updateOrder(order);
	}
	
	
	
}
