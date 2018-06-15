package com.neuedu.myWMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.myWMS.service.GoodsService;
import com.neuedu.myWMS.service.WareHouseService;
import com.neuedu.myWMS.service.impl.GoodsServiceImpl;
import com.neuedu.myWMS.service.impl.WareHouseServiceImpl;
import com.neuedu.myWMS.util.Goods;
import com.neuedu.myWMS.util.WareHouse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class WareHouseManagerServlet
 */
@WebServlet("/WareHouseManagerServlet")
public class WareHouseManagerServlet extends HttpServlet {
	
	private WareHouseService wareHouseService = WareHouseServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WareHouseManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("用户对于仓库管理提交的action的值是：" + action);
		//判断用户的操作进行不同的处理
		if("addWareHouse".equals(action)){
			AddWareHouse(request,response);
		} else if("preUpdate".equals(action)){
			preUpdate(request,response);
		} else if("updateWareHouse".equals(action)){
			updateWareHouse(request,response);
		} else if("showWareHouseInfoById".equals(action)){
			showWareHouseInfoById(request,response);
		} else if("queryWareHouseByCondition".equals(action)){
			queryWareHouseByCondition(request,response);
		}
	}

	private void queryWareHouseByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String wareHouseId = request.getParameter("wareHouseId");
		String goodsId = request.getParameter("goodsId");
		String reason = request.getParameter("reason");
		String manager = request.getParameter("manager");
		String holder = request.getParameter("holder");
		String wareHouseDate = request.getParameter("wareHouseDate");
		String condition = "where ";
		if("" != wareHouseId){
			condition = "wareHouseId=" + Integer.parseInt(wareHouseId) + " and ";
		}
		if("" != goodsId){
			condition +="goodsId=" + Integer.parseInt(goodsId) + " and ";
		}
		if("" != reason){
			condition += "reason=" + reason + " and ";
		}
		if("" != holder){
			condition += "holder=" + holder + " and ";
		}
		if("" != manager){
			condition += "manager=" + manager + " and ";
		}
		if("" != wareHouseDate){
			condition += "wareHouseDate<=DATE_FORMAT('" + wareHouseDate + "','%Y-%m-%d') and ";
		}
		//去掉字符串最后一个and
		condition = condition.substring(0, condition.length()-4);
		System.out.println("condition:" + condition);
		//调用方法
		List<WareHouse> wareHouses = wareHouseService.queryWareHouseByCondition(condition);
		System.out.println(wareHouses);
		String result = JSONArray.fromObject(wareHouses).toString();
		response.getWriter().write(result);
	}

	private void showWareHouseInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取值
		int wareHouseId = Integer.parseInt(request.getParameter("wareHouseId"));
		System.out.println("仓库订单的编号是：" + wareHouseId);
		if(null != wareHouseService.queryWareHouseById(wareHouseId)){
			request.setAttribute("wareHouse", wareHouseService.queryWareHouseById(wareHouseId));
			request.getRequestDispatcher("showWareHouse.jsp").forward(request, response);
		} else {
			request.setAttribute("errorInfo", "没有对应编号的仓库订单");
			request.getRequestDispatcher("queryWareHouse.jsp").forward(request, response);
		}
	}

	private void updateWareHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户提交的数据
		int wareHouseId = Integer.parseInt(request.getParameter("wareHouseId"));
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		int goodNumber = Integer.parseInt(request.getParameter("goodNumber"));
		String reason = request.getParameter("reason");
		String manager = request.getParameter("manager");
		int state = Integer.parseInt(request.getParameter("state"));
		String wareHouseDate = request.getParameter("wareHouseDate");
		//创建一个新的WareHouse对象
		WareHouse wareHouse = new WareHouse(wareHouseId,goodId,goodNumber,state,reason,manager,wareHouseDate);
		if(1 == wareHouseService.updateWareHouse(wareHouse)){
			request.setAttribute("wareHouseId", wareHouseId);
			request.getRequestDispatcher("resultOfAction.jsp").forward(request, response);
		} else {
			request.setAttribute("errorInfo", "修改失败");
			request.getRequestDispatcher("updateWareHouse.jsp").forward(request, response);
		}
	}

	private void preUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取值
		int wareHouseId = Integer.parseInt(request.getParameter("wareHouseId"));
		System.out.println("仓库订单的编号是：" + wareHouseId);
		WareHouse wareHouse = wareHouseService.queryWareHouseById(wareHouseId);
		System.out.println("您所查询的仓库订单的信息是：" + wareHouse);
		request.setAttribute("wareHouse", wareHouse);
		request.getRequestDispatcher("updateWareHouse.jsp").forward(request, response);
		
	}

	private void AddWareHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户提交的数据
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		int goodNumber = Integer.parseInt(request.getParameter("goodNumber"));
		String reason = request.getParameter("reason");
		String manager = request.getParameter("manager");
		int state = Integer.parseInt(request.getParameter("state"));
		String wareHouseDate = request.getParameter("wareHouseDate");
		//创建一个新的WareHouse对象
		WareHouse wareHouse = new WareHouse(goodId,goodNumber,state,reason,manager,wareHouseDate);
		//调用方法往数据库中插入数据
		int wareHouseId = wareHouseService.addWareHouse(wareHouse);
		//解析结果，跳转页面
		if(0 != wareHouseId){
			//修改货物表格
			GoodsService goodsService = GoodsServiceImpl.getInstance();
			Goods goods = goodsService.queryGoodsByGoodId(goodId);
			if(2==state){
				goods.setStockNumber(goods.getStockNumber() - goodNumber);
			} else if(1==state){
				goods.setStockNumber(goods.getStockNumber() + goodNumber);
			}
			if(1==goodsService.updateGoods(goods)){
				request.setAttribute("wareHouseId", wareHouseId);
				request.getRequestDispatcher("resultOfAction.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorInfo", "新增失败");
			request.getRequestDispatcher("addWareHouse.jsp").forward(request, response);
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
