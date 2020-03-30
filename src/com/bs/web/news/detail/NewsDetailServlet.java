
package com.bs.web.news.detail;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.News;
import com.bs.entity.NewsCategory;
import com.bs.factory.BasicFactory;
import com.bs.service.NewsCategoryService;
import com.bs.service.NewsService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午9:36:19 
* @version 1.0 
*/
public class NewsDetailServlet extends HttpServlet{

	private static final long serialVersionUID = 8362524790690200446L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		NewsCategoryService service=BasicFactory.getFactory().getService(NewsCategoryService.class);
		NewsService newsService=BasicFactory.getFactory().getService(NewsService.class);
		String id=request.getParameter("id");
		List<NewsCategory> menu=service.selectList();
		News news=newsService.selectById(Integer.parseInt(id));
		if(id!=null && !"1".equals(id)) {
			News prenews=newsService.selectById(Integer.parseInt(id)-1);
			request.setAttribute("prenews",prenews);
		}
		News nextnews=newsService.selectById(Integer.parseInt(id)+1);
		request.setAttribute("nextnews",nextnews);
		request.setAttribute("menu",menu);
		request.setAttribute("news",news);
		request.getRequestDispatcher("qiantai/xw-nr.jsp").forward(request, response);
	}
}
