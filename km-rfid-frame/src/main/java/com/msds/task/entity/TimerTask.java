package com.msds.task.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 这是TimerTaskDto的数据传输对象类<br>
 * 
 * @author LiLong
 * 
 */
public class TimerTask implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String cacheId = "TimerTaskList";

	private Integer id = null;

	/**
	 * 属性:taskId<br>
	 * 含义:任务id<br>
	 */
	private String taskId = null;
	/**
	 * 属性:taskName<br>
	 * 含义:任务name<br>
	 */
	private String taskName = null;
	/**
	 * 属性:type<br>
	 * 含义:1-短信任务，2-账期定时任务，3-邮件任务<br>
	 */
	private String type = null;
	/**
	 * 属性:taskType<br>
	 * 含义:任务类型，1-单次定时任务；2-重复任务<br>
	 */
	private String taskType = null;
	/**
	 * 属性:taskClass<br>
	 * 含义:执行任务的类<br>
	 */
	private String taskClass = null;
	/**
	 * 属性:taskMethod<br>
	 * 含义:执行任务的方法，最多一个string类型参数<br>
	 */
	private String taskMethod = null;
	/**
	 * 属性:runTime<br>
	 * 含义:预订执行时间<br>
	 */
	private Date runTime = null;
	/**
	 * 属性:realRunTime<br>
	 * 含义:实际执行时间<br>
	 */
	private Date realRunTime = null;
	/**
	 * 属性:completeTime<br>
	 * 含义:执行完成时间<br>
	 */
	private Date completeTime = null;
	/**
	 * 属性:delay<br>
	 * 含义:任务延迟执行时间（毫秒）<br>
	 */
	private Long delay = null;
	/**
	 * 属性:intervers<br>
	 * 含义:任务执行间隔时间（毫秒）<br>
	 */
	private Long intervers = null;
	/**
	 * 属性:status<br>
	 * 含义:任务状态，1-等待运行，2-正在执行，3-执行完成，4-执行异常，5-任务取消，6-任务过期<br>
	 */
	private String status = null;
	/**
	 * 属性:taskContent<br>
	 * 含义:任务内容<br>
	 */
	private String taskContent = null;
	/**
	 * 属性:mobiles<br>
	 * 含义:任务特征 手机号<br>
	 */
	private String mobiles = null;
	/**
	 * 属性:address<br>
	 * 含义:任务特征 邮件地址<br>
	 */
	private String address = null;
	/**
	 * 属性:subject<br>
	 * 含义:任务特征 邮件主题<br>
	 */
	private String subject = null;

	private String orderByClause;

	private boolean statusChanged = false;

	/**
	 * 设置属性taskId<br>
	 * 含义:任务id<br>
	 * 
	 * @param taskId
	 *            待设置的属性taskId的值
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * 获取属性taskId<br>
	 * 含义:任务id<br>
	 * 
	 * @return 属性taskId的值
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * 设置属性type<br>
	 * 含义:1-短信任务，2-邮件任务，3-时间任务<br>
	 * 
	 * @param type
	 *            待设置的属性type的值
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取属性type<br>
	 * 含义:1-短信任务，2-邮件任务，3-时间任务<br>
	 * 
	 * @return 属性type的值
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置属性taskType<br>
	 * 含义:任务类型，1-单次定时任务；2-延迟重复任务，3-定时重复任务 <br>
	 * 
	 * @param taskType
	 *            待设置的属性taskType的值
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
	 * 获取属性taskType<br>
	 * 含义:任务类型，1-单次定时任务；2-延迟重复任务，3-定时重复任务<br>
	 * 
	 * @return 属性taskType的值
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * 设置属性taskClass<br>
	 * 含义:执行任务的类<br>
	 * 
	 * @param taskClass
	 *            待设置的属性taskClass的值
	 */
	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}

	/**
	 * 获取属性taskClass<br>
	 * 含义:执行任务的类<br>
	 * 
	 * @return 属性taskClass的值
	 */
	public String getTaskClass() {
		return taskClass;
	}

	/**
	 * 设置属性taskMethod<br>
	 * 含义:执行任务的方法，最多一个string类型参数<br>
	 * 
	 * @param taskMethod
	 *            待设置的属性taskMethod的值
	 */
	public void setTaskMethod(String taskMethod) {
		this.taskMethod = taskMethod;
	}

	/**
	 * 获取属性taskMethod<br>
	 * 含义:执行任务的方法，最多一个string类型参数<br>
	 * 
	 * @return 属性taskMethod的值
	 */
	public String getTaskMethod() {
		return taskMethod;
	}

	/**
	 * 设置属性runTime<br>
	 * 含义:预订执行时间<br>
	 * 
	 * @param runTime
	 *            待设置的属性runTime的值
	 */
	public void setRunTime(Date runTime) {
		this.runTime = runTime;
	}

	/**
	 * 获取属性runTime<br>
	 * 含义:预订执行时间<br>
	 * 
	 * @return 属性runTime的值
	 */
	public Date getRunTime() {
		return runTime;
	}

	/**
	 * 设置属性realRunTime<br>
	 * 含义:实际执行时间<br>
	 * 
	 * @param realRunTime
	 *            待设置的属性realRunTime的值
	 */
	public void setRealRunTime(Date realRunTime) {
		this.realRunTime = realRunTime;
	}

	/**
	 * 获取属性realRunTime<br>
	 * 含义:实际执行时间<br>
	 * 
	 * @return 属性realRunTime的值
	 */
	public Date getRealRunTime() {
		return realRunTime;
	}

	/**
	 * 设置属性completeTime<br>
	 * 含义:执行完成时间<br>
	 * 
	 * @param completeTime
	 *            待设置的属性completeTime的值
	 */
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	/**
	 * 获取属性completeTime<br>
	 * 含义:执行完成时间<br>
	 * 
	 * @return 属性completeTime的值
	 */
	public Date getCompleteTime() {
		return completeTime;
	}

	/**
	 * 设置属性delay<br>
	 * 含义:任务延迟执行时间（毫秒）<br>
	 * 
	 * @param delay
	 *            待设置的属性delay的值
	 */
	public void setDelay(Long delay) {
		this.delay = delay;
	}

	/**
	 * 获取属性delay<br>
	 * 含义:任务延迟执行时间（毫秒）<br>
	 * 
	 * @return 属性delay的值
	 */
	public Long getDelay() {
		return delay;
	}

	/**
	 * 设置属性intervers<br>
	 * 含义:任务执行间隔时间（毫秒）<br>
	 * 
	 * @param intervers
	 *            待设置的属性intervers的值
	 */
	public void setIntervers(Long intervers) {
		this.intervers = intervers;
	}

	/**
	 * 获取属性intervers<br>
	 * 含义:任务执行间隔时间（毫秒）<br>
	 * 
	 * @return 属性intervers的值
	 */
	public Long getIntervers() {
		return intervers;
	}

	/**
	 * 获取属性status<br>
	 * 含义:任务状态，1-等待运行，2-正在执行，3-执行完成，4-执行异常，5-任务取消，6-任务过期<br>
	 * 
	 * @return 属性status的值
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置属性taskContent<br>
	 * 含义:任务内容/方法参数json<br>
	 * 
	 * @param taskContent
	 */
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	/**
	 * 获取属性taskContent<br>
	 * 含义:任务内容/方法参数json<br>
	 * 
	 * @return 属性taskContent的值
	 */
	public String getTaskContent() {
		return taskContent;
	}

	/**
	 * 属性:taskName<br>
	 * 含义:任务name<br>
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * 属性:taskName<br>
	 * 含义:任务name<br>
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 属性:mobiles<br>
	 * 含义:任务特征 手机号<br>
	 */
	public String getMobiles() {
		return mobiles;
	}

	/**
	 * 属性:mobiles<br>
	 * 含义:任务特征 手机号<br>
	 */
	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}

	/**
	 * 属性:address<br>
	 * 含义:任务特征 邮件地址<br>
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 属性:address<br>
	 * 含义:任务特征 邮件地址<br>
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 属性:subject<br>
	 * 含义:任务特征 邮件主题<br>
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 属性:subject<br>
	 * 含义:任务特征 邮件主题<br>
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 状态变动
	 * 
	 * @return
	 */
	public boolean isStatusChanged() {
		return statusChanged;
	}

	public void setStatusChanged(boolean statusChanged) {
		this.statusChanged = statusChanged;
	}

	/**
	 * 设置属性status<br>
	 * 含义:任务状态，1-等待运行，2-正在执行，3-执行完成，4-执行异常，5-任务取消，6-任务过期<br>
	 * 
	 * @param status
	 *            待设置的属性status的值
	 */
	public void setStatus(String status) {
		String olds = getStatus();
		if (status == null && olds == null) {
			setStatusChanged(false);
		} else if (olds != null && (!olds.equals(status))) {
			setStatusChanged(true);
		} else if (status != null && (status.equals(olds))) {
			setStatusChanged(true);
		} else {
			setStatusChanged(false);
		}
		if ("2".equals(status) || "4".equals(status)) {
			setRealRunTime(new Date());
		} else if ("3".equals(status)) {
			setCompleteTime(new Date());
		}
		this.status = status;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
}
