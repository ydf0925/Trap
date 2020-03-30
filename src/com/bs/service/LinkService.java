
package com.bs.service;

import java.util.List;

import com.bs.entity.Link;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月19日 上午10:55:22 
* @version 1.0 
*/
public interface LinkService extends Service {
	void addLink(Link link);
	
	void deleteLink(int id);

	void updateLink(Link link);

	PageUtil<Link> selectLinkList(int page,int pageSize);
	
	List<Link> selectList();
}
