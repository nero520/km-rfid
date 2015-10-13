package com.msds.baseinfo.entity;

import java.util.Date;

public class AuthUser implements java.io.Serializable {
	private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Integer directShopId;
    private String salt;
    private String password;
    private boolean isStaff;
    private String isActive;
    private boolean isSuperuser;
    private Date lastLogin;
    private Date dateJoined;
    private String roleId;
    private String roleName;
    
    public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public AuthUser() {
		super();
	}
    
    
	public AuthUser(Integer id, String userName, String firstName,
			String lastName, String email, String password, boolean isStaff,
			String isActive, boolean isSuperuser, Date lastLogin,
			Date dateJoined, String salt) {
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
		this.salt = salt;
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
	public boolean getIsStaff() {
		return isStaff;
	}
	public void setIsStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public boolean getIsSuperuser() {
		return isSuperuser;
	}
	public void setIsSuperuser(boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
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


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public Integer getDirectShopId() {
		return directShopId;
	}


	public void setDirectShopId(Integer directShopId) {
		this.directShopId = directShopId;
	}
	
	
}