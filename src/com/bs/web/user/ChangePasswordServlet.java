
package com.bs.web.user;

import java.io.IOException;
import java.io.PrintWriter;

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
* @date 创建时间：2019年9月15日 上午8:28:14 
* @version 1.0 
*/
public class ChangePasswordServlet extends HttpServlet{
	private static final long serialVersionUID = 2433718971821287421L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		UserService service=BasicFactory.getFactory().getService(UserService.class);
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("password");
		PrintWriter out=response.getWriter();
		User user=service.selectByNameAndPaw(username, MD5Utils.md5(oldpassword));
		if(user==null) {
			out.print(3);
		}else {
			service.changePass(Integer.parseInt(id), MD5Utils.md5(newpassword));
			out.print(1);
		}
	}
}
