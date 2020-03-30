
package com.bs.web.fwxm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.Fwxm;
import com.bs.factory.BasicFactory;
import com.bs.service.FwxmService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月25日 上午10:38:06 
* @version 1.0 
*/
public class UpdateFwxmServlet extends HttpServlet{

	private static final long serialVersionUID = -446459432167730112L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		FwxmService service=BasicFactory.getFactory().getService(FwxmService.class);
		String id=request.getParameter("id");
		String content=request.getParameter("content");
		Fwxm fwxm=new Fwxm();
		fwxm.setId(Integer.parseInt(id));
		fwxm.setContent(content);
		service.updateFwxm(fwxm);
		response.getWriter().print(1);
		}
}

