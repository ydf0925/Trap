
package com.bs.web.devicedetail;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;

/** 
 * @author 作者 :yuedengfeng
 * @date 创建时间：2019年9月17日 下午3:48:21 
 * @version 1.0 
 */
public class UploadImgServlet extends HttpServlet{
	private static final long serialVersionUID = -9157312739552849280L;

	// 保存文件的目录
		private static String PATH_FOLDER = "D:\\images\\upload";
		// 存放临时文件的目录
		private static String TEMP_FOLDER = "D:\\images\\cache";
		
			
		/**
		 * Constructor of the object.
		 */
		public UploadImgServlet() {
			super();
		}
	 
		/**
		 * Destruction of the servlet. <br>
		 */
		public void destroy() {
			super.destroy(); // Just puts "destroy" string in log
			// Put your code here
		}
	 
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	 
			this.doPost(request, response);
		}
	 
		public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 结果json对象
			JSONObject jsonobj = new JSONObject();
			int returnTag = -1;
			String saveName=null;
			//上传的文件名
			String filename=null;
			try {
				System.out.println("==========以下为上传代码============");
				request.setCharacterEncoding("utf-8"); // 设置编码
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");
				// 获得磁盘文件条目工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
	 
				// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
				// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
				/**
				 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以
				 * .tem 格式的 然后再将其真正写到 对应目录的硬盘上
				 */
				factory.setRepository(new File(TEMP_FOLDER));
				// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
				factory.setSizeThreshold(1024 * 1024);
				
				// 高水平的API文件上传处理
				ServletFileUpload upload = new ServletFileUpload(factory);
	 
				// 提交上来的信息都在这个list里面
				// 这意味着可以上传多个文件
				// 请自行组织代码
				List<FileItem> list = upload.parseRequest(request);
				
				// 获取上传的文件
				for (FileItem file : list) {
					FileItem item = file;
					// 获取文件名
					 filename = getUploadFileName(item);
					System.out.println("获取的文件名============================"
							+ filename);
					String suffix = filename
							.substring(filename.lastIndexOf(".") + 1);
					System.out
							.println("获取的文件后缀名=========================" + suffix);
					String[] regular = { "JPG", "GIF","PNG","JPEG" ,"BMP"};
					boolean flag = false;
					// 判断文件格式是否合法
					for (String str : regular) {
						if (suffix.equalsIgnoreCase(str)) {
							flag = true;
						}
					}
					if (!flag) {
						returnTag = 0;
						throw new Exception("文件格式不合法！");
					}
	 
					// 保存后的文件名
					 saveName = new Date().getTime()
							+ filename.substring(filename.lastIndexOf("."));
					 
					 
	 
					System.out.println("存放目录:=================================="
							+ PATH_FOLDER);
					System.out.println("文件名:===================================="
							+ filename);
					// 真正写到磁盘上
					item.write(new File(PATH_FOLDER, saveName)); // 第三方提供的
				/*
				 * CaseService service=BasicFactory.getFactory().getService(CaseService.class);
				 * Case cases=new Case(); String id=request.getParameter("id");
				 * System.out.println(id); cases.setId(Integer.parseInt(id));
				 * cases.setImgname(saveName); service.updateCase(cases);
				 */
					
				}
				System.out.println("==========以上为上传代码=============");
				if (returnTag != -1) {
					// 请求失败
					jsonobj.put("code", "1");
				} else {
					jsonobj.put("code", 0);
					jsonobj.put("filename", saveName);
				}
				response.getWriter().write(jsonobj.toString());
				response.getWriter().close();
			} catch (Exception e) {
				e.printStackTrace();
				jsonobj.put("errorCode", 0);
				response.getWriter().write(jsonobj.toString());
				response.getWriter().close();
	 
			}
		}
		private String getUploadFileName(FileItem item) {
			// 获取路径名
			String value = item.getName();
			// 索引到最后一个反斜杠
			int start = value.lastIndexOf("/");
			// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
			String filename = value.substring(start + 1);
	 
			return filename;
		}

}
