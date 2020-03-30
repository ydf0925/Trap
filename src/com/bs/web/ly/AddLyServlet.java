
package com.bs.web.ly;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.Ly;
import com.bs.factory.BasicFactory;
import com.bs.service.LyService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午7:51:34 
* @version 1.0 
*/
public class AddLyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 3475820876866749357L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		LyService service=BasicFactory.getFactory().getService(LyService.class);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String content=request.getParameter("content");
		Ly ly=new Ly();
		ly.setName(name);
		ly.setEmail(email);
		ly.setTel(tel);
		ly.setContent(content);
		service.addLy(ly);
		request.getRequestDispatcher("qiantai/ly.jsp").forward(request, response);
	}
}
