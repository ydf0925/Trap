
package com.bs.dao;

import java.util.List;

import com.bs.entity.About;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午2:57:38 
* @version 1.0 
*/
public interface AboutDao extends Dao {
	void addAbout(About about);
	
	void deleteAbout(int id);

	void updateAbout(About about);

	List<About> selectAboutList();
}