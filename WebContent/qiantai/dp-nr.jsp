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
				<div class="ab-left-t2">设备展示</div>
				<div class="ab-left-nav clearfix">
					<ul>
						<c:forEach items="${menu}" var="m">
							<LI><a
								href="${pageContext.request.contextPath}/DeviceShowServlet?page=1&rows=5000&dp=1&cid=${m.id}">${m.name}</a></LI>
						</c:forEach>

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
			<div class="ab-right-t">
				<c:forEach var="deviceShow" items="${menu}">
					<c:if test='${device.cid==deviceShow.id}'>${deviceShow.name}</c:if>
				</c:forEach>
			</div>
			<div class="ab-right-t2">
				当前位置 <a
					href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500">首页</a>
				-&gt; 案例展示&gt;
				<c:forEach var="deviceShow" items="${menu}">
					<c:if test='${device.cid==deviceShow.id}'>${deviceShow.name}</c:if>
				</c:forEach>
			</div>
			<div class="ab-right-nr clearfix">
				<div id="show_12">
					<div id="case_post_01">
						<img src="/imagespath/${device.imgname}" width="450"
							height="302">
					</div>
					<div id="case_post_02">${device.title}</div>
					<div id="case_post_03">${device.content}</div>
				</div>
				<div id="case_post_04">
					<c:if test="${prenDevice!=null}">
						<span class="red_12">+ 上一例：</span>
						<a
							href="${pageContext.request.contextPath}/DeviceDetailServlet?id=${prenDevice.id}">${prenDevice.title}</a>
						<br>
					</c:if>
					<c:if test="${nextDevice!=null}">
						<span class="red_12">+ 下一例：</span>
						<a
							href="${pageContext.request.contextPath}/DeviceDetailServlet?id=${nextDevice.id}">${nextDevice.title}</a>
				</div>
				</c:if>


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
