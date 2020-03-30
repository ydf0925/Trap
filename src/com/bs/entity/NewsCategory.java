
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:15:40 
* @version 1.0 
*/
public class NewsCategory {
	private int id;
	private  String name;
	
	public NewsCategory() {
	}

	public NewsCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "NewsCategory [id=" + id + ", name=" + name + "]";
	}
	
}
