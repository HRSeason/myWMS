package com.neuedu.myWMS.service;

import java.util.List;

import com.neuedu.myWMS.util.Goods;

public interface GoodsService {
	
	//新增货物信息
	public int addGoods(Goods goods);
	
	/**
	 * 根据货物的名字查询货物信息
	 * @param goodName 需要查询的货物的名字
	 * @return 根据货物名字查询出来的列表对象
	 */
	public Goods queryGoodsByGoodName(String goodName);
	
	/**
	 * 根据货物编号查询货物信息
	 * @param goodId 需要查询的货物的编号
	 * @return 根据货物编号查询到的货物的信息
	 */
	public Goods queryGoodsByGoodId(int goodId);
	
	/**
	 * 根据条件查询
	 * @param condition 用户提交的查询条件
	 * @return 根据用户的条件查询到的商品信息
	 */
	public List<Goods> queryGoodsByCondition(String condition);

	/**
	 * 修改商品的方法
	 * @param good 修改后的商品的信息
	 * @return 数据库中受影响的行数
	 */
	public int updateGoods(Goods good);
}
