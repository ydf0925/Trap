
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
* @date 创建时间：2019年9月23日 下午3:07:42 
* @version 1.0 
*/
public class AddAboutServlet extends HttpServlet {

	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		AboutService service=BasicFactory.getFactory().getService(AboutService.class);
		String content=request.getParameter("content");
		About about=new About();
		about.setContent(content);
		service.addAbout(about);
		}
}
