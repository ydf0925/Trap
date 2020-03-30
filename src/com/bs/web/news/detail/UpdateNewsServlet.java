
package com.bs.web.news.detail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.News;
import com.bs.factory.BasicFactory;
import com.bs.service.NewsService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:36:51 
* @version 1.0 
*/
public class UpdateNewsServlet extends HttpServlet{

	private static final long serialVersionUID = -446459432167730112L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		NewsService service=BasicFactory.getFactory().getService(NewsService.class);
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String cid=request.getParameter("cid");
		String content=request.getParameter("content");
		News news=new News();
		news.setId(Integer.parseInt(id));
		news.setTitle(title);
		news.setAuthor(author);
		news.setCid(Integer.parseInt(cid));
		news.setContent(content);
		service.updateNews(news);
		response.getWriter().print(1);
		}
}
