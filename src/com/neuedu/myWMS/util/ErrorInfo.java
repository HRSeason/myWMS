package com.neuedu.myWMS.util;

import java.io.Serializable;

/**
 * exception表格的工具类
 * @author 雨小陌童靴
 *
 */
public class ErrorInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1949967423037821276L;

	//定义私有的变量，异常情况编号
	private int exceptionId;
	
	//定义私有的变量，异常情况报告人
	private String reporter;
	
	//定义私有的变量，异常情况信息
	private String situation;
	
	//定义私有的变量，异常情况报告日期
	private String reportDate;
	
	//定义私有的变量，异常情况处理人
	private String holder;
	
	//定义私有的变量，异常情况处理结果
	private String exceptionResult;
	
	//定义私有的变量，异常情况处理日期
	private String resultDate;

	public ErrorInfo() {
		super();
	}

	public ErrorInfo(int exceptionId, String reporter, String situation,
			String reportDate, String holder, String exceptionResult,
			String resultDate) {
		super();
		this.exceptionId = exceptionId;
		this.reporter = reporter;
		this.situation = situation;
		this.reportDate = reportDate;
		this.holder = holder;
		this.exceptionResult = exceptionResult;
		this.resultDate = resultDate;
	}

	public ErrorInfo( String reporter, String situation,
			String reportDate, String holder, String exceptionResult,
			String resultDate) {
		super();
		this.reporter = reporter;
		this.situation = situation;
		this.reportDate = reportDate;
		this.holder = holder;
		this.exceptionResult = exceptionResult;
		this.resultDate = resultDate;
	}
	
	public int getExceptionId() {
		return exceptionId;
	}

	public void setExceptionId(int exceptionId) {
		this.exceptionId = exceptionId;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getExceptionResult() {
		return exceptionResult;
	}

	public void setExceptionResult(String exceptionResult) {
		this.exceptionResult = exceptionResult;
	}

	public String getResultDate() {
		return resultDate;
	}

	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}

	@Override
	public String toString() {
		return "Exception [exceptionId=" + exceptionId + ", reporter="
				+ reporter + ", situation=" + situation + ", reportDate="
				+ reportDate + ", holder=" + holder + ", exceptionResult="
				+ exceptionResult + ", resultDate=" + resultDate + "]";
	}
	
	
}
