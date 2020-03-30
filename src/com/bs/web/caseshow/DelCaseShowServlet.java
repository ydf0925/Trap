
package com.bs.web.caseshow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.factory.BasicFactory;
import com.bs.service.CaseShowService;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月16日 下午8:53:13 
* @version 1.0 
*/
	public class DelCaseShowServlet extends HttpServlet{

		private static final long serialVersionUID = -2901607666522918394L;

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			CaseShowService service=BasicFactory.getFactory().getService(CaseShowService.class);
			String id=request.getParameter("id");
			service.deleteCaseShow(Integer.parseInt(id));
			response.getWriter().print(1);;
			}
	}

