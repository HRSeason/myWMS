package com.neuedu.myWMS.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {

	//初始化filter
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init方法被调用，CharacterFilter对象正在被初始化......");
	}

	//过滤方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter方法被使用，正在使用过滤方法......");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain，UTF-8");
		response.setCharacterEncoding("UTF-8");
		//将传递下去
		chain.doFilter(request, response);
	}

	//销毁filter对象
	@Override
	public void destroy() {
		System.out.println("destroy方法被调用，CharacterFilter对象正在被销�?......");
	}

}
