
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.NewsDao;
import com.bs.entity.News;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:14:44 
* @version 1.0 
*/
public class NewsDaoImpl implements NewsDao{

	@Override
	public void addNews(News news) {
		String sql="insert into t_new_details values(null,?,?,?,?,sysdate(),sysdate())";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,news.getTitle(),news.getAuthor(),news.getCid(),news.getContent());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteNews(int id) {
		String sql="delete from t_new_details  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateNews(News news) {
		String sql="update t_new_details set title=?,author=?,cid=?,content=?,updatetime=sysdate() where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,news.getTitle(),news.getAuthor(),news.getCid(),news.getContent(),news.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<News> selectNewsList() {
		try {
			String sql="select d.id,d.title,d.author,d.cid,d.content,DATE_FORMAT(d.createtime,'%Y-%m-%d %H:%i:%s') createtime,DATE_FORMAT(d.updatetime,'%Y-%m-%d %H:%i:%s') updatetime, "
					+ "c.name as cname from t_new_details d left join t_new_category c on d.cid=c.id";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<News>(News.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<News> selectByCid(int cid) {
		try {
			String sql="select id,title,author,cid,content,DATE_FORMAT(createtime,'%Y-%m-%d %H:%i:%s') createtime,DATE_FORMAT(updatetime,'%Y-%m-%d %H:%i:%s') updatetime from t_new_details where cid=?";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<News>(News.class),cid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public News selectById(int id) {
		try {
			String sql="select id,title,author,cid,content,DATE_FORMAT(createtime,'%Y-%m-%d %H:%i:%s') createtime,DATE_FORMAT(updatetime,'%Y-%m-%d %H:%i:%s') updatetime from t_new_details where id=?";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<News>(News.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
