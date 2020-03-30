
package com.bs.service.impl;

import java.util.List;

import com.bs.dao.LinkDao;
import com.bs.entity.Link;
import com.bs.factory.BasicFactory;
import com.bs.service.LinkService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月19日 上午10:56:57 
* @version 1.0 
*/
public class LinkServiceImpl implements LinkService{
	LinkDao dao=BasicFactory.getFactory().getDao(LinkDao.class);

	@Override
	public void addLink(Link link) {
		dao.addLink(link);
	}

	@Override
	public void deleteLink(int id) {
		dao.deleteLink(id);
	}

	@Override
	public void updateLink(Link link) {
		dao.updateLink(link);
	}

	@Override
	public PageUtil<Link> selectLinkList(int page,int pageSize) {
		
			return new PageUtil<Link>(page, pageSize, dao.selectLinkList());
	}

	@Override
	public List<Link> selectList() {
		return dao.selectLinkList();
	}

}