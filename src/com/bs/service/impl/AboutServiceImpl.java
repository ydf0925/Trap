
package com.bs.service.impl;

import java.util.List;

import com.bs.dao.AboutDao;
import com.bs.entity.About;
import com.bs.factory.BasicFactory;
import com.bs.service.AboutService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午3:04:54 
* @version 1.0 
*/
public class AboutServiceImpl implements AboutService{
	AboutDao dao=BasicFactory.getFactory().getDao(AboutDao.class);

	@Override
	public void addAbout(About about) {
		dao.addAbout(about);
	}

	@Override
	public void deleteAbout(int id) {
		dao.deleteAbout(id);
	}

	@Override
	public void updateAbout(About about) {
		dao.updateAbout(about);
	}

	@Override
	public PageUtil<About> selectAboutList(int page,int pageSize) {
		
			return new PageUtil<About>(page, pageSize, dao.selectAboutList());
	}

	@Override
	public List<About> selectList() {
		return dao.selectAboutList();
	}

}
