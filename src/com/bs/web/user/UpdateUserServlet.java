
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
* @date 创建时间：2019年9月14日 下午6:26:13 
* @version 1.0 
*/
public class UpdateUserServlet extends HttpServlet{

	private static final long serialVersionUID = 3102520543232731560L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service=BasicFactory.getFactory().getService(UserService.class);
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String name=request.getParameter("name");
		User user=new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(MD5Utils.md5(password));
		user.setSex(sex);
		user.setName(name);
		service.updateUser(user);
		response.getWriter().print(1);
		}
}
