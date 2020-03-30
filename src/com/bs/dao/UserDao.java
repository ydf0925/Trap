
package com.bs.dao;

import java.util.List;

import com.bs.entity.User;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 上午11:30:43 
* @version 1.0 
*/
public interface UserDao extends Dao{
	
	void addUser(User user);
	
	void deleteUser(int id);

	void updateUser(User user);

	User selectByNameAndPaw(String name, String pass);
	
	User selectUserByName(String userName);
	
	List<User> selectUserList(int page,int pageSize);
	
	void changePass(int id,String password);
	
}
