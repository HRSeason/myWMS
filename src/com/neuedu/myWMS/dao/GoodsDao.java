package com.neuedu.myWMS.dao;

import java.util.List;

import com.neuedu.myWMS.util.Goods;

public interface GoodsDao {
	/**
	 * 添加商品的方法
	 * @param goods:要添加的商品对象
	 * @return:数据库中受影响的行数
	 */
	public int insertGoods(Goods goods);
	
	/**
	 * 删除商品的方法
	 * @param goodId:要删除的商品编号
	 * @return:数据库中受影响的行数
	 */
	public int deleteGoods(int goodId);
	/**
	 * 更新商品的方法
	 * @param user:要更新的商品对象
	 * @return:数据库中受影响的行数
	 */
	public int updateGoods(Goods goods);
	
	/**
	 * 根据商品编号查询商品对象
	 * @param goodId:要查询的商品编号
	 * @return:查询到的商品信息
	 */
	public Goods queryGoodsByGoodId(int goodId);
	
	/**
	 * 根据商品名称查询商品对象的信息
	 * @param goodName 需要查询的商品名称
	 * @return 查询到的商品信息
	 */
	public Goods queryGoodsByGoodName(String goodName);
	
	/**
	 * 查询所有商品对象
	 * @return:查询到的商品信息
	 */
	public List<Goods> queryAllGoods();
	
	/**
	 * 根据条件查询
	 * @param condition 查询的条件
	 * @return 根据查询的条件查询到的商品对象的信息
	 */
	public List<Goods> queryGoodsByCondition(String condition);


}
