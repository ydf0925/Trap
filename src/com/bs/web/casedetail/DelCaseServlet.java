
package com.bs.web.casedetail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.factory.BasicFactory;
import com.bs.service.CaseService;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午3:51:40 
* @version 1.0 
*/
public class DelCaseServlet extends HttpServlet{
	private static final long serialVersionUID = -2901607666522918394L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CaseService service=BasicFactory.getFactory().getService(CaseService.class);
		String id=request.getParameter("id");
		service.deleteCase(Integer.parseInt(id));
		response.getWriter().print(1);;
		}
}
