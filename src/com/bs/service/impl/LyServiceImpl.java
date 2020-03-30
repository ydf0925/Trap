
package com.bs.service.impl;


import com.bs.dao.LyDao;
import com.bs.entity.Ly;
import com.bs.factory.BasicFactory;
import com.bs.service.LyService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午7:39:32 
* @version 1.0 
*/
public class LyServiceImpl implements LyService {
	LyDao dao=BasicFactory.getFactory().getDao(LyDao.class);
	
	@Override
	public void addLy(Ly ly) {
		dao.addLy(ly);
	}

	@Override
	public PageUtil<Ly> selectLyList(int page,int pageSize) {
		return new PageUtil<Ly>(page, pageSize, dao.selectLyList());
	}

}
