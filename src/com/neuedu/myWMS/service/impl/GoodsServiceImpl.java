package com.neuedu.myWMS.service.impl;

import java.util.List;

import com.neuedu.myWMS.dao.GoodsDao;
import com.neuedu.myWMS.dao.impl.GoodsDaoImpl;
import com.neuedu.myWMS.service.GoodsService;
import com.neuedu.myWMS.util.Goods;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsDao = new GoodsDaoImpl();
	
	private static GoodsServiceImpl instance;
	
	private GoodsServiceImpl(){};
	
	public static GoodsServiceImpl getInstance(){
		if(null == instance){
			instance = new GoodsServiceImpl();
		}
		
		return instance;
	}

	@Override
	public int addGoods(Goods goods) {
		return goodsDao.insertGoods(goods);
	}

	@Override
	public Goods queryGoodsByGoodName(String goodName) {
		return goodsDao.queryGoodsByGoodName(goodName);
	}

	@Override
	public Goods queryGoodsByGoodId(int goodId) {
		return goodsDao.queryGoodsByGoodId(goodId);
	}

	@Override
	public List<Goods> queryGoodsByCondition(String condition) {
		return goodsDao.queryGoodsByCondition(condition);
	}

	@Override
	public int updateGoods(Goods good) {
		return goodsDao.updateGoods(good);
	}
	
	
	
	
}
