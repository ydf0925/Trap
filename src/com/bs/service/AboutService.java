
package com.bs.service;

import java.util.List;

import com.bs.entity.About;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午3:03:41 
* @version 1.0 
*/
public interface AboutService extends Service {
void addAbout(About about);
	
	void deleteAbout(int id);

	void updateAbout(About about);

	PageUtil<About> selectAboutList(int page,int pageSize);
	
	List<About> selectList();
}

