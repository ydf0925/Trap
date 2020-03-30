
package com.bs.web.deviceshow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.factory.BasicFactory;
import com.bs.service.DeviceShowService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:33:14 
* @version 1.0 
*/
public class DelDeviceShowServlet extends HttpServlet{

	private static final long serialVersionUID = -2901607666522918394L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeviceShowService service=BasicFactory.getFactory().getService(DeviceShowService.class);
		String id=request.getParameter("id");
		service.deleteDeviceShow(Integer.parseInt(id));
		response.getWriter().print(1);;
		}
}
