
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.FwxmDao;
import com.bs.entity.Fwxm;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月25日 上午10:22:53 
* @version 1.0 
*/
public class FwxmDaoImpl implements FwxmDao{

	@Override
	public void addFwxm(Fwxm fwxm) {
		String sql="insert into t_fwxm values(null,?)";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,fwxm.getContent());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteFwxm(int id) {
		String sql="delete from t_fwxm  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateFwxm(Fwxm fwxm) {
		String sql="update t_fwxm set content=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,fwxm.getContent(),fwxm.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<Fwxm> selectFwxmList() {
		try {
			String sql="select * from t_fwxm";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Fwxm>(Fwxm.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
