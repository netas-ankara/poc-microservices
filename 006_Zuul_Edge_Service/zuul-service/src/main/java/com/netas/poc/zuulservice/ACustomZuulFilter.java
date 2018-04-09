package com.netas.poc.zuulservice;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.java.Log;

/**
 * https://github.com/Netflix/zuul/wiki/Writing-Filters
 */
@Log
public class ACustomZuulFilter extends ZuulFilter {

	/**
	 * There are three types of filter, before zuul routing, during zuul routing or after zuul routing
	 * Ex: If you want to add some headers to htpp response you can use after zuul routing type.
	 * @return A filter type
	 */
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	/**
	 * Logic for deciding the filter execution.
	 * @return boolean
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.info("The custom zuul filter has executed...");
		return null;
	}
}
