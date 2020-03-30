
package com.bs.dao;

import java.util.List;

import com.bs.entity.Device;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:07:53 
* @version 1.0 
*/
public interface DeviceDao extends Dao {
	void addDevice(Device device);
	
	void deleteDevice(int id);

	void updateDevice(Device device);
	
	void updateImg(Device device);

	List<Device> selectDeviceList();
	
	List<Device> selectByCid(int cid);
	
	Device selectById(int id);
}
