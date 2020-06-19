package com.learning.filterdemo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ProcessFilter2
 */
@WebFilter("/ProcessData")
public class ProcessFilter2 implements Filter {

    /**
     * Default constructor. 
     */
    public ProcessFilter2() {
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
		System.out.println("request received in doFilter from ProcessFilter2..passing it to next element in chain");
		chain.doFilter(request, response);
		System.out.println("response received in doFilter in ProcessFilter2");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("ProcessFilter2 Filter initialized");
	}

}
