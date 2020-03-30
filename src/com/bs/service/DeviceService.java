
package com.bs.service;

import java.util.List;

import com.bs.entity.Device;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:21:05 
* @version 1.0 
*/
public interface DeviceService extends Service{
	void addDevice(Device device);
	
	void deleteDevice(int id);

	void updateDevice(Device device);
	
	void updateImg(Device device);

	PageUtil<Device> selectDeviceList(int page,int pageSize);
	
	List<Device> selectByCid(int cid);
	
	Device selectById(int id);
}