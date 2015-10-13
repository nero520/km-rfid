package com.msds.km.util;   

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.msds.enums.DescriptionEnum;
import com.msds.km.enums.ActivityStateEnum;
import com.msds.km.enums.BespeakStateEnum;
import com.msds.km.enums.BillStateEnum;
import com.msds.km.enums.BillTypeEnum;
import com.msds.km.enums.OrderStateEnum;
import com.msds.km.enums.PrizeCordStateEnum;
import com.msds.km.enums.RefundStateEnum;
import com.msds.km.enums.SettleStateEnum;

/**
 * 创建时间：2014-9-28 下午4:59:21 
 * 项目名称：car_zone_base 
 * @author lizhe  
 * @version 1.0   
 * @since JDK 1.6.0_21  
 */
public class EnumUtil {
	private static Map<String,Class> jsVariableMap = new HashMap<String,Class>();
	private static String jsVariableString = "";
	
	static {
		//如果需要新增枚举，则只需要在此处加入即可，jsVariableMap 中key为页面js变量名。
		//注意：新增的枚举需要实现DescriptionEnum，并且必须有static getValues方法。
		jsVariableMap.put("refundState", RefundStateEnum.class);
		jsVariableMap.put("orderState", OrderStateEnum.class);
		jsVariableMap.put("settleState", SettleStateEnum.class);
		jsVariableMap.put("billState", BillStateEnum.class);
		jsVariableMap.put("billingType", BillTypeEnum.class);
		jsVariableMap.put("bespeakState", BespeakStateEnum.class);
		jsVariableMap.put("activityState", ActivityStateEnum.class);
		jsVariableMap.put("prizeCordState", PrizeCordStateEnum.class);
		
		makeJsVariableString();
	}
	
	public static void makeJsVariableString(){
		StringBuilder allSb = new StringBuilder();
		for(Map.Entry<String, Class> entry : jsVariableMap.entrySet() ){
			String key = entry.getKey();
			Class clz = entry.getValue();
			try {
				List<DescriptionEnum> list = (List<DescriptionEnum>)clz.getDeclaredMethod("getValues", null).invoke(clz, null);
				StringBuilder sb = new StringBuilder("var " +key+ "=[");
				StringBuilder sbSelect = new StringBuilder("var " +key+ "Select=[");
				sbSelect.append("{\"id\" : '',\"text\" : '全部'},");
				int i = 0;
				for(DescriptionEnum ds : list){
					sb.append("{\"id\" : " +ds.getId()+ ",\"text\" : '"+ds.getName().trim()+"'}");
					sbSelect.append("{\"id\" : " +ds.getId()+ ",\"text\" : '"+ds.getName().trim()+"'}");
					if(i < (list.size()-1)){
						sb.append(",");
						sbSelect.append(",");
					}
					i++;
				}
				sb.append("];\r\n");
				sbSelect.append("];\r\n");
				allSb.append(sb);
				allSb.append(sbSelect);
//				System.out.println(sb);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			
		}
		jsVariableString = allSb.toString();
	}
	
	public static String getJsVariableString(){
		return jsVariableString;
	}
	
	
	/**
	 * 根据枚举id获取name
	 * @param id 枚举id
	 * @param enumClassName 枚举类名
	 * @return
	 */
	public static String getEnumName(Integer id, String className){
		if(StringUtils.isEmpty(className) || id == null) {
			return "";
		}
		String name = "";
		try {
			Class<DescriptionEnum> clz = (Class<DescriptionEnum>) Class.forName("com.msds.km.enums."+className);
			Method getMethod = clz.getMethod("getEnumById", int.class);//getEnumById
			Object value = getMethod.invoke(clz,id.intValue());
			if(null == value) {
				return "";
			}
			name = ((DescriptionEnum)value).getName();	
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public static void main(String[] args) {
		makeJsVariableString();
	}
}
  
