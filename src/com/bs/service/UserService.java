
package com.bs.service;


import com.bs.entity.User;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 上午11:31:14 
* @version 1.0 
*/
public interface UserService extends Service {
	/**
	 * 添加用户的方法
	 * @param user 封装了用户数据的user
	 */
	void addUser(User user);
	
	/**
	 * 通过用户名和密码查询用户
	 * @param name
	 * @param pass
	 * @return
	 */
	User selectByNameAndPaw(String name, String pass);
	
	/**
	 * 删除用户
	 * @parameter id
	 * @return
	 */
	void deleteUser(int id);
	
	/**
	 * 修改用户
	 * @parameter
	 * @return
	 */
	void updateUser(User user);
	
	/**
	 * 查询所有用户
	 * @parameter
	 * @return
	 */
	PageUtil<User> selectUserList(int page,int pageSize);
	
	/**
	 * 修改用户密码
	 * @parameter
	 * @return
	 */
	void changePass(int id,String password);
}
