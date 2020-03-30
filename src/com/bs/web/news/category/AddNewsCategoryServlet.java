
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
* @date 创建时间：2019年9月14日 下午7:34:16 
* @version 1.0 
*/
public class AddNewsCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		NewsCategoryService service=BasicFactory.getFactory().getService(NewsCategoryService.class);
		String name=request.getParameter("name");
		NewsCategory category=new NewsCategory();
		category.setName(name);
		service.addNewsCategory(category);
		}
}
