package com.winter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = "/*", filterName = "myFilter")
public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest requests, ServletResponse responses, FilterChain chain)
			throws IOException, ServletException {
		
		 // 设置：Access-Control-Allow-Origin头，处理Session问题
		HttpServletRequest request = (HttpServletRequest) requests;
		HttpServletResponse response = (HttpServletResponse) responses;
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("P3P", "CP=CAO PSA OUR");
        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods", "POST,GET,TRACE,OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
            response.addHeader("Access-Control-Max-Age", "120");
        }
        if(request.getHeader("Access-Control-Request-Headers") != null && "x-file-name".equals(request.getHeader("Access-Control-Request-Headers"))) {
        	response.addHeader("Access-Control-Allow-Headers", "x-file-name");
        }
//        long start = System.currentTimeMillis();
		  chain.doFilter(requests, responses);
//        System.out.println("MyFilter Execute cost=" + (System.currentTimeMillis() - start));		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
