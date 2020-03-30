
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
* @date 创建时间：2019年9月17日 下午3:53:59 
* @version 1.0 
*/
public class UpdateCaseServlet extends HttpServlet{
	private static final long serialVersionUID = -446459432167730112L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		CaseService service=BasicFactory.getFactory().getService(CaseService.class);
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String cid=request.getParameter("cid");
		String content=request.getParameter("content");
		String imgname=request.getParameter("img");
		Case cases=new Case();
		cases.setId(Integer.parseInt(id));
		cases.setTitle(title);
		cases.setCid(Integer.parseInt(cid));
		cases.setContent(content);
		cases.setImgname(imgname);
		service.updateCase(cases);
		response.getWriter().print(1);
		}
}
