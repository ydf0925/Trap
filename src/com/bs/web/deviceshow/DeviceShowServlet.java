
package com.bs.web.deviceshow;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bs.entity.Device;
import com.bs.entity.DeviceShow;
import com.bs.factory.BasicFactory;
import com.bs.service.DeviceService;
import com.bs.service.DeviceShowService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午3:56:17 
* @version 1.0 
*/
public class DeviceShowServlet extends HttpServlet{

	private static final long serialVersionUID = -7687033179269355375L;

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
		int page=1;
		String pageIndex=request.getParameter("page");
		String rows=request.getParameter("rows");
		String flag=request.getParameter("flag");
		String dp=request.getParameter("dp");
		String cid=request.getParameter("cid");
		if(pageIndex !=null)
			page=Integer.parseInt(pageIndex);
		int pageSize=Integer.parseInt(rows);
		PageUtil<DeviceShow> pageBean=service.selectDeviceShowList(page,pageSize);
		if(pageBean!=null) {
			PrintWriter out=response.getWriter();
			JSONObject json=new JSONObject();
			List<DeviceShow> list=pageBean.getDataList();
			if(flag!=null && !"".equals(flag)) {
				String html="<select>";
				for (DeviceShow deviceShow : list) {
					html+="<option value='"+deviceShow.getId()+"'>"+deviceShow.getName()+"</option>";
				}
				html+="</select>";
				out.print(html);
			}else if(dp!=null && !"".equals(dp)){
				if(list!=null && list.size()>0) {
					if(cid==null) {
						cid=list.get(0).getId()+"";
					}
					List<Device> deviceList=deviceService.selectByCid(Integer.parseInt(cid));
					request.setAttribute("menu",list);
					request.setAttribute("deviceList",deviceList);
					request.getRequestDispatcher("qiantai/dp.jsp").forward(request, response);
				}
			}else {
				json.put("page", pageBean.getCurrentPage());
				json.put("total", pageBean.getTotalPage());
				json.put("records", pageBean.getTotalRecord());
				json.put("rows",JSONArray.parseArray(JSON.toJSONString(list)));
				out.print(json);
			}
			
		}
	}
}
