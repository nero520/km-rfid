package com.msds.baseinfo.entity;

public class CustomerContextHolder {
	 
    public final static String SESSION_FACTORY_MYSQL = "mysql";
    public final static String SESSION_FACTORY_ORACLE = "oracle";
    
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
    
    public static void setCustomerType(String customerType) {
    	contextHolder.set(customerType);
    }  
    
    public static String getCustomerType() {           
    	return contextHolder.get();       
    }             
    
    public static void clearCustomerType() {
    	contextHolder.remove();
    }  
}

