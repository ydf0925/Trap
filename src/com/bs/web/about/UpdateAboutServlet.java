
package com.bs.web.about;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.About;
import com.bs.factory.BasicFactory;
import com.bs.service.AboutService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午3:17:01 
* @version 1.0 
*/
public class UpdateAboutServlet extends HttpServlet{

	private static final long serialVersionUID = -446459432167730112L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		AboutService service=BasicFactory.getFactory().getService(AboutService.class);
		String id=request.getParameter("id");
		String content=request.getParameter("content");
		About about=new About();
		about.setId(Integer.parseInt(id));
		about.setContent(content);
		service.updateAbout(about);
		response.getWriter().print(1);
		}
}

