
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月25日 上午10:20:37 
* @version 1.0 
*/
public class Fwxm {
	private int id;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Fwxm [id=" + id + ", content=" + content + "]";
	}
}
