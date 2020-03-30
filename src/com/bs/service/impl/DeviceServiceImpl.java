
package com.bs.service.impl;

import java.util.List;

import com.bs.dao.DeviceDao;
import com.bs.entity.Device;
import com.bs.factory.BasicFactory;
import com.bs.service.DeviceService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:23:19 
* @version 1.0 
*/
public class DeviceServiceImpl implements DeviceService {
	DeviceDao dao=BasicFactory.getFactory().getDao(DeviceDao.class);

	@Override
	public void addDevice(Device device) {
		dao.addDevice(device);
	}

	@Override
	public void deleteDevice(int id) {
		dao.deleteDevice(id);
	}

	@Override
	public void updateDevice(Device device) {
		dao.updateDevice(device);
	}
	
	@Override
	public void updateImg(Device device) {
		dao.updateImg(device);
		
	}

	@Override
	public PageUtil<Device> selectDeviceList(int page,int pageSize) {
		List<Device> list=dao.selectDeviceList();
		if(list!=null && list.size()>0) {
			return new PageUtil<Device>(page, pageSize, dao.selectDeviceList());
		}
		return null;
	}

	@Override
	public List<Device> selectByCid(int cid) {
		return dao.selectByCid(cid);
	}

	@Override
	public Device selectById(int id) {
		return dao.selectById(id);
	}
}
