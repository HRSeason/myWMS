package com.neuedu.myWMS.service;

import java.util.List;

import com.neuedu.myWMS.util.ErrorInfo;

public interface ExceptionService {
	
	public int addException(ErrorInfo exception);

	public ErrorInfo queryExceptionById(int exceptionId);
	
	public List<ErrorInfo> queryExceptionByCondition(String condition);
	
	public int updateException(ErrorInfo exception);
}
