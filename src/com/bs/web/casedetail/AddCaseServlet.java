
package com.bs.web.casedetail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.Case;
import com.bs.factory.BasicFactory;
import com.bs.service.CaseService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午3:48:21 
* @version 1.0 
*/
public class AddCaseServlet extends HttpServlet{
	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		CaseService service=BasicFactory.getFactory().getService(CaseService.class);
		String title=request.getParameter("title");
		String cid=request.getParameter("cname");
		String content=request.getParameter("content");
		Case cases=new Case();
		cases.setTitle(title);
		cases.setCid(Integer.parseInt(cid));
		cases.setContent(content);
		service.addCase(cases);

		}
}
