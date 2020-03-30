
package com.bs.entity;

import java.io.Serializable;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:50:14 
* @version 1.0 
*/
public class Case implements Serializable{
	private static final long serialVersionUID = -5864730741539281093L;
	
	private int id;
	private String title;
	private int cid;
	private String content;
	private String imgname;
	private String createtime;
	private String updatetime;
	private String cname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	
	@Override
	public String toString() {
		return "Case [id=" + id + ", title=" + title + ", cid=" + cid + ", content=" + content +", imgname=" + imgname+ ", createtime="
				+ createtime + ", updatetime=" + updatetime + ", cname=" + cname  + "]";
	}
	
}
