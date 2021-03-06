package com.learning.performancefilterdemo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

/**
 * Servlet Filter implementation class IP_Filter
 */
//@WebFilter("/IP_Filter")
public class IP_Filter implements Filter {

	FilterConfig config;
    /**
     * Default constructor. 
     */
    public IP_Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String receivedIP=config.getInitParameter("validIP").toString();
		String requestIP=request.getRemoteAddr().toString();
		System.out.println(requestIP);
		if(requestIP.equals(receivedIP))
		{
			chain.doFilter(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config=fConfig;
		// TODO Auto-generated method stub
	}

}
