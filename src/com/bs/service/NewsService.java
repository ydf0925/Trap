
package com.bs.service;


import java.util.List;

import com.bs.entity.News;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:21:59 
* @version 1.0 
*/
public interface NewsService extends Service{
	
	void addNews(News news);
	
	void deleteNews(int id);

	void updateNews(News news);

	PageUtil<News> selectNewsList(int page,int pageSize);
	
	List<News> selectByCid(int cid);
	
	News selectById(int id);
}
