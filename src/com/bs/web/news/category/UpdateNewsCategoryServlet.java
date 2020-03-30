
package com.bs.web.news.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.NewsCategory;
import com.bs.factory.BasicFactory;
import com.bs.service.NewsCategoryService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:36:51 
* @version 1.0 
*/
public class UpdateNewsCategoryServlet extends HttpServlet{

	private static final long serialVersionUID = -446459432167730112L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		NewsCategoryService service=BasicFactory.getFactory().getService(NewsCategoryService.class);
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		NewsCategory category=new NewsCategory();
		category.setId(Integer.parseInt(id));
		category.setName(name);
		service.updateNewsCategory(category);
		response.getWriter().print(1);
		}
}
