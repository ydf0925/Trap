
package com.bs.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.User;
import com.bs.factory.BasicFactory;
import com.bs.service.UserService;
import com.bs.utils.MD5Utils;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午5:28:03 
* @version 1.0 
*/
public class AddUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3101276469150987993L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		UserService service=BasicFactory.getFactory().getService(UserService.class);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String name=request.getParameter("name");
		User user=new User();
		user.setUsername(username);
		user.setPassword(MD5Utils.md5(password));
		user.setSex(sex);
		user.setName(name);
		service.addUser(user);
		}
}
