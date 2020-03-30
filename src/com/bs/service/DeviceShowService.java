
package com.bs.service;

import java.util.List;

import com.bs.entity.DeviceShow;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午3:43:07 
* @version 1.0 
*/
public interface DeviceShowService extends Service {
	void addDeviceShow(DeviceShow deviceShow);
	
	void deleteDeviceShow(int id);

	void updateDeviceShow(DeviceShow deviceShow);

	PageUtil<DeviceShow> selectDeviceShowList(int page,int pageSize);
	
	List<DeviceShow> selectList();
}
