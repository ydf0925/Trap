
package com.bs.service.impl;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:23:17 
* @version 1.0 
*/


import java.util.List;

import com.bs.dao.NewsDao;
import com.bs.entity.News;
import com.bs.factory.BasicFactory;
import com.bs.service.NewsService;
import com.bs.utils.PageUtil;

public class NewsServiceImpl implements NewsService{
	NewsDao dao=BasicFactory.getFactory().getDao(NewsDao.class);

	@Override
	public void addNews(News category) {
		dao.addNews(category);
	}

	@Override
	public void deleteNews(int id) {
		dao.deleteNews(id);
	}

	@Override
	public void updateNews(News news) {
		dao.updateNews(news);
	}

	@Override
	public PageUtil<News> selectNewsList(int page,int pageSize) {
		List<News> list=dao.selectNewsList();
		if(list!=null && list.size()>0) {
			return new PageUtil<News>(page, pageSize, dao.selectNewsList());
		}
		return null;
	}

	@Override
	public List<News> selectByCid(int cid) {
		return dao.selectByCid(cid);
	}

	@Override
	public News selectById(int id) {
		return dao.selectById(id);
	}

}
