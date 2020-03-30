
package com.bs.web.casedetail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.Case;
import com.bs.entity.CaseShow;
import com.bs.factory.BasicFactory;
import com.bs.service.CaseService;
import com.bs.service.CaseShowService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午3:29:46 
* @version 1.0 
*/
public class CaseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 8362524790690200446L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		CaseShowService service=BasicFactory.getFactory().getService(CaseShowService.class);
		CaseService caseService=BasicFactory.getFactory().getService(CaseService.class);
		String id=request.getParameter("id");
		List<CaseShow> menu=service.selectList();
		Case cases=caseService.selectById(Integer.parseInt(id));
		if(id!=null && !"1".equals(id)) {
			Case prencase=caseService.selectById(Integer.parseInt(id)-1);
			request.setAttribute("prencase",prencase);
		}
		Case nextcase=caseService.selectById(Integer.parseInt(id)+1);
		request.setAttribute("nextcase",nextcase);
		request.setAttribute("menu",menu);
		request.setAttribute("cases",cases);
		request.getRequestDispatcher("qiantai/cp-nr.jsp").forward(request, response);
	}
}
