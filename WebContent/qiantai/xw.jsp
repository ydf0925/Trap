<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Trap公司</title>
<link rel="shortcut icon" href="<%=path%>/static/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/qiantai/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/qiantai/css/css.css" />
</head>

<body>
	<!--==========================Head Start==========================-->
	<div class="heads">
		<div class="heads-m">
			<div class="heads-m-t">
				<span class="l">欢迎来到Trap公司官网！</span><span class="r"
					style="padding-right: 10px;"><a href="#"></a> <a href="#"></a></span>
			</div>
			<div class="heads-m-bm">
				<div class="logo">
					<a href="#" target="_blank"><img
						src="<%=path%>/qiantai/images/logo.png" width="237" height="100" /></a>
				</div>
				<div class="logo_r">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500">网站首页</a></li>
						<li><a
							href="${pageContext.request.contextPath}/AboutServlet?page=1&rows=500&ab=1">公司简介</a></li>
						<li><a
							href="${pageContext.request.contextPath}/NewsCategoryServlet?page=1&rows=500&xw=1">新闻动态</a></li>
						<li><a
							href="${pageContext.request.contextPath}/FwxmServlet?page=1&rows=500&fw=1">服务项目</a></li>
						<li><a
							href="${pageContext.request.contextPath}/DeviceShowServlet?page=1&rows=5000&dp=1">设备展示</a></li>
						<li><a
							href="${pageContext.request.contextPath}/CaseShowServlet?page=1&rows=5000&cp=1">案例展示</a></li>
						<li><a
							href="${pageContext.request.contextPath}/LyServlet?flag=1">在线留言</a></li>
						<li><a href="<%=path%>/qiantai/lxwm.jsp">联系我们</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--==========================Head End=============================-->
	<div class="about-banner"></div>
	<!--==========================centent Start=============================-->
	<div class="center clearfix">
		<div class="ab-left l">
			<div class="ab-left-t">
				<div class="ab-left-t2">新闻动态</div>
				<div class="ab-left-nav clearfix">
					<ul>
						<c:forEach items="${menu}" var="m">
							<LI><a
								href="${pageContext.request.contextPath}/NewsCategoryServlet?page=1&rows=500&xw=1&cid=${m.id}">${m.name}</a></LI>
						</c:forEach>
						<!-- <LI><a href="#" class="xz">公司新闻</a></LI>
  <LI><a href="#">行业新闻</a></LI>
  <LI><a href="#">媒体报道</a></LI> -->
					</ul>
				</div>
			</div>
			<div class="ab-left-bm">
				<a href="https://www.amap.com/"><img
					src="<%=path%>/qiantai/images/leftlx_01.jpg" width="206"
					height="60" /></a> <a
					href="${pageContext.request.contextPath}/LyServlet?flag=1"><img
					src="<%=path%>/qiantai/images/leftlx_02.jpg" width="206"
					height="56" /></a> <a href="<%=path%>/qiantai/lxwm.jsp"><img
					src="<%=path%>/qiantai/images/leftlx_03.jpg" width="206"
					height="54" /></a>

			</div>
		</div>

		<div class="ab-right r clearfix">
			<div class="ab-right-t">新闻动态</div>
			<div class="ab-right-t2">
				当前位置 <a
					href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500">首页</a>
				-&gt; 新闻动态
			</div>
			<!-- <div class="ab-right-nr clearfix">
<div class="xw-top clearfix">
        <div class="xw-top-l l"><img src="images/xwtoppic.jpg" width="205" height="120" /></div>
         <div class="xw-top-r r">
         <h3>日本风格标志要点是什么？</h3>
         <span>time:2019-09-29</span>
         <p>日本的标志设计，其成功的主要因素，就是本土文化与外来文化的和谐交融，形成了既有强烈的民族文化精神，又有现代设计理念的独特风格。日本的标志设计，其成功的主要因素，就是本土文化与外来文化的和谐交融，形成了既有强烈的民族文化精神.....</p><span class="more r"><a href="#"><img src="images/more2.jpg" width="93" height="21" /></a></span>
         </div>
        </div> -->
			<div class="xw-nr">
				<ul>
					<c:forEach items="${news}" var="n">
						<li><a
							href="${pageContext.request.contextPath}/NewsDetailServlet?id=${n.id}"
							class="l">${n.title}</a><span class="r"> ${n.updatetime}</span></li>
					</c:forEach>


				</ul>
			</div>
			<!-- +++++++++++++++++++++分页++++++++++++++++++++++++-->
			<!-- <div class="fyys r">首页 下一页 1 2 3 4 5 上一页  尾页  </div> -->
			<!-- +++++++++++++++++++++分页++++++++++++++++++++++++-->


		</div>
	</div>
	</div>

	</div>
	<!--==========================centent End=============================-->
	<div class="foot">
		<div class="foot_zi">
			<div class="foot-nr">

				<div class="foot-top">
					<a
						href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500">返回首页
					</a> | <a
						href="${pageContext.request.contextPath}/AboutServlet?page=1&rows=500&ab=1">公司简介</a>
					| <a
						href="${pageContext.request.contextPath}/NewsCategoryServlet?page=1&rows=500&xw=1">新闻动态</a>
					| <a
						href="${pageContext.request.contextPath}/FwxmServlet?page=1&rows=500&fw=1">服务项目</a>
					| <a
						href="${pageContext.request.contextPath}/DeviceShowServlet?page=1&rows=5000&dp=1">设备展示</a>
					| <a
						href="${pageContext.request.contextPath}/CaseShowServlet?page=1&rows=5000&cp=1">案例展示</a>
					| <a href="${pageContext.request.contextPath}/LyServlet?flag=1">在线留言</a>
					| <a href="<%=path%>/qiantai/lxwm.jsp">联系我们</a>
				</div>
				<span class="footspan"> 地址：北京市海淀区 6-1-1801 <br />
					电话：0471-5269377 传真：0471-5269508<br /> 邮箱：trap@trapyx.com <br />
					网址：www.trapyx.com
				</span> <span style="color: #999;">友情链接： <c:forEach items="${link}"
						var="l">
						<a href="${l.content}" target="_blank">${l.name}</a>
					</c:forEach></span>
			</div>
		</div>
		<div class="foot-bq">Copyright 2016-2019 北京Trap灯光音响服务有限责任公司
			京ICP000000备</div>
	</div>
</body>
</html>
