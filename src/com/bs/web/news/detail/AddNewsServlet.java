
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
* @date 创建时间：2019年9月14日 下午7:34:16 
* @version 1.0 
*/
public class AddNewsServlet extends HttpServlet {

	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		NewsService service=BasicFactory.getFactory().getService(NewsService.class);
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String cid=request.getParameter("cname");
		String content=request.getParameter("content");
		News news=new News();
		news.setTitle(title);
		news.setAuthor(author);
		news.setCid(Integer.parseInt(cid));
		news.setContent(content);
		service.addNews(news);
		}
}
