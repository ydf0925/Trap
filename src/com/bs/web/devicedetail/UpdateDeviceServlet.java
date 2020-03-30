
package com.bs.web.devicedetail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.entity.Device;
import com.bs.factory.BasicFactory;
import com.bs.service.DeviceService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:46:18 
* @version 1.0 
*/
public class UpdateDeviceServlet extends HttpServlet{
	private static final long serialVersionUID = -446459432167730112L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		DeviceService service=BasicFactory.getFactory().getService(DeviceService.class);
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String cid=request.getParameter("cid");
		String content=request.getParameter("content");
		String imgname=request.getParameter("img2");
		Device device=new Device();
		device.setId(Integer.parseInt(id));
		device.setTitle(title);
		device.setCid(Integer.parseInt(cid));
		device.setContent(content);
		device.setImgname(imgname);
		service.updateDevice(device);
		response.getWriter().print(1);
		}
}
