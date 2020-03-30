
package com.bs.dao;

import java.util.List;

import com.bs.entity.DeviceShow;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午3:27:15 
* @version 1.0 
*/
public interface DeviceShowDao extends Dao {
	void addDeviceShow(DeviceShow deviceShow);
	
	void deleteDeviceShow(int id);

	void updateDeviceShow(DeviceShow deviceShow);

	List<DeviceShow> selectDeviceShowList();
}
