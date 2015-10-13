package com.msds.util;   
/**
 * 创建时间：2014-10-10 上午11:55:46 
 * 项目名称：car_zone_base 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public interface ElementConverter<S, D> {
	D convert(S src);
}
  
