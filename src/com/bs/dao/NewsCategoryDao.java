
package com.bs.dao;

import java.util.List;

import com.bs.entity.NewsCategory;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:14:22 
* @version 1.0 
*/
public interface NewsCategoryDao extends Dao {
	
	void addNewsCategory(NewsCategory category);
	
	void deleteNewsCategory(int id);

	void updateNewsCategory(NewsCategory category);

	List<NewsCategory> selectNewsCategoryList();
}
