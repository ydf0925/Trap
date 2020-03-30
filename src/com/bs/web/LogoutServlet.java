package com.bs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.entity.User;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:58:20 
* @version 1.0 
*/
public class LogoutServlet extends HttpServlet {

	
	private static final long serialVersionUID = -5087555541324382132L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user!=null) {
			session.removeAttribute("user");
		}
			response.sendRedirect("login.jsp");
	}

}
