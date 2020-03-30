
package com.bs.service;

import java.util.List;

import com.bs.entity.Fwxm;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月25日 上午10:27:04 
* @version 1.0 
*/
public interface FwxmService extends Service {
	void addFwxm(Fwxm fwxm);
	
	void deleteFwxm(int id);

	void updateFwxm(Fwxm fwxm);

	PageUtil<Fwxm> selectFwxmList(int page,int pageSize);
	
	List<Fwxm> selectList();
}
