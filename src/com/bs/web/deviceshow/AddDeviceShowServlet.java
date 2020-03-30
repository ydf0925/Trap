
package com.bs.web.deviceshow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.DeviceShow;
import com.bs.factory.BasicFactory;
import com.bs.service.DeviceShowService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:30:30 
* @version 1.0 
*/
public class AddDeviceShowServlet extends HttpServlet {

	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		DeviceShowService service=BasicFactory.getFactory().getService(DeviceShowService.class);
		String name=request.getParameter("name");
		DeviceShow deviceShow=new DeviceShow();
		deviceShow.setName(name);
		service.addDeviceShow(deviceShow);
		}
}

