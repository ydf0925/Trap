
package com.bs.service.impl;

import java.sql.Connection;

import com.bs.dao.UserDao;
import com.bs.entity.User;
import com.bs.factory.BasicFactory;
import com.bs.service.UserService;
import com.bs.utils.DaoUtils;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 上午11:31:51 
* @version 1.0 
*/
public class UserServiceImpl implements UserService {
	
	UserDao dao=BasicFactory.getFactory().getDao(UserDao.class);

	@Override
	public void addUser(User user) {
		Connection con=null;
		try {
			con=DaoUtils.getConn();
			con.setAutoCommit(false);
			//1.校验用户名是否已经存在
			if(dao.selectUserByName(user.getUsername())!=null){
				throw new RuntimeException("用户名已经存在！！");
			}
			//2.调用dao中的方法添加用户到数据库
			user.setStatus(0);
			dao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
			
		} 
		
	}

	@Override
	public User selectByNameAndPaw(String name, String pass) {
		return dao.selectByNameAndPaw(name,pass);
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
		
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}

	@Override
	public PageUtil<User> selectUserList(int page,int pageSize) {
		return new PageUtil<User>(page, pageSize, dao.selectUserList(page, pageSize));
	}

	@Override
	public void changePass(int id, String password) {
		dao.changePass(id, password);
	}

}
