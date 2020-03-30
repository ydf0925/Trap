
package com.bs.web.caseshow;

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
import com.bs.entity.Case;
import com.bs.entity.CaseShow;
import com.bs.factory.BasicFactory;
import com.bs.service.CaseService;
import com.bs.service.CaseShowService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月16日 下午8:55:53 
* @version 1.0 
*/
	public class CaseShowServlet extends HttpServlet{

		private static final long serialVersionUID = -7687033179269355375L;

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request, response);
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			CaseShowService service=BasicFactory.getFactory().getService(CaseShowService.class);
			CaseService caseService=BasicFactory.getFactory().getService(CaseService.class);
			int page=1;
			String pageIndex=request.getParameter("page");
			String rows=request.getParameter("rows");
			String flag=request.getParameter("flag");
			String cp=request.getParameter("cp");
			String cid=request.getParameter("cid");
			if(pageIndex !=null)
				page=Integer.parseInt(pageIndex);
			int pageSize=Integer.parseInt(rows);
			//获取当前点击页面的数据（pageBean前台传出来一个页面显示多少条，和页码数）
			PageUtil<CaseShow> pageBean=service.selectCaseShowList(page,pageSize);
			if(pageBean!=null) {
				PrintWriter out=response.getWriter();
				JSONObject json=new JSONObject();
				List<CaseShow> list=pageBean.getDataList();
				if(flag!=null && !"".equals(flag)) {
					String html="<select>";
					for (CaseShow caseShow : list) {
						html+="<option value='"+caseShow.getId()+"'>"+caseShow.getName()+"</option>";
					}
					html+="</select>";
					out.print(html);
				}else if(cp!=null && !"".equals(cp)){
					if(list!=null && list.size()>0) {
						if(cid==null) {
							cid=list.get(0).getId()+"";
						}
						List<Case> caseList=caseService.selectByCid(Integer.parseInt(cid));
						request.setAttribute("menu",list);
						request.setAttribute("caseList",caseList);
						request.getRequestDispatcher("qiantai/cp.jsp").forward(request, response);
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
