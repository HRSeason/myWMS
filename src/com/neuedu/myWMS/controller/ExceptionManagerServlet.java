package com.neuedu.myWMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.myWMS.service.ExceptionService;
import com.neuedu.myWMS.service.impl.ExceptionServiceImpl;
import com.neuedu.myWMS.util.ErrorInfo;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class PurchaseManagerServlet
 */
@WebServlet("/ExceptionManagerServlet")
public class ExceptionManagerServlet extends HttpServlet {
	
	private ExceptionService exceptionService = ExceptionServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExceptionManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户提交的action
		String action = request.getParameter("action");
		System.out.println("用户提交的操作是：" + action);
		if("addException".equals(action)){
			addException(request,response);
		} else if("showExceptionInfoById".equals(action)){
			showExceptionInfoById(request,response);
		} else if("queryExceptionByCondition".equals(action)){
			queryExceptionByCondition(request,response);
		} else if("preUpdate".equals(action)){
			preUpdate(request,response);
		} else if("updateException".equals(action)){
			updateException(request,response);
		}
	}

	private void updateException(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户的相关信息
		int exceptionId = Integer.parseInt(request.getParameter("exceptionId"));
		String reporter = request.getParameter("reporter");
		String situation = request.getParameter("situation");
		String holder = request.getParameter("holder");
		String exceptionResult = request.getParameter("exceptionResult");
		String reportDate = request.getParameter("reportDate");
		String resultDate = request.getParameter("resultDate");
		ErrorInfo exceptionInfo = new ErrorInfo(exceptionId,reporter,situation,holder,exceptionResult,reportDate,resultDate);
		int result = exceptionService.updateException(exceptionInfo);
		if(1 == result){
			request.setAttribute("exceptionId", exceptionId);
			request.getRequestDispatcher("resultOfAction.jsp").forward(request, response);
		} else {
			request.setAttribute("errorInfo", "修改失败");
			request.getRequestDispatcher("updateExceptionInfo.jsp").forward(request, response);
		}
	}

	private void preUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int exceptionId = Integer.parseInt(request.getParameter("exceptionId"));
		System.out.println("用户提交的异常编号是：" + exceptionId);
		ErrorInfo exceptionInfo = exceptionService.queryExceptionById(exceptionId);
		request.setAttribute("exceptionInfo", exceptionInfo);
		request.getRequestDispatcher("updateExceptionInfo.jsp").forward(request, response);
	}

	private void queryExceptionByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取用户的参数
		String exceptionId = request.getParameter("exceptionId");
		String reporter = request.getParameter("reporter");
		String holder = request.getParameter("holder");
		String reportDate = request.getParameter("reportDate");
		String resultDate = request.getParameter("resultDate");
		String condition = "where ";
		if("" != exceptionId){
			condition = "exceptionId=" + Integer.parseInt(exceptionId) + " and ";
		} else if ("" != reporter){
			condition += "reporter='" + reporter + "' and ";
		} else if ("" != holder){
			condition += "holder='" + holder + "' and ";
		} else if ("" != reportDate){
			condition += "reportDate<=DATE_FORMAT('" + reportDate + "','%Y-%m-%d') and ";
		} else if ("" != resultDate){
			condition += "resultDate<=DATE_FORMAT('" + resultDate + "','%Y-%m-%d') and ";
		}
		//去掉字符串最后一个and
		condition = condition.substring(0, condition.length()-4);
		System.out.println("condition:" + condition);
		List<ErrorInfo> exceptionInfos = exceptionService.queryExceptionByCondition(condition);
		System.out.println(exceptionInfos);
		String result = JSONArray.fromObject(exceptionInfos).toString();
		response.getWriter().write(result);	
	}

	private void showExceptionInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取提交的exceptionId
		int exceptionId = Integer.parseInt(request.getParameter("exceptionId"));
		System.out.println("用户提交的异常编号是：" + exceptionId);
		ErrorInfo exceptionInfo = exceptionService.queryExceptionById(exceptionId);
		if(null != exceptionInfo){
			request.setAttribute("exceptionInfo", exceptionInfo);
			request.getRequestDispatcher("showExceptionInfo.jsp").forward(request, response);			
		} else {
			request.setAttribute("errorInfo", "没有该编号对应的异常信息");
			request.getRequestDispatcher("queryExceptionInfo.jsp").forward(request, response);	
		}

	}

	private void addException(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户的参数
		String reporter = request.getParameter("reporter");
		String situation = request.getParameter("exceptionSituation");
		String holder = request.getParameter("holder");
		String exceptionResult = request.getParameter("exceptionResult");
		String reportDate = request.getParameter("reportDate");
		String resultDate = request.getParameter("resultDate");
		//创建exception对象
		ErrorInfo exception = new ErrorInfo(reporter,situation,holder,exceptionResult,reportDate,resultDate);
		//调用方法
		int exceptionId = exceptionService.addException(exception);
		if(0!= exceptionId){
			request.setAttribute("exceptionId", exceptionId);
			request.getRequestDispatcher("resultOfAction.jsp").forward(request, response);
		} else {
			request.setAttribute("errorInfo", "异常信息添加失败");
			request.getRequestDispatcher("addExceptionInfo.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}
