package com.neuedu.myWMS.service.impl;

import java.util.List;

import com.neuedu.myWMS.dao.ExceptionDao;
import com.neuedu.myWMS.dao.impl.ExceptionDaoImpl;
import com.neuedu.myWMS.service.ExceptionService;
import com.neuedu.myWMS.util.ErrorInfo;

public class ExceptionServiceImpl implements ExceptionService {

	private ExceptionDao exceptionDao = new ExceptionDaoImpl();
	
	private static ExceptionServiceImpl instance;
	
	private ExceptionServiceImpl(){};
	
	public static ExceptionServiceImpl getInstance(){
		if(null == instance){
			instance = new ExceptionServiceImpl();
		}
		return instance;
	}

	@Override
	public int addException(ErrorInfo exception) {
		return exceptionDao.insertException(exception);
	}

	@Override
	public ErrorInfo queryExceptionById(int exceptionId) {
		return exceptionDao.queryExceptionByExceptionId(exceptionId);
	}

	@Override
	public List<ErrorInfo> queryExceptionByCondition(String condition) {
		return exceptionDao.queryErrorInfoByCondition(condition);
	}

	@Override
	public int updateException(ErrorInfo exception) {
		return exceptionDao.updateException(exception);
	}
	
	
	
}
