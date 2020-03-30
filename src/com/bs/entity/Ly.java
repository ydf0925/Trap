
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午7:32:16 
* @version 1.0 
*/
public class Ly {
	private int id;
	private String name;
	private String email;
	private String tel;
	private String content;
	private String createtime;
	public Ly() {
	}
	public Ly(int id, String name, String email, String tel, String content, String createtime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.content = content;
		this.createtime = createtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Ly [id=" + id + ", name=" + name + ", email=" + email + ", tel=" + tel + ", content=" + content
				+ ", createtime=" + createtime + "]";
	}
	
	
}
