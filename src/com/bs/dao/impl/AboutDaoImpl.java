
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.AboutDao;
import com.bs.entity.About;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午2:59:46 
* @version 1.0 
*/
public class AboutDaoImpl implements AboutDao{

	@Override
	public void addAbout(About about) {
		String sql="insert into t_about values(null,?)";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,about.getContent());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteAbout(int id) {
		String sql="delete from t_about  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateAbout(About about) {
		String sql="update t_about set content=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,about.getContent(),about.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<About> selectAboutList() {
		try {
			String sql="select * from t_about";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<About>(About.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}