
package com.bs.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bs.entity.User;
import com.bs.factory.BasicFactory;
import com.bs.service.UserService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午1:30:32 
* @version 1.0 
*/
public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 6469360752946788449L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		UserService service=BasicFactory.getFactory().getService(UserService.class);
		int page=1;
		String pageIndex=request.getParameter("page");
		String rows=request.getParameter("rows");
		if(pageIndex !=null)
			page=Integer.parseInt(pageIndex);
		int pageSize=Integer.parseInt(rows);
		PageUtil<User> pageBean=service.selectUserList(page, pageSize);
		if(pageBean!=null) {
			PrintWriter out=response.getWriter();
			JSONObject json=new JSONObject();
			json.put("page", pageBean.getCurrentPage());
			json.put("total", pageBean.getTotalPage());
			json.put("records", pageBean.getTotalRecord());
			json.put("rows",JSONArray.parseArray(JSON.toJSONString(pageBean.getDataList())));
			
//			  request.setAttribute("page", pageBean);
//			  request.getRequestDispatcher("houtai/user.jsp").forward(request, response);
			 
			out.print(json);
		}
	}
}
