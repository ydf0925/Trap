
package com.bs.service.impl;

import java.util.List;

import com.bs.dao.FwxmDao;
import com.bs.entity.Fwxm;
import com.bs.factory.BasicFactory;
import com.bs.service.FwxmService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月25日 上午10:28:30 
* @version 1.0 
*/
public class FwxmServiceImpl implements FwxmService{
	FwxmDao dao=BasicFactory.getFactory().getDao(FwxmDao.class);

	@Override
	public void addFwxm(Fwxm fwxm) {
		dao.addFwxm(fwxm);
	}

	@Override
	public void deleteFwxm(int id) {
		dao.deleteFwxm(id);
	}

	@Override
	public void updateFwxm(Fwxm fwxm) {
		dao.updateFwxm(fwxm);
	}

	@Override
	public PageUtil<Fwxm> selectFwxmList(int page,int pageSize) {
		
			return new PageUtil<Fwxm>(page, pageSize, dao.selectFwxmList());
	}

	@Override
	public List<Fwxm> selectList() {
		return dao.selectFwxmList();
	}

}
