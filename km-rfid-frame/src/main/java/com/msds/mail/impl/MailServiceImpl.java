package com.msds.mail.impl;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.msds.common.Setting;
import com.msds.mail.MailService;
import com.msds.setting.SettingUtils;

/**
 * 邮件服务
 * 
 * @ClassName MailServiceImpl
 * @Description 邮件相关配置请参见applicationContext-comm.xml中变量,如用户名密码服务器等
 * @author LiLong
 * @date 2014年8月12日 下午5:34:54
 * 
 */
@Service("mailServiceImpl")
public class MailServiceImpl implements MailService {

	@Resource(name = "javaMailSender")
	private JavaMailSenderImpl javaMailSender;
	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;

	/**
	 * 添加邮件发送任务
	 * 
	 * @param mimeMessage
	 *            MimeMessage
	 */
	private void addSendTask(final MimeMessage mimeMessage) {
		try {
			taskExecutor.execute(new Runnable() {
				public void run() {
					javaMailSender.send(mimeMessage);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String toMail, String subject, String text,
			boolean multipartFlag, Map<String, String> multipartMap,
			boolean async) throws Exception {
		Assert.hasText(toMail);
		Assert.hasText(subject);
		Assert.hasText(text);
		try {
			Setting setting = SettingUtils.get();
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
					mimeMessage, multipartFlag, "utf-8");
			mimeMessageHelper
					.setFrom(MimeUtility.encodeWord(setting.getSiteName())
							+ " <" + javaMailSender.getUsername() + ">");
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setTo(toMail);
			mimeMessageHelper.setText(text, true);
			if (multipartMap != null && !multipartMap.isEmpty()) {
				for (Entry<String, String> entry : multipartMap.entrySet()) {
					mimeMessageHelper.addAttachment(entry.getKey(), new File(
							entry.getValue()));
				}
			}
			if (async) {
				addSendTask(mimeMessage);
			} else {
				javaMailSender.send(mimeMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (MessagingException e) {
			e.printStackTrace();
			throw e;
		}
	}
}