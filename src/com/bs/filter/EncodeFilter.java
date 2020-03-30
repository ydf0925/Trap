package com.bs.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:58:20 
* @version 1.0 
*/
public class EncodeFilter implements Filter{
	private ServletContext context=null;
	private String encode=null;
	boolean isNotEncode=true;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		//响应乱码解决
		response.setCharacterEncoding("utf-8");//通知服务器
		response.setContentType("text/html;charset=utf-8");//通知浏览器
		//利用装饰设计模式改变request对象和获取相关的方法，从而解决请求参数乱码问题
		arg2.doFilter(new MyHttpServletRequest((HttpServletRequest)request), response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		this.context=arg0.getServletContext();
		// 接收web.xml配置文件中的初始参数
		this.encode=context.getInitParameter("encode");
		
	}
	private class MyHttpServletRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request=null;
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		@Override
		public Map<String, String[]> getParameterMap() {
			try {
				if(request.getMethod().equalsIgnoreCase("POST")){
					request.setCharacterEncoding(encode);
					return request.getParameterMap();
				}else if(request.getMethod().equalsIgnoreCase("GET")){
						Map<String,String[]> map=request.getParameterMap();
						if(isNotEncode){
						for(Map.Entry<String, String[]> entry : map.entrySet()){
							String [] vs=entry.getValue();
							for(int i=0;i<vs.length;i++){
								vs[i]=new String(vs[i].getBytes("iso8859-1"),encode);
							}
						}
						isNotEncode=false;
					}
					return map;
				}else{
					return request.getParameterMap();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return super.getParameterMap();
		}
		@Override
		public String getParameter(String name) {
			return getParameterValues(name)==null?null:getParameterValues(name)[0];
		}
		@Override
		public String[] getParameterValues(String name) {
			return (String[]) getParameterMap().get(name);
		}
	}

}
