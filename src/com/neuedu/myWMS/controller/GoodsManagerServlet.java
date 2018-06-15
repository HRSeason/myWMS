package com.neuedu.myWMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.myWMS.service.GoodsService;
import com.neuedu.myWMS.service.impl.GoodsServiceImpl;
import com.neuedu.myWMS.util.Goods;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsManagerServlet")
public class GoodsManagerServlet extends HttpServlet {
	
	private GoodsService goodsService = GoodsServiceImpl.getInstance();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsManagerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取action的值
		String action = request.getParameter("action");
		System.out.println("用户对于货物管理提交的action的值是：" + action);
		//根据action的值进行不同的操作
		if("addGoods".equals(action)){
			addGoods(request,response);
		} else if("preUpdate".equals(action)){
			preUpdate(request,response);
		} else if("updateGoods".equals(action)){
			updateGoods(request,response);
		} else if("showGoodInfoById".equals(action)){
			showGoodInfoById(request,response);
		} else if("queryGoodsByCondition".equals(action)){
			queryGoodsByCondition(request,response);
		} 
	}

	private void preUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取goodId
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		System.out.println("货物的编号是：" + goodId);
		//调用方法
		Goods good = goodsService.queryGoodsByGoodId(goodId);
		System.out.println("所查询的商品信息是：" + good);
		request.setAttribute("good", good);
		request.getRequestDispatcher("updateGoods.jsp").forward(request, response);	
	}


	private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户提交的数据
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		String goodName = request.getParameter("goodName");
		int stockNumber = Integer.parseInt(request.getParameter("stockNumber"));
		String location = request.getParameter("locationwarehouse") + "-" + request.getParameter("locationdepart") + "-" 
							+ request.getParameter("locationfloor") + "-" + request.getParameter("locationdetal");
		String goodType = request.getParameter("goodType");
		Goods good = new Goods(goodId,goodName,stockNumber,location,goodType);
		//调用方法
		int result = goodsService.updateGoods(good);
		if(result == 1){
			request.setAttribute("goodId", goodId);
			request.getRequestDispatcher("resultOfAction.jsp").forward(request, response);
		} else {
			request.setAttribute("errorInfo", "修改失败");
			request.getRequestDispatcher("updateGoods.jsp").forward(request, response);
		}
	}
	
	private void queryGoodsByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取用户的参数
		String goodId = request.getParameter("goodId");
		String goodName = request.getParameter("goodName");
		String goodType = request.getParameter("goodType");
		System.out.println("goodId=" + goodId + "goodName=" + goodName + "goodType=" + goodType);
		String condition = "where ";
		if("" != goodId){
			condition = "goodId =" + Integer.parseInt(goodId) + " and ";
		}
		if("" != goodName){
			condition +="goodName like '%" + goodName + "%' and ";
		}
		if("" != goodType){
			condition +="goodType like '%" + goodType + "%' and ";
		}
		//去掉字符串最后一个and
		condition = condition.substring(0, condition.length()-4);
		System.out.println("condition:" + condition);
		//调用方法
		List<Goods> goods= goodsService.queryGoodsByCondition(condition);
		String result = JSONArray.fromObject(goods).toString();
		response.getWriter().write(result);
	}

	//查询商品
	private void showGoodInfoById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取goodId
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		System.out.println("货物的编号是：" + goodId);
		//调用方法
		if(null != goodsService.queryGoodsByGoodId(goodId)){
			//将查询到的good对象添加到request中去
			request.setAttribute("good", goodsService.queryGoodsByGoodId(goodId));
			//跳转到页面
			request.getRequestDispatcher("showGoods.jsp").forward(request, response);
		} else {
			//添加错误信息
			request.setAttribute("errorInfo", "没有对应货物编号的货物");
			request.getRequestDispatcher("queryGoods.jsp").forward(request, response);
		}
	}

	//新增商品
	private void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台客户输入的数据
		String goodName = request.getParameter("goodName");
		int stockNumber = Integer.parseInt(request.getParameter("stockNumber"));
		String location = request.getParameter("locationwarehouse") + "-" + request.getParameter("locationdepart") + "-" 
							+ request.getParameter("locationfloor") + "-" + request.getParameter("locationdetal");
		String goodType = request.getParameter("goodType");
		System.out.println("用户需要添加的商品名称是：" + goodName);
		if(null == goodsService.queryGoodsByGoodName(goodName)){
			Goods good = new Goods();
			good.setGoodName(goodName);
			good.setGoodType(goodType);
			good.setLocation(location);
			good.setStockNumber(stockNumber);
			//调用方法
			int goodId = goodsService.addGoods(good);
			//判断结果
			if(0 != goodId){
				request.setAttribute("goodId", goodId);
				request.getRequestDispatcher("resultOfAction.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("addInfo", "该商品已经存在，无需添加");
			request.setAttribute("good", goodsService.queryGoodsByGoodName(goodName));
			request.getRequestDispatcher("addGoods.jsp").forward(request, response);
		}
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
