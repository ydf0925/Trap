
package com.bs.dao;

import java.util.List;

import com.bs.entity.News;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:14:22 
* @version 1.0 
*/
public interface NewsDao extends Dao {
	
	void addNews(News news);
	
	void deleteNews(int id);

	void updateNews(News news);

	List<News> selectNewsList();
	
	List<News> selectByCid(int cid);
	
	News selectById(int id);
}
