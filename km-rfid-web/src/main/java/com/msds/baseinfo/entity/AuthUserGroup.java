package com.msds.baseinfo.entity;

import java.util.Date;

public class AuthUserGroup implements java.io.Serializable {
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    //## struts 2 ajax 转化你的时候注意 private 换成public
    public  Boolean isStaff;
    public  Boolean isActive;
    public Boolean isSuperuser;
    private Date lastLogin;
    private Date dateJoined;
    private String name;
    private String groupId;
    
    public AuthUserGroup() {
		super();
	}
    
    
	public AuthUserGroup(Integer id, String userName, String firstName,
			String lastName, String email, String password, Boolean isStaff,
			Boolean isActive, Boolean isSuperuser, Date lastLogin,
			Date dateJoined,String name,String groupId) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isStaff = isStaff;
		this.isActive = isActive;
		this.isSuperuser = isSuperuser;
		this.lastLogin = lastLogin;
		this.dateJoined = dateJoined;
		this.name=name;
		this.groupId=groupId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Boolean getIsStaff() {
		return isStaff;
	}
	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsSuperuser() {
		return isSuperuser;
	}
	public void setIsSuperuser(Boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
	}
}