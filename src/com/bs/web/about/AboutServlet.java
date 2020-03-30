
package com.bs.web.about;

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
import com.bs.entity.About;
import com.bs.factory.BasicFactory;
import com.bs.service.AboutService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月23日 下午3:10:12 
* @version 1.0 
*/
public class AboutServlet extends HttpServlet{

	private static final long serialVersionUID = -7687033179269355375L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		AboutService service=BasicFactory.getFactory().getService(AboutService.class);
		int page=1;
		String pageIndex=request.getParameter("page");
		String rows=request.getParameter("rows");
		String flag=request.getParameter("flag");
		String ab=request.getParameter("ab");
		if(pageIndex !=null)
			page=Integer.parseInt(pageIndex);
		int pageSize=Integer.parseInt(rows);
		PageUtil<About> pageBean=service.selectAboutList(page,pageSize);
		if(pageBean!=null) {
			PrintWriter out=response.getWriter();
			JSONObject json=new JSONObject();
			List<About> list=pageBean.getDataList();
			if(flag!=null && !"".equals(flag)) {
				String html="<select>";
				for (About about : list) {
					html+="<option value='"+about.getId()+"'>"+about.getContent()+"</option>";
				}
				html+="</select>";
				out.print(html);
			}else if(ab!=null && !"".equals(ab)){
					request.setAttribute("menu",list);
					request.getRequestDispatcher("qiantai/about.jsp").forward(request, response);
				
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

