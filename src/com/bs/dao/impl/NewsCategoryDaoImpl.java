
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.NewsCategoryDao;
import com.bs.entity.NewsCategory;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:14:44 
* @version 1.0 
*/
public class NewsCategoryDaoImpl implements NewsCategoryDao{

	@Override
	public void addNewsCategory(NewsCategory category) {
		String sql="insert into t_new_category values(null,?)";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,category.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteNewsCategory(int id) {
		String sql="delete from t_new_category  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateNewsCategory(NewsCategory category) {
		String sql="update t_new_category set name=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,category.getName(),category.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<NewsCategory> selectNewsCategoryList() {
		try {
			String sql="select * from t_new_category";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<NewsCategory>(NewsCategory.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
