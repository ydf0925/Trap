
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
* @date 创建时间：2019年9月25日 上午10:35:12 
* @version 1.0 
*/
public class AddFwxmServlet extends HttpServlet {

	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		FwxmService service=BasicFactory.getFactory().getService(FwxmService.class);
		String content=request.getParameter("content");
		Fwxm fwxm=new Fwxm();
		fwxm.setContent(content);
		service.addFwxm(fwxm);
		}
}
