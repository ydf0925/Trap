
package com.bs.web.link;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.factory.BasicFactory;
import com.bs.service.LinkService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月19日 上午11:06:57 
* @version 1.0 
*/
public class DelLinkServlet extends HttpServlet{

	private static final long serialVersionUID = -2901607666522918394L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LinkService service=BasicFactory.getFactory().getService(LinkService.class);
		String id=request.getParameter("id");
		service.deleteLink(Integer.parseInt(id));
		response.getWriter().print(1);;
		}
}