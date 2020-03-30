
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.LyDao;
import com.bs.entity.Ly;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午7:36:09 
* @version 1.0 
*/
public class LyDaoImpl implements LyDao{

	@Override
	public void addLy(Ly ly) {
		String sql="insert into t_ly values(null,?,?,?,?,sysdate())";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,ly.getName(),ly.getEmail(),ly.getTel(),ly.getContent());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Ly> selectLyList() {
		try {
			String sql="select id,name,email,tel,content,DATE_FORMAT(createtime,'%Y-%m-%d %H:%i:%s') createtime from t_ly order by createtime desc";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Ly>(Ly.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
