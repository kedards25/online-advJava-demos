package com.learning.performancefilterdemo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.sun.org.apache.bcel.internal.generic.DCONST;

/**
 * Servlet Filter implementation class PerformanceFilter
 */
//@WebFilter("/ProcessData")
public class PerformanceFilter implements Filter {

	FilterConfig config;
    /**
     * Default constructor. 
     */
    public PerformanceFilter() {
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
		
		long requestTime=System.currentTimeMillis();
		chain.doFilter(request, response);
		long responseTime=System.currentTimeMillis();
		
		long performanceTime=responseTime-requestTime;
		
		//time taken will be logged in context of servlet which the filter is configured for
		//config.getServletContext().log("Time taken: "+performanceTime);
		System.out.println("Time taken "+performanceTime+" millis");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		config=fConfig;
	}

}
