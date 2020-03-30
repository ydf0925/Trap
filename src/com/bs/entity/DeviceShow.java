
package com.bs.entity;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午3:22:42 
* @version 1.0 
*/
public class DeviceShow {
	private int id;
	private  String name;
	
	public DeviceShow() {
	}

	public DeviceShow(int id, String name) {
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
