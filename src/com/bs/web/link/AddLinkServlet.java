
package com.bs.web.link;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.Link;
import com.bs.factory.BasicFactory;
import com.bs.service.LinkService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月19日 上午11:05:06 
* @version 1.0 
*/
public class AddLinkServlet extends HttpServlet {

	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		LinkService service=BasicFactory.getFactory().getService(LinkService.class);
		String name=request.getParameter("name");
		String content=request.getParameter("content");
		Link link=new Link();
		link.setName(name);
		link.setContent(content);
		service.addLink(link);
		}
}

