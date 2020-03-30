
package com.bs.dao;

import java.util.List;

import com.bs.entity.Link;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月19日 上午10:47:47 
* @version 1.0 
*/
public interface LinkDao extends Dao {
	
	void addLink(Link link);
	
	void deleteLink(int id);

	void updateLink(Link link);

	List<Link> selectLinkList();
}
