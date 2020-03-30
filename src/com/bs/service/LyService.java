
package com.bs.service;


import com.bs.entity.Ly;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午7:38:53 
* @version 1.0 
*/
public interface LyService extends Service{

	void addLy(Ly ly);
	
	PageUtil<Ly> selectLyList(int page,int pageSize);
}
