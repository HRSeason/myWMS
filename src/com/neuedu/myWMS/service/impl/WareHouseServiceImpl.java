package com.neuedu.myWMS.service.impl;

import java.util.List;

import com.neuedu.myWMS.dao.WareHouseDao;
import com.neuedu.myWMS.dao.impl.WareHouseDaoImpl;
import com.neuedu.myWMS.service.WareHouseService;
import com.neuedu.myWMS.util.WareHouse;

public class WareHouseServiceImpl implements WareHouseService {

	private WareHouseDao wareHouseDao = new WareHouseDaoImpl();
	
	private static WareHouseServiceImpl instance;
	
	private WareHouseServiceImpl(){};
	
	public static WareHouseServiceImpl getInstance(){
		if(null == instance){
			instance = new WareHouseServiceImpl();
		}
		return instance;
	}

	@Override
	public int addWareHouse(WareHouse wareHouse) {
		return wareHouseDao.insertWareHouse(wareHouse);
	}

	@Override
	public List<WareHouse> queryWareHouseByCondition(String condition) {
		return wareHouseDao.queryWareHouseByCondition(condition);
	}

	@Override
	public WareHouse queryWareHouseById(int wareHouseId) {
		return wareHouseDao.queryWareHouseByWareHouseId(wareHouseId);
	}

	@Override
	public int updateWareHouse(WareHouse wareHouse) {
		return wareHouseDao.updateWareHouse(wareHouse);
	}
	
	
	
}
