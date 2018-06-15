package com.neuedu.myWMS.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.java2d.loops.DrawLine;

/**
 * Servlet implementation class ValidateCodeServlet
 */
@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	//定义验证码的宽度和高度
	private static final int WIDTH = 120;
	private static final int HEIGHT = 30;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//构建图片
		BufferedImage image = new BufferedImage(
				WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		//构建画图对象
		Graphics graphics = image.getGraphics();
		
		//画背景
		setBackground(graphics);
		//画边框
		setBorder(graphics);
		//画干扰线
		drawLine(graphics);
		//获取验证码并画随机数
		String validateCode = drawNumber(graphics);
		//将验证码添加到作用域中
		request.getSession().setAttribute("serverValidateCode", validateCode);
		
		//生成图片并返回给客户端
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	//生成验证码
	private String drawNumber(Graphics graphics) {
		//定义返回的验证码
		StringBuffer validateCode = new StringBuffer();
		//设置验证码的颜色
		Color color = new Color(144, 122, 123);
		//设置干扰线的颜色
		graphics.setColor(color);
		//设置文本字体
		graphics.setFont(new Font("宋体", Font.ITALIC, 20));
		
		//第一位验证码的开始位置（x方向）
		int x = 10;
		
		for(int i = 0; i < 6; i++) {
			//生成随机数，并绘制
			String random = new Random().nextInt(10) + "";
			graphics.drawString(random, x, 20);
			//修改x方向的偏移
			x += 18;
			validateCode.append(random);
		}
		
		//返回验证码
		return validateCode.toString();
	}

	//画随机干扰线
	private void drawLine(Graphics graphics) {
		//创建Color对象
		Color color = new Color(192, 251, 206);
		//设置干扰线的颜色
		graphics.setColor(color);
		
		//画干扰线
		for(int i = 0; i < 8; i++) {
			//起点坐标
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			
			//终点坐标
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			
			//根据生成的坐标画干扰线
			graphics.drawLine(x1, y1, x2, y2);
		}
	}

	//画背景
	private void setBackground(Graphics graphics) {
		//创建Color对象
		Color color = new Color(203, 200, 244);
		//设置背景颜色
		graphics.setColor(color);
		//填充背景
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
	}

	//画边框
	private void setBorder(Graphics graphics) {
		//给边框设置颜色
		graphics.setColor(Color.ORANGE);
		//绘制矩形边框
		graphics.drawRect(1, 1, WIDTH-2 , HEIGHT-2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
