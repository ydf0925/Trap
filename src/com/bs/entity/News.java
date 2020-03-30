
package com.bs.entity;


/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午8:02:30 
* @version 1.0 
*/
public class News {
	private int id;
	private String title;
	private int cid;
	private String author;
	private String content;
	private String createtime;
	private String updatetime;
	private String cname;
	
	public News() {
	}


	public News(int id, String title, int cid, String author, String content, String createtime, String updatetime) {
		super();
		this.id = id;
		this.title = title;
		this.cid = cid;
		this.author = author;
		this.content = content;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}



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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getContent() {
		return content;
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


	public void setContent(String content) {
		this.content = content;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", cid=" + cid + ", author=" + author + ", content=" + content
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
	}

	
}
