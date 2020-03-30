
package com.bs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.entity.User;
import com.bs.factory.BasicFactory;
import com.bs.service.UserService;
import com.bs.utils.MD5Utils;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午12:21:18 
* @version 1.0 
*/
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = -5557164396218090399L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service=BasicFactory.getFactory().getService(UserService.class);
		//1.获取用户名和密码
		String name=request.getParameter("username");
		String pass=MD5Utils.md5(request.getParameter("password"));
		//2.调用service中的方法就行查询
		User user=service.selectByNameAndPaw(name,pass);
		//3.对查到的用户进行判断
		if(user == null){
			response.getWriter().write("用户名或密码不正确");
			request.setAttribute("MSG", "用户名或密码不正确！");
			request.getRequestDispatcher("houtai/404.jsp").forward(request, response);
		}
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		

}
