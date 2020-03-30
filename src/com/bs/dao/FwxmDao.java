
package com.bs.dao;

import java.util.List;

import com.bs.entity.Fwxm;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月25日 上午10:21:27 
* @version 1.0 
*/
public interface FwxmDao extends Dao {
	void addFwxm(Fwxm fwxm);
	
	void deleteFwxm(int id);

	void updateFwxm(Fwxm fwxm);

	List<Fwxm> selectFwxmList();
}
