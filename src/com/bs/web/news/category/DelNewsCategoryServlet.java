
package com.bs.web.news.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.factory.BasicFactory;
import com.bs.service.NewsCategoryService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:38:41 
* @version 1.0 
*/
public class DelNewsCategoryServlet extends HttpServlet{

	private static final long serialVersionUID = -2901607666522918394L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsCategoryService service=BasicFactory.getFactory().getService(NewsCategoryService.class);
		String id=request.getParameter("id");
		service.deleteNewsCategory(Integer.parseInt(id));
		response.getWriter().print(1);;
		}
}
