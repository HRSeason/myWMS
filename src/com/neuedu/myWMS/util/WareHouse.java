package com.neuedu.myWMS.util;

import java.io.Serializable;

/**
 * warehouse的工具类
 * @author 雨小陌童靴
 *
 */
public class WareHouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3618805182428074036L;

	//定义私有的变量，仓库订单编号
	private int wareHouseId;
	
	//定义私有的变量，货物编号
	private int goodId;
	
	//定义私有的变量，货物数量
	private int goodNumber;
	
	//定义私有的变量，订单状态（1表示入库，2表示出库）
	private int state;
	
	//定义私有的变量，订单理由（是由其他的订单产生的（这里是订单编号），还是借还货物或者是分配用品，（这里是经办人））
	private String reason;
	
	//定义私有的变量，仓库订单制单人
	private String manager;
	
	//定义私有的变量，仓库订单日期
	private String wareHorseDate;

	public WareHouse() {
		super();
	}

	public WareHouse(int wareHouseId, int goodId, int goodNumber, int state,
			String reason, String manager, String wareHorseDate) {
		super();
		this.wareHouseId = wareHouseId;
		this.goodId = goodId;
		this.goodNumber = goodNumber;
		this.state = state;
		this.reason = reason;
		this.manager = manager;
		this.wareHorseDate = wareHorseDate;
	}
	
	public WareHouse(int goodId, int goodNumber, int state,
			String reason, String manager, String wareHorseDate) {
		super();
		this.goodId = goodId;
		this.goodNumber = goodNumber;
		this.state = state;
		this.reason = reason;
		this.manager = manager;
		this.wareHorseDate = wareHorseDate;
	}

	public int getWareHouseId() {
		return wareHouseId;
	}

	public void setWareHouseId(int wareHouseId) {
		this.wareHouseId = wareHouseId;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getWareHorseDate() {
		return wareHorseDate;
	}

	public void setWareHorseDate(String wareHorseDate) {
		this.wareHorseDate = wareHorseDate;
	}

	@Override
	public String toString() {
		return "WareHouse [wareHouseId=" + wareHouseId + ", goodId=" + goodId
				+ ", goodNumber=" + goodNumber + ", state=" + state
				+ ", reason=" + reason + ", manager=" + manager
				+ ", wareHorseDate=" + wareHorseDate + "]";
	}
}
