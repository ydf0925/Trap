
package com.bs.service;


import java.util.List;

import com.bs.entity.NewsCategory;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:21:59 
* @version 1.0 
*/
public interface NewsCategoryService extends Service{
void addNewsCategory(NewsCategory category);
	
	void deleteNewsCategory(int id);

	void updateNewsCategory(NewsCategory category);

	PageUtil<NewsCategory> selectNewsCategoryList(int page,int pageSize);
	
	List<NewsCategory> selectList();
}
