
package com.bs.web.devicedetail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bs.entity.Device;
import com.bs.factory.BasicFactory;
import com.bs.service.DeviceService;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:42:19 
* @version 1.0 
*/
public class AddDeviceServlet extends HttpServlet{
	private static final long serialVersionUID = -9157312739552849280L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		DeviceService service=BasicFactory.getFactory().getService(DeviceService.class);
		String title=request.getParameter("title");
		String cid=request.getParameter("cname");
		String content=request.getParameter("content");
		Device device=new Device();
		device.setTitle(title);
		device.setCid(Integer.parseInt(cid));
		device.setContent(content);
		service.addDevice(device);

		}
}
