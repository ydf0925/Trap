
package com.bs.dao.impl;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 上午11:45:40 
* @version 1.0 
*/

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.UserDao;
import com.bs.entity.User;
import com.bs.utils.TransactionManager;


public class UserDaoImpl implements UserDao{
	
	@Override
	public void addUser(User user) {
		String sql="insert into t_user values(null,?,?,?,?,?)";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getSex(),user.getStatus());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteUser(int id) {
		String sql="update t_user set status=1 where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateUser(User user) {
		String sql="update t_user set username= ?,password=?,sex=?,name=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,user.getUsername(),user.getPassword(),user.getSex(),user.getName(),user.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public User selectByNameAndPaw(String name, String pass) {
		String sql="select * from t_user where username= ? and password= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql,new BeanHandler<User>(User.class),name,pass);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public User selectUserByName(String userName) {
		String sql="select * from t_user where username= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class),userName);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> selectUserList(int page,int pageSize) {
		try {
			String sql="select * from t_user where status=0 ";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void changePass(int id, String password) {
		String sql="update t_user set password=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,password,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


}
