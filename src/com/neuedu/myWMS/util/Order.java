package com.neuedu.myWMS.util;

/**
 * order表格的工具类
 * @author 雨小陌童靴
 *
 */
public class Order {
	
	//定义私有的变量,订单编号
	private int orderId;
	
	//定义私有的变量，订单类型（销售订单是S，采购订单是B，退货订单是R）
	private String orderType;
	
	//定义私有的变量,货物编号
	private int goodId;
	
	//定义私有的变量,货物数量
	private int goodNumber;
	
	//定义私有的变量,订单经办人（具体的销售人员、采购人员等）
	private String orderOperator;
	
	//定义私有的变量,制单人（新增订单的仓库管理人员，修改订单为往后追加）
	private String  documentMaker;
	
	//定义私有的变量,订单状态（已完成状态是0，取消状态是1）   
	private int orderState;
	
	//定义私有的变量,订单日期（输入类型是字符串类型）   
	private String orderDate;

	public Order() {
		super();
	}

	

	public Order(int orderId, String orderType, int goodId, int goodNumber, String orderOperator, String documentMaker,
			int orderState, String orderDate) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.goodId = goodId;
		this.goodNumber = goodNumber;
		this.orderOperator = orderOperator;
		this.documentMaker = documentMaker;
		this.orderState = orderState;
		this.orderDate = orderDate;
	}

	public Order(String orderType, int goodId, int goodNumber, String orderOperator, String documentMaker,
			int orderState, String orderDate) {
		super();
		this.orderType = orderType;
		this.goodId = goodId;
		this.goodNumber = goodNumber;
		this.orderOperator = orderOperator;
		this.documentMaker = documentMaker;
		this.orderState = orderState;
		this.orderDate = orderDate;
	}

	public String getOrderType() {
		return orderType;
	}



	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getOrderId() {
		return orderId;
	}



	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getGoodNumber() {
		return goodNumber;
	}

	public void setGoodNumber(int goodNumber) {
		this.goodNumber = goodNumber;
	}

	public String getOrderOperator() {
		return orderOperator;
	}

	public void setOrderOperator(String orderOperator) {
		this.orderOperator = orderOperator;
	}

	public String getDocumentMaker() {
		return documentMaker;
	}

	public void setDocumentMaker(String documentMaker) {
		this.documentMaker = documentMaker;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}



	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderType=" + orderType + ", goodId=" + goodId + ", goodNumber="
				+ goodNumber + ", orderOperator=" + orderOperator + ", documentMaker=" + documentMaker + ", orderState="
				+ orderState + ", orderDate=" + orderDate + "]";
	}
	
	


}
