
package com.bs.web.fwxm;

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
import com.bs.entity.Fwxm;
import com.bs.factory.BasicFactory;
import com.bs.service.FwxmService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月25日 上午10:32:20 
* @version 1.0 
*/
public class FwxmServlet extends HttpServlet{

	private static final long serialVersionUID = -7687033179269355375L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		FwxmService service=BasicFactory.getFactory().getService(FwxmService.class);
		int page=1;
		String pageIndex=request.getParameter("page");
		String rows=request.getParameter("rows");
		String flag=request.getParameter("flag");
		String fw=request.getParameter("fw");
		if(pageIndex !=null)
			page=Integer.parseInt(pageIndex);
		int pageSize=Integer.parseInt(rows);
		PageUtil<Fwxm> pageBean=service.selectFwxmList(page,pageSize);
		if(pageBean!=null) {
			PrintWriter out=response.getWriter();
			JSONObject json=new JSONObject();
			List<Fwxm> list=pageBean.getDataList();
			if(flag!=null && !"".equals(flag)) {
				String html="<select>";
				for (Fwxm fwxm : list) {
					html+="<option value='"+fwxm.getId()+"'>"+fwxm.getContent()+"</option>";
				}
				html+="</select>";
				out.print(html);
			}else if(fw!=null && !"".equals(fw)){
					request.setAttribute("menu",list);
					request.getRequestDispatcher("qiantai/fwxm.jsp").forward(request, response);
				
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
