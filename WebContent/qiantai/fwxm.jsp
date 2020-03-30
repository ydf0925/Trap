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
				<div class="ab-left-t2">服务项目</div>
				<div class="ab-left-nav clearfix">
					<ul>
						<LI><a
							href="${pageContext.request.contextPath}/FwxmServlet?page=1&rows=500&fw=1"
							class="xz"> 灯光音响工程</a></LI>
						<!-- <LI><a href="#">LED租赁</a></LI>
  <LI><a href="#">演出灯光音响租赁</a></LI>
    <LI><a href="#">LED大屏幕工程</a></LI>
  <LI><a href="#">舞美工程设计制作</a></LI> -->

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
			<div class="ab-right-t">灯光音响工程</div>
			<div class="ab-right-t2">
				当前位置 <a
					href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500">首页</a>
				-&gt; 服务项目-&gt; 灯光音响工程
			</div>
			<div class="ab-right-nr clearfix">
				<br />
				<c:forEach items="${menu}" var="f">
					<p>${f.content}</p>
				</c:forEach>
				<!--北京市Trap灯光音响服务有限责任公司是一家集代理、销售、设计、安装、调试、租赁、维修及相关技术咨询、演出策划、舞台设计及背景制作服务为一体的专业公司，公司拥有一批专业调音师、灯光设计师、录音师及职业创作人和音乐人。 
公司曾多次承接过各种高技术、高难度项目，并得到用户的一致好评和有关部门的奖励。公司凭借良好的行业信誉、以强大的技术优势、高效的营销网络、科学的管理方法，以及先进的技术和高科技产品，立足于本行业的先列。已具备承揽大型演出的能力，并使得公司在无数的挑战和机遇面前始终能够快速反应走在前端。
让客户满意是我们的宗旨。公司自成立以来始终秉持 “富于创造的设计理念 、诚恳热忱的服务态度 、积极进取的事业精神 、诚实守信的企业信誉”的经营战略，以优质的产品系列、完善的解决方案、雄厚的技术实力、先进的管理模式和良好的售后服务，赢得广大客户的青睐。短短几年中，公司在金融、电信、邮电、电力、交通、铁路、军事、教育、宾馆、娱乐场所、政府机关等领域开辟了广阔市场，并取得了较好的业绩。 -->
				<br />
				<br /> 地址：北京市海淀区 6-1-1801 <br /> 电话：0471-3246388 传真：0471-3246399<br />
				http://www.trapyx.com<br /> E-mail:trap@trapyx.com<br /> 客服专线：4006
				110 664
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
					</a> | <a href="<%=path%>/qiantai/about.jsp">公司简介</a> | <a
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
