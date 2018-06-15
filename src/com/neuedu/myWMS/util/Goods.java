package com.neuedu.myWMS.util;

import java.io.Serializable;

/**
 * good表格的工具类
 * @author 雨小陌童靴
 *
 */
public class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -834135654489478081L;

	//定义私有的变量，货物编号
	private int goodId;
	
	//定义私有的变量，货物名称
	private String goodName;
	
	//定义私有的变量，货物库存数量
	private int stockNumber;
	
	//定义私有的变量，货物存放位置
	private String location;
	
	//定义私有的变量，货物种类（销售货物、日常使用、特殊商品etc）
	private String goodType;

	public Goods(int goodId, String goodName, int stockNumber, String location,
			String goodType) {
		super();
		this.goodId = goodId;
		this.goodName = goodName;
		this.stockNumber = stockNumber;
		this.location = location;
		this.goodType = goodType;
	}
	
	public Goods(String goodName, int stockNumber, String location,
			String goodType) {
		super();
		this.goodName = goodName;
		this.stockNumber = stockNumber;
		this.location = location;
		this.goodType = goodType;
	}

	public Goods() {
		super();
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	@Override
	public String toString() {
		return "Good [goodId=" + goodId + ", goodName=" + goodName
				+ ", stockNumber=" + stockNumber + ", location=" + location
				+ ", goodType=" + goodType + "]";
	}
}
