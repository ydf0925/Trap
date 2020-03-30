
package com.bs.web.index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.entity.About;
import com.bs.entity.Case;
import com.bs.entity.CaseShow;
import com.bs.entity.Device;
import com.bs.entity.Link;
import com.bs.entity.News;
import com.bs.factory.BasicFactory;
import com.bs.service.AboutService;
import com.bs.service.CaseService;
import com.bs.service.CaseShowService;
import com.bs.service.DeviceService;
import com.bs.service.LinkService;
import com.bs.service.NewsService;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午10:25:54 
* @version 1.0 
*/
public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = -9037677710786120070L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		NewsService newsService=BasicFactory.getFactory().getService(NewsService.class);
		CaseShowService caseService=BasicFactory.getFactory().getService(CaseShowService.class);
		CaseService casesService = BasicFactory.getFactory().getService(CaseService.class);
		DeviceService deviceService=BasicFactory.getFactory().getService(DeviceService.class);
		LinkService linkService=BasicFactory.getFactory().getService(LinkService.class);
		AboutService aboutService=BasicFactory.getFactory().getService(AboutService.class);

		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		PageUtil<News> pageBean=newsService.selectNewsList(Integer.parseInt(page), Integer.parseInt(rows));
		PageUtil<CaseShow> caseBean=caseService.selectCaseShowList(Integer.parseInt(page), Integer.parseInt(rows));
		PageUtil<Case> casesBean=casesService.selectCaseImgList(Integer.parseInt(page), Integer.parseInt(rows));
		PageUtil<Device> deviceBean=deviceService.selectDeviceList(Integer.parseInt(page), Integer.parseInt(rows));
		PageUtil<Link> linkBean=linkService.selectLinkList(Integer.parseInt(page), Integer.parseInt(rows));
		PageUtil<About> aboutBean=aboutService.selectAboutList(Integer.parseInt(page), Integer.parseInt(rows));

		if(pageBean!=null) {
			request.setAttribute("news",pageBean.getDataList());
		}
		if(caseBean!=null) {
			request.setAttribute("menu",caseBean.getDataList());
		}
		if(casesBean!=null) {
			request.setAttribute("cases",casesBean.getDataList());
		}
		if(deviceBean!=null) {
			request.setAttribute("device",deviceBean.getDataList());
		}
		if(linkBean!=null) {
			session.setAttribute("link",linkBean.getDataList());
		}
		if(aboutBean!=null) {
			request.setAttribute("about",aboutBean.getDataList());
		}
		request.getRequestDispatcher("qiantai/index.jsp").forward(request, response);
	}
}
