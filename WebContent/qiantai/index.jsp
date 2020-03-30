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
	<script src="<%=path%>/qiantai/js/jquery.flexslider-min.js"></script>
	
</head>

<body>
	<!--==========================Head Start==========================-->
	<div class="hd" >
	<div class="heads" >
		<div class="heads-m">
			<div class="heads-m-t">
				<span class="l">欢迎来到Trap公司官网！</span><span class="r"
					style="padding-right: 10px;"><a href="#"></a> <a href="#"></a></span>
			</div>
			<div class="heads-m-bm">
				<div class="logo">
					<a
						href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500"
						target="_blank"><img src="<%=path%>/qiantai/images/logo.png"
						width="237" height="100" /></a>
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
	</div>
	<!--==========================Head End=============================-->
	<div class="banner">
		<div class="flexslider">
			<ul class="slides">
				<li
					style="background:url(<%=path%>/qiantai/images/banner1.jpg) 50% 0 no-repeat;"></li>
				<li
					style="background:url(<%=path%>/qiantai/images/banner2.jpg) 50% 0 no-repeat;"></li>
			</ul>
		</div>
		<script src="<%=path%>/qiantai/js/jquery-1.7.2.min.js"></script>
		<script src="<%=path%>/qiantai/js/jquery.flexslider-min.js"></script>
		<script>
			$(window).load(function() {
				$('.flexslider').flexslider({
					directionNav : false,
					pauseOnAction : false
				});
				var heads = document.querySelector('.heads');
				
				document.addEventListener('scroll',function() {
					if (window.pageYOffset >= 34) {
						heads.style.position = 'fixed';
						heads.style.top = -34 + 'px';
						heads.style.zIndex = 3;
						heads.style.background = 'rgba(0,0,0,.5)';
					}else{
						heads.style.position = '';
						heads.style.background = '';
						heads.style.backgroundImage = 'url(../images/topbg.jpg) left top repeat-x';
					}
				})
			});
		</script>
	</div>
	<!--==========================centent Start=============================-->
	<div class="list-mid">
		<div class="list-mid-m">
			<span class="lyop"></span><span class="r more"><a
				href="${pageContext.request.contextPath}/CaseShowServlet?page=1&rows=5000&cp=1">+更多</a></span>
		</div>
	</div>
	<div class="list-mid-nr">
	
		<ul>
				<c:forEach items="${cases}" var="c" begin="0" end="2">
				<li>
				<span class="list-pic">
				<a href="${pageContext.request.contextPath}/CaseDetailServlet?id=${c.id}">
						<img src="/imagespath/${c.imgname}" width="300" height="250" />
				</a>
				</span>
				<span class="list-zi">
				<a href="${pageContext.request.contextPath}/CaseShowServlet?page=1&rows=5000&cp=1&cid=${c.cid}">${c.cname}</a>
				</span>
				</li>
				</c:forEach>
		</ul>
		<%-- <ul>
				<c:forEach items="${cases}" var="c" begin="0" end="2">
				<li>
				<span class="list-pic">
				<a href="${pageContext.request.contextPath}/CaseDetailServlet?id=${c.id}">
						<img src="/imagespath/${c.imgname}" width="300" height="250" />
				</a>
				</span>
				</li>
				</c:forEach>
		</ul>
		<ol>
				<c:forEach items="${menu}" var="m" begin="0" end="2">
				<li>
				<span class="list-zi">
				<a href="${pageContext.request.contextPath}/CaseShowServlet?page=1&rows=5000&cp=1&cid=${m.id}">${m.name}</a>
				</span>
				</li>
				</c:forEach>
		</ol> --%>
	</div>
	<div class="list-xw">
		<div class="list-xw-m">
			<div class="top-list-l clearfix">
				<div class="top-list-l-t">
					<div class="top-list-l-t2">公司简介</div>
				</div>
				
					<div class="top-list-pic">
						<a
							href="${pageContext.request.contextPath}/AboutServlet?page=1&rows=500&ab=1"><img
							src="<%=path%>/qiantai/images/jjpic.jpg" width="225"
							height="217" /></a>
					</div>
					<c:forEach items="${about}" var="a">
					<div class="top-list-z">${a.content}
					</div>
					<a id="xq" href="${pageContext.request.contextPath}/AboutServlet?page=1&rows=500&ab=1">【详情】</a>
					</c:forEach>
			</div>
			<div class="list-bm-l r">
				<div class="list-bm-top">
					<div class="top-list-l-t2 l">新闻动态</div>
					<div class="r" style="padding-right: 10px; font-size: 14px;">
						<a
							href="${pageContext.request.contextPath}/NewsCategoryServlet?page=1&rows=500&xw=1">更多</a>
					</div>
				</div>
				<div class="list-bm-nr">
					<c:forEach items="${news}" var="n" begin="0" end="0">
						<div class="list-bm-nr-t">
							<span class="l xwpic-2"><a
								href="${pageContext.request.contextPath}/NewsDetailServlet?id=${n.id}">
								<img src="<%=path%>/qiantai/images/wxpiccc.jpg" width="113"
									height="77" />
									</a></span><span class="r xwpic-2-r">
								<h3>
									<a style="font-size:20px;"
										href="${pageContext.request.contextPath}/NewsDetailServlet?id=${n.id}">${n.title}</a>
								</h3>
								<p>${n.content}
								</p>
								<a href="${pageContext.request.contextPath}/NewsDetailServlet?id=${n.id}">【详细】</a>
							</span>
						</div>
					</c:forEach>
					<div class="list-bm-nr-x">
						<ul>
							<c:forEach items="${news}" var="n" begin="1" end="5">
								<li><a
									href="${pageContext.request.contextPath}/NewsDetailServlet?id=${n.id}"
									class="l">${n.title}</a><span class="r"> [${n.updatetime }]</span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="list-cp"></div>
	<div class="list-cp-nr">
		<ul>
			<c:forEach items="${device}" var="c" begin="0" end="3">
				<li>
					<div class="l-pic l">
						<a
							href="${pageContext.request.contextPath}/DeviceDetailServlet?id=${c.id}"><img
							src="/imagespath/${c.imgname}" width="186"
							height="160" /></a>
					</div>
					<div class="r-wz r">
						<h3>
							<a
								href="${pageContext.request.contextPath}/DeviceDetailServlet?id=${c.id}">${c.title}</a>
						</h3>
						<span>${c.content}</span>
					</div>
				</li>
			</c:forEach>
			<%-- <li style="border-right:0;">
      <div class="l-pic l"> <a href="#"><img src="<%=path %>/qiantai/images/cp-pic.jpg" width="186" height="160" /></a></div>
      <div class="r-wz r">
        <h3><a href="#">托斯卡纳音响 X6215</a></h3>
      <span>X系列采用世界高档扬声器单元和轻巧的进口桦木箱体搭配，通过计算机设计，精确的分频及展宽的频响特点和良好的控制覆盖性能。同时可旋转的压缩式号筒使它既能做垂直安装也能做平衡安装，平滑的频率响应和精确..</span></div>
    </li>
    <li>
      <div class="l-pic l"> <a href="#"><img src="<%=path %>/qiantai/images/cp-pic.jpg" width="186" height="160" /></a></div>
      <div class="r-wz r">
        <h3><a href="#">托斯卡纳音响 X6215</a></h3>
      <span>X系列采用世界高档扬声器单元和轻巧的进口桦木箱体搭配，通过计算机设计，精确的分频及展宽的频响特点和良好的控制覆盖性能。同时可旋转的压缩式号筒使它既能做垂直安装也能做平衡安装，平滑的频率响应和精确..</span></div>
    </li>
    <li style="border-right:0;">
      <div class="l-pic l"> <a href="#"><img src="<%=path %>/qiantai/images/cp-pic.jpg" width="186" height="160" /></a></div>
      <div class="r-wz r">
        <h3><a href="#">托斯卡纳音响 X6215</a></h3>
        <span>X系列采用世界高档扬声器单元和轻巧的进口桦木箱体搭配，通过计算机设计，精确的分频及展宽的频响特点和良好的控制覆盖性能。同时可旋转的压缩式号筒使它既能做垂直安装也能做平衡安装，平滑的频率响应和精确..</span></div>
    </li> --%>
		</ul>
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
					</c:forEach>
				</span>
			</div>
		</div>
		<div class="foot-bq">Copyright 2016-2019 北京Trap灯光音响服务有限责任公司
			京ICP000000备</div>
	</div>
	
</body>
</html>
