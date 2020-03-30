
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 上午11:44:23 
* @version 1.0 
*/
public class User {
	private int id;
	private String username;
	private String password;
	private String name;
	private int status;
	private String sex;
	public User() {
	}
	
	
	public User(int id, String username, String password, String name, int status, String sex) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.status = status;
		this.sex = sex;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", status="
				+ status + ", sex=" + sex + "]";
	}

	
	
}
