package com.neuedu.myWMS.service;

import java.util.List;

import com.neuedu.myWMS.util.WareHouse;

public interface WareHouseService {

	/**
	 * 新增仓库订单
	 * @param wareHouse 仓库订单的对象
	 * @return 数据库中受影响的行数
	 */
	public int addWareHouse(WareHouse wareHouse);
	
	public List<WareHouse> queryWareHouseByCondition(String condition);
	
	public WareHouse queryWareHouseById(int wareHouseId);
	
	public int updateWareHouse(WareHouse wareHouse);
}
