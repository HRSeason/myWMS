package com.neuedu.myWMS.service;

import java.util.List;

import com.neuedu.myWMS.util.Order;

public interface OrderService {

	//新增一个order信息
	public int insertOrder(Order order);
	
	/**
	 * 根据订单编号查询订单信息
	 * @param orderId 需要查询的订单编号
	 * @return 需要查询的订单的信息
	 */
	public Order queryOrderById(int orderId);
	
	/**
	 * 根据用户的条件查询
	 * @param Condition 用户提交的条件
	 * @return 查到的信息
	 */
	public List<Order> queryOrdersByCondition(String condition);
	
	/**
	 * 修改订单对象
	 * @param order 修改的订单对象的信息
	 * @return 数据库中受影响的行数
	 */
	public int updateOrder(Order order);
}
