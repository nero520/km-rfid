package com.msds.util;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

/**
 *  极光推送
  	Code	描述		详细解释		HTTPStatusCode
	1000	系统内部错误	服务器端内部逻辑错误，请稍后重试。	500
	1001	只支持 HTTP Post 方法	不支持 Get 方法。	405
	1002	缺少了必须的参数	必须改正	400
	1003	参数值不合法	必须改正	400
	1004	验证失败	必须改正。详情请看：调用验证	401
	1005	消息体太大	必须改正。 Android平台Notification+Message长度限制为1000字节； iOS Notification 中 “iOS”:{ } 及大括号内的总体长度不超过：2000个字节（包括自定义参数和符号），iOS 的 Message部分长度不超过 1000 字节； WinPhone平台Notification长度限制为1000字节	400
	1008	app_key参数非法	必须改正	400
	1011	没有满足条件的推送目标	请检查audience	400
	1020	只支持 HTTPS 请求	必须改正	404
	1030	内部服务超时	稍后重试
 * @author hebiao
 *
 */
public class JPushManager {

    protected static final Logger LOG = LoggerFactory.getLogger(JPushManager.class);
	private static final ResourceBundle bundle = ResourceBundle.getBundle("baseconfig");
	
	private  static String appKey="0b47575d4803db6586fda269" ;
	private  static String masterSecret="209c65231dce7bea7590679b";
	
	private static final JPushManager jPushManager = new JPushManager();	
    private static JPushClient jpushClient;

    private JPushManager(){
    	init();
    }
    
	public static JPushManager getInstance() {
		return SingletonHolder.instance;
	}
	
	private static class SingletonHolder{
		private static JPushManager instance = new JPushManager();	
	}
    
    protected void init() {
    	if(null == jPushManager){
    		jpushClient = new JPushClient(getMasterSecret(), getAppKey(), 3);
    	}
    }

    /**
     * 对所有设备推送所有平台
     * @param alert 通知内容
     * @return
     */
	public PushResult pushAll(String alert) {
		if(StringUtils.isEmpty(alert)){
			return null;
		}
		
        PushPayload payload = PushPayload.alertAll(alert);
        return commonPush(payload);
	}

	/**
	 * 对指定注册ID推送信息到所有平台
	 * @param alert  通知内容
	 * @param ids 注册ID	数组。多个注册ID之间是 OR 关系，即取并集。	设备标识。一次推送最多 1000 个。
	 * @return
	 */
	public PushResult pushToRegistrationId(String alert, String... ids){

		PushPayload payload = PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.registrationId(ids))
				.setOptions(Options.newBuilder().setTimeToLive(86400).build())
				.setNotification(Notification.alert(alert)).build();
        return commonPush(payload);
	}
	
	/**
	 *  对指定别名数组推送信息到所有平台
	 * @param alert
	 * @param aliases	别名	数组。多个别名之间是 OR 关系，即取并集。	用别名来标识一个用户。一个设备只能绑定一个别名，但多个设备可以绑定同一个别名。一次推送最多 1000 个。
						有效的 alias 组成：字母（区分大小写）、数字、下划线、汉字。
						限制：每一个 tag 的长度限制为 40 字节。（判断长度需采用UTF-8编码）
	 * @return
	 */
	public PushResult pushToAlias(String alert, String... aliases){

		PushPayload payload = PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.alias(aliases))
				.setNotification(Notification.alert(alert))
				.setOptions(Options.newBuilder().setTimeToLive(86400).build())
				.build();
        return commonPush(payload);
	}
	
	/**
	 * 对指定标签数组推送信息到所有平台
	 * @param alert
	 * @param tags 标签	数组。多个标签之间是 OR 的关系，即取并集。	用标签来进行大规模的设备属性、用户属性分群。 一次推送最多 20 个。
						有效的 tag 组成：字母（区分大小写）、数字、下划线、汉字。
						限制：每一个 tag 的长度限制为 40 字节。（判断长度需采用UTF-8编码）
	 * @return
	 */
	public PushResult pushToTag(String alert, String... tags){

		PushPayload payload = PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.tag(tags))
				.setOptions(Options.newBuilder().setTimeToLive(86400).build())
				.setNotification(Notification.alert(alert)).build();
        return commonPush(payload);
	}
	

	public PushResult commonPush( PushPayload payload) {
		
		if(payload == null){
			return null;
		}
        
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            
            return result;
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            
            System.out.println(e.getStatus()+":"+e.getErrorCode());
        }
        
        return null;
	}
	

	public static String getAppKey() {
		return bundle.getString("jpush.appKey");
	}

	public static String getMasterSecret() {
		return bundle.getString("jpush.masterSecret");
	}

    
	
	
	public static void main(String[] args) {
		
////		String[] ids ={"1","2"};
////		JPushUtils.pushToRegistrationId("test",ids);
//		JPushUtils.pushAll("test all");
////		String[] tags ={"TEST"};
////		JPushUtils.pushToTag("test tag", tags);
		String[] alias ={"c1"};
		JPushManager.getInstance().pushToAlias("test alias33", alias);
		
//		JPushManager.getInstance().pushAll("hello");
	}

    
}
