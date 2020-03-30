
package com.bs.web.about;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.factory.BasicFactory;
import com.bs.service.AboutService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午3:15:42 
* @version 1.0 
*/
public class DelAboutServlet extends HttpServlet{

	private static final long serialVersionUID = -2901607666522918394L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AboutService service=BasicFactory.getFactory().getService(AboutService.class);
		String id=request.getParameter("id");
		service.deleteAbout(Integer.parseInt(id));
		response.getWriter().print(1);;
		}
}
