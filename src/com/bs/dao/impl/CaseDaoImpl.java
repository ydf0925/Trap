
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.CaseDao;
import com.bs.entity.Case;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:59:59 
* @version 1.0 
*/
public class CaseDaoImpl implements CaseDao {
	
	@Override
	public void addCase(Case cases) {
		String sql="insert into t_case_details values(null,?,?,?,?,sysdate(),sysdate())";
		//String sql2="select max(id)as id from t_case_details";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,cases.getTitle(),cases.getCid(),cases.getContent(),cases.getImgname());
			//cases=runner.query(sql2, new BeanHandler<Case>(Case.class));
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return cases.getId();
	}

	@Override
	public void deleteCase(int id) {
		String sql="delete from t_case_details  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateCase(Case cases) {
		String sql="update t_case_details set title=?,cid=?,content=?,imgname=?,updatetime=sysdate() where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,cases.getTitle(),cases.getCid(),cases.getContent(),cases.getImgname(),cases.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
	
	@Override
	public void updateImg(Case cases) {
		String sql="update t_case_details set imgname=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,cases.getImgname(),cases.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<Case> selectCaseList() {
		try {
			String sql="select d.id,d.title,d.cid,d.content,d.imgname,DATE_FORMAT(d.createtime,'%Y-%m-%d %H:%i:%s') createtime,DATE_FORMAT(d.updatetime,'%Y-%m-%d %H:%i:%s') updatetime, "
					+ "c.name as cname from t_case_details d left join t_case_show c on d.cid=c.id ";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Case>(Case.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Case> selectByCid(int cid) {
		try {
			String sql="select id,title,cid,content,imgname,DATE_FORMAT(createtime,'%Y-%m-%d %H:%i:%s') createtime,DATE_FORMAT(updatetime,'%Y-%m-%d %H:%i:%s') updatetime from t_case_details where cid=?";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Case>(Case.class),cid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Case> selectCaseImgList() {
		try {
			String sql="select b.id,b.cid,b.imgname,c.name as cname from (select max(d.id) as id,d.cid FROM t_case_details d GROUP BY d.cid) a INNER JOIN t_case_details b on a.cid=b.cid AND a.id=b.id "
					+ "LEFT JOIN t_case_show c ON b.cid = c.id order by b.cid";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Case>(Case.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Case selectById(int id) {
		try {
			String sql="select id,title,cid,content,imgname,DATE_FORMAT(createtime,'%Y-%m-%d %H:%i:%s') createtime,DATE_FORMAT(updatetime,'%Y-%m-%d %H:%i:%s') updatetime from t_case_details where id=?";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Case>(Case.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

}
