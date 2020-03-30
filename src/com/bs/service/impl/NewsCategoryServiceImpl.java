
package com.bs.service.impl;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:23:17 
* @version 1.0 
*/


import java.util.List;

import com.bs.dao.NewsCategoryDao;
import com.bs.entity.NewsCategory;
import com.bs.factory.BasicFactory;
import com.bs.service.NewsCategoryService;
import com.bs.utils.PageUtil;

public class NewsCategoryServiceImpl implements NewsCategoryService{
	NewsCategoryDao dao=BasicFactory.getFactory().getDao(NewsCategoryDao.class);

	@Override
	public void addNewsCategory(NewsCategory category) {
		dao.addNewsCategory(category);
	}

	@Override
	public void deleteNewsCategory(int id) {
		dao.deleteNewsCategory(id);
	}

	@Override
	public void updateNewsCategory(NewsCategory category) {
		dao.updateNewsCategory(category);
	}

	@Override
	public PageUtil<NewsCategory> selectNewsCategoryList(int page,int pageSize) {
		return new PageUtil<NewsCategory>(page, pageSize, dao.selectNewsCategoryList());
	}

	@Override
	public List<NewsCategory> selectList() {
		return dao.selectNewsCategoryList();
	}

}
