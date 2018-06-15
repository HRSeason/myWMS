package com.neuedu.myWMS.dao;

import java.util.List;

import com.neuedu.myWMS.util.WareHouse;

public interface WareHouseDao {
	
	/**
	 * 
	 * @param wareHouse:要添加的仓库对象
	 * @return:数据库中受影响的行数
	 */
	public int insertWareHouse(WareHouse wareHouse);
	
	/**
	 * 删除图书的方法
	 * @param wareHouseId:要删除的仓库编号
	 * @return:数据库中受影响的行数
	 */
	public int deleteWareHouse(int wareHouseId);
	/**
	 * 更新图书的方法
	 * @param wareHouse:要更新的仓库对象
	 * @return:数据库中受影响的行数
	 */
	public int updateWareHouse(WareHouse wareHouse);
	
	/**
	 * 根据用户编号查询用户对象
	 * @param wareHouseId:要删除的仓库编号
	 * @return:查询到的仓库信息
	 */
	public WareHouse queryWareHouseByWareHouseId(int wareHouseId);
	
	/**
	 * 查询所有用户对象
	 * @return:查询到的仓库信息
	 */
	public List<WareHouse> queryAllWareHouses();
	
	/**
	 * 根据条件查询
	 * @param condition 用户提交的需要查询的条件
	 * @return 根据条件查询到的仓库订单的信息
	 */
	public List<WareHouse> queryWareHouseByCondition(String condition);

}
