package com.msds.baseinfo.entity;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {
	@Override     
	protected Object determineCurrentLookupKey() {
		return CustomerContextHolder.getCustomerType();
	}
}
