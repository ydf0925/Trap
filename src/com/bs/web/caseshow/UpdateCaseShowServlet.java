
package com.bs.web.caseshow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.CaseShow;
import com.bs.factory.BasicFactory;
import com.bs.service.CaseShowService;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月16日 下午9:02:23 
* @version 1.0 
*/
	public class UpdateCaseShowServlet extends HttpServlet{

		private static final long serialVersionUID = -446459432167730112L;

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			CaseShowService service=BasicFactory.getFactory().getService(CaseShowService.class);
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			CaseShow caseShow=new CaseShow();
			caseShow.setId(Integer.parseInt(id));
			caseShow.setName(name);
			service.updateCaseShow(caseShow);
			response.getWriter().print(1);
			}
	}


