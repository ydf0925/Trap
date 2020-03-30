
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月19日 上午10:43:46 
* @version 1.0 
*/
public class Link {
	private int id;
	private String name;
	private String content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "CaseShow [id=" + id + ", name=" + name +",content"+ content + "]";
	}
}
