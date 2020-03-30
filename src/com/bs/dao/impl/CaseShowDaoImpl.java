
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.CaseShowDao;
import com.bs.entity.CaseShow;
import com.bs.utils.TransactionManager;

/** 
* @author 作者: yuedengfeng
* @date 创建时间：2019年9月14日 下午7:14:44 
* @version 1.0 
*/
public class CaseShowDaoImpl implements CaseShowDao{

	@Override
	public void addCaseShow(CaseShow caseshow) {
		String sql="insert into t_case_show values(null,?)";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,caseshow.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteCaseShow(int id) {
		String sql="delete from t_case_show  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateCaseShow(CaseShow caseshow) {
		String sql="update t_case_show set name=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,caseshow.getName(),caseshow.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<CaseShow> selectCaseShowList() {
		try {
			String sql="select * from t_case_show";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<CaseShow>(CaseShow.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
