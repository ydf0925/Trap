
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月16日 下午5:25:17 
* @version 1.0 
*/
public class CaseShow {
	private int id;
	private  String name;
	
	public CaseShow() {
	}

	public CaseShow(int id, String name) {
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
		return "CaseShow [id=" + id + ", name=" + name + "]";
	}
}
