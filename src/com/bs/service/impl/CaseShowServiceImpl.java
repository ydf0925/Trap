
package com.bs.service.impl;

import java.util.List;

import com.bs.dao.CaseShowDao;
import com.bs.entity.CaseShow;
import com.bs.factory.BasicFactory;
import com.bs.service.CaseShowService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月16日 下午8:34:09 
* @version 1.0 
*/
	public class CaseShowServiceImpl implements CaseShowService{
		CaseShowDao dao=BasicFactory.getFactory().getDao(CaseShowDao.class);

		@Override
		public void addCaseShow(CaseShow caseshow) {
			dao.addCaseShow(caseshow);
		}

		@Override
		public void deleteCaseShow(int id) {
			dao.deleteCaseShow(id);
		}

		@Override
		public void updateCaseShow(CaseShow caseshow) {
			dao.updateCaseShow(caseshow);
		}

		@Override
		public PageUtil<CaseShow> selectCaseShowList(int page,int pageSize) {
			
				return new PageUtil<CaseShow>(page, pageSize, dao.selectCaseShowList());
		}

		@Override
		public List<CaseShow> selectList() {
			return dao.selectCaseShowList();
		}

	}

