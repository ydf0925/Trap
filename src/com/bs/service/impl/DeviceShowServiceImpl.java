
package com.bs.service.impl;

import java.util.List;

import com.bs.dao.DeviceShowDao;
import com.bs.entity.DeviceShow;
import com.bs.factory.BasicFactory;
import com.bs.service.DeviceShowService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午3:45:02 
* @version 1.0 
*/
public class DeviceShowServiceImpl implements DeviceShowService {
	DeviceShowDao dao=BasicFactory.getFactory().getDao(DeviceShowDao.class);

	@Override
	public void addDeviceShow(DeviceShow deviceShow) {
		dao.addDeviceShow(deviceShow);
	}

	@Override
	public void deleteDeviceShow(int id) {
		dao.deleteDeviceShow(id);
	}

	@Override
	public void updateDeviceShow(DeviceShow deviceShow) {
		dao.updateDeviceShow(deviceShow);
	}

	@Override
	public PageUtil<DeviceShow> selectDeviceShowList(int page,int pageSize) {
		
			return new PageUtil<DeviceShow>(page, pageSize, dao.selectDeviceShowList());
	}

	@Override
	public List<DeviceShow> selectList() {
		return dao.selectDeviceShowList();
	}

}
