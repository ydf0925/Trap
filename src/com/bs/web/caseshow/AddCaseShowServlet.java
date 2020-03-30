
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
* @date 创建时间：2019年9月16日 下午8:47:16 
* @version 1.0 
*/

	public class AddCaseShowServlet extends HttpServlet {

		private static final long serialVersionUID = -9157312739552849280L;

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			CaseShowService service=BasicFactory.getFactory().getService(CaseShowService.class);
			String name=request.getParameter("name");
			CaseShow caseShow=new CaseShow();
			caseShow.setName(name);
			service.addCaseShow(caseShow);
			}
	}


