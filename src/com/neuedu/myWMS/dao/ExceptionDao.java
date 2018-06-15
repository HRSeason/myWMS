package com.neuedu.myWMS.dao;

import java.util.List;

import com.neuedu.myWMS.util.ErrorInfo;

public interface ExceptionDao {

	/**
	 * 添加商品的方法
	 * 
	 * @param exception:要添加的异常对象
	 * @return:数据库中受影响的行数
	 */
	public int insertException(ErrorInfo exception);

	/**
	 * 删除商品的方法
	 * 
	 * @param exceptionId:要删除的异常编号
	 * @return:数据库中受影响的行数
	 */
	public int deleteException(int exceptionId);

	/**
	 * 更新商品的方法
	 * 
	 * @param exception:要更新的异常对象
	 * @return:数据库中受影响的行数
	 */
	public int updateException(ErrorInfo exception);

	/**
	 * 根据商品编号查询商品对象
	 * 
	 * @param exceptionId:要删除的异常编号
	 * @return:查询到的异常信息
	 */
	public ErrorInfo queryExceptionByExceptionId(int exceptionId);

	/**
	 * 查询所有商品对象
	 * 
	 * @return:查询到的异常信息
	 */
	public List<ErrorInfo> queryAllExceptions();
	
	/**
	 * 根据条件查询异常信息
	 * @param condition 用户提交的条件
	 * @return 根据用户提交的条件查询到的异常对象的信息
	 */
	public List<ErrorInfo> queryErrorInfoByCondition(String condition);

}
