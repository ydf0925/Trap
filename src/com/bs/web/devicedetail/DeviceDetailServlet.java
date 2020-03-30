
package com.bs.web.devicedetail;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.Device;
import com.bs.entity.DeviceShow;
import com.bs.factory.BasicFactory;
import com.bs.service.DeviceService;
import com.bs.service.DeviceShowService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:37:50 
* @version 1.0 
*/
public class DeviceDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 8362524790690200446L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		DeviceShowService service=BasicFactory.getFactory().getService(DeviceShowService.class);
		DeviceService deviceService=BasicFactory.getFactory().getService(DeviceService.class);
		String id=request.getParameter("id");
		List<DeviceShow> menu=service.selectList();
		Device device=deviceService.selectById(Integer.parseInt(id));
		if(id!=null && !"1".equals(id)) {
			Device prenDevice=deviceService.selectById(Integer.parseInt(id)-1);
			request.setAttribute("prenDevice",prenDevice);
		}
		Device nextDevice=deviceService.selectById(Integer.parseInt(id)+1);
		request.setAttribute("nextDevice",nextDevice);
		request.setAttribute("menu",menu);
		request.setAttribute("device",device);
		request.getRequestDispatcher("qiantai/dp-nr.jsp").forward(request, response);
	}
}
