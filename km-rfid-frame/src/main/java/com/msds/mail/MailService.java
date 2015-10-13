package com.msds.mail;

import java.util.Map;

/**
 * 邮件服务
 * 
 * @ClassName MailService
 * @Description 邮件相关配置请参见applicationContext-comm.xml中变量,如用户名密码服务器等
 * @author LiLong
 * @date 2014年8月12日 下午5:34:54
 * 
 */
public interface MailService {

	/**
	 * 发送邮件
	 * 
	 * @param toMail
	 *            收件人邮箱
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @param multipartFlag
	 *            是否有附件
	 * @param multipartMap
	 *            附件<文件名, 文件路径>
	 * @param async
	 *            是否异步
	 * @throws Exception
	 */
	void send(String toMail, String subject, String text,
			boolean multipartFlag, Map<String, String> multipartMap,
			boolean async) throws Exception;

}