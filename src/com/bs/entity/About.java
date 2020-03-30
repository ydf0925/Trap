
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午2:55:21 
* @version 1.0 
*/
public class About {
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
		return "About [id=" + id + ", content=" + content + "]";
	}
}
