
package com.bs.web.news.category;

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
import com.bs.entity.News;
import com.bs.entity.NewsCategory;
import com.bs.factory.BasicFactory;
import com.bs.service.NewsCategoryService;
import com.bs.service.NewsService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:28:59 
* @version 1.0 
*/
public class NewsCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = -7687033179269355375L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		NewsCategoryService service=BasicFactory.getFactory().getService(NewsCategoryService.class);
		NewsService newsService=BasicFactory.getFactory().getService(NewsService.class);
		int page=1;
		String pageIndex=request.getParameter("page");
		String rows=request.getParameter("rows");
		String flag=request.getParameter("flag");
		String xw=request.getParameter("xw");
		String cid=request.getParameter("cid");
		if(pageIndex !=null)
			page=Integer.parseInt(pageIndex);
		int pageSize=Integer.parseInt(rows);
		PageUtil<NewsCategory> pageBean=service.selectNewsCategoryList(page,pageSize);
		if(pageBean!=null) {
			PrintWriter out=response.getWriter();
			JSONObject json=new JSONObject();
			List<NewsCategory> list=pageBean.getDataList();
			if(flag!=null && !"".equals(flag)) {
				String html="<select>";
				for (NewsCategory newsCategory : list) {
					html+="<option value='"+newsCategory.getId()+"'>"+newsCategory.getName()+"</option>";
				}
				html+="</select>";
				out.print(html);
			}else if(xw!=null && !"".equals(xw)){
				if(list!=null && list.size()>0) {
					if(cid==null) {
						cid=list.get(0).getId()+"";
					}
					List<News> newsList=newsService.selectByCid(Integer.parseInt(cid));
					request.setAttribute("menu",list);
					request.setAttribute("news",newsList);
					request.getRequestDispatcher("qiantai/xw.jsp").forward(request, response);
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
