package com.nico.web.hibernate.entity2;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jpa_user2")
public class User2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1884206922088714052L;

	public User2() {
	}

	public User2(String username, String userpwd) {
		this.username = username;
		this.userpwd = userpwd;
	}

	@Id
	@Column(name = "user_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Column(name = "user_name")
	private String username;

	@Column(name = "user_pwd")
	private String userpwd;

	@Column(name = "login_name")
	private String loginName;

	@Column(name = "create_date")
	private Date createDate;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}