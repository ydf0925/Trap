
package com.bs.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.factory.BasicFactory;
import com.bs.service.UserService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午5:50:50 
* @version 1.0 
*/
public class DelUserServlet extends HttpServlet{

	private static final long serialVersionUID = 6985054348404696846L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service=BasicFactory.getFactory().getService(UserService.class);
		String id=request.getParameter("id");
		service.deleteUser(Integer.parseInt(id));
		response.getWriter().print(1);;
		}
}
