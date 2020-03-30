
package com.bs.service.impl;

import java.util.List;

import com.bs.dao.CaseDao;
import com.bs.entity.Case;
import com.bs.factory.BasicFactory;
import com.bs.service.CaseService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午3:21:51 
* @version 1.0 
*/
public class CaseServiceImpl implements CaseService {
	CaseDao dao=BasicFactory.getFactory().getDao(CaseDao.class);

	@Override
	public void addCase(Case cases) {
		dao.addCase(cases);
	}

	@Override
	public void deleteCase(int id) {
		dao.deleteCase(id);
	}

	@Override
	public void updateCase(Case cases) {
		dao.updateCase(cases);
	}
	@Override
	public void updateImg(Case cases) {
		dao.updateImg(cases);
		
	}

	@Override
	public PageUtil<Case> selectCaseList(int page,int pageSize) {
		List<Case> list=dao.selectCaseList();
		if(list!=null && list.size()>0) {
			return new PageUtil<Case>(page, pageSize, dao.selectCaseList());
		}
		return null;
	}

	@Override
	public List<Case> selectByCid(int cid) {
		return dao.selectByCid(cid);
	}

	@Override
	public Case selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public PageUtil<Case> selectCaseImgList(int page, int pageSize) {
		List<Case> list=dao.selectCaseImgList();
		if(list!=null && list.size()>0) {
			return new PageUtil<Case>(page, pageSize, list);
		}
		return null;
	}
	
}
