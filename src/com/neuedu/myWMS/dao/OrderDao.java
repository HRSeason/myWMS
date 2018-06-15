package com.neuedu.myWMS.dao;

import java.util.List;

import com.neuedu.myWMS.util.Order;

public interface OrderDao {

	/**
	 * 添加商品的方法
	 * 
	 * @param order:要添加的商品对象
	 * @return:数据库中受影响的行数
	 */
	public int insertOrder(Order order);

	/**
	 * 删除商品的方法
	 * 
	 * @param orderId:要删除的商品编号
	 * @return:数据库中受影响的行数
	 */
	public int deleteOrder(int orderId);

	/**
	 * 更新商品的方法
	 * 
	 * @param order:要更新的商品对象
	 * @return:数据库中受影响的行数
	 */
	public int updateOrder(Order order);

	/**
	 * 根据商品编号查询商品对象
	 * 
	 * @param orderId:要删除的商品编号
	 * @return:查询到的商品信息
	 */
	public Order queryOrderByOrderId(int orderId);

	/**
	 * 查询所有商品对象
	 * 
	 * @return:查询到的商品信息
	 */
	public List<Order> queryAllOrders();
	
	/**
	 * 根据条件查询订单对象
	 * @param condition 用户提交的条件
	 * @return 根据条件查询到的订单对象的信息
	 */
	public List<Order> queryOrderByCondition(String condition);
}
