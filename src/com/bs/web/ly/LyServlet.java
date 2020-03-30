
package com.bs.web.ly;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bs.entity.Ly;
import com.bs.factory.BasicFactory;
import com.bs.service.LyService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午7:42:01 
* @version 1.0 
*/
public class LyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 2624516037967522617L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		LyService service=BasicFactory.getFactory().getService(LyService.class);
		int page=1;
		String pageIndex=request.getParameter("page");
		String rows=request.getParameter("rows");
		String flag=request.getParameter("flag");
		if(flag!=null) {
			request.getRequestDispatcher("qiantai/ly.jsp").forward(request, response);
		}else {
			if(pageIndex !=null)
				page=Integer.parseInt(pageIndex);
			int pageSize=Integer.parseInt(rows);
			PageUtil<Ly> pageBean=service.selectLyList(page, pageSize);
			if(pageBean!=null) {
				PrintWriter out=response.getWriter();
				JSONObject json=new JSONObject();
				json.put("page", pageBean.getCurrentPage());
				json.put("total", pageBean.getTotalPage());
				json.put("records", pageBean.getTotalRecord());
				json.put("rows",JSONArray.parseArray(JSON.toJSONString(pageBean.getDataList())));
				out.print(json);
			}
		}
	}
}
