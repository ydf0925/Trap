<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Trap公司</title>
<link rel="shortcut icon" href="<%=path%>/static/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/qiantai/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/qiantai/css/css.css" />
<script src="<%=path %>/qiantai/js/jquery-1.4.2.min.js"></script>
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
						src="<%=path %>/qiantai/images/logo.png" width="237" height="100" /></a>
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
						<li><a href="<%=path %>/qiantai/lxwm.jsp">联系我们</a></li>
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
				<div class="ab-left-t2">在线留言</div>
				<div class="ab-left-nav clearfix">
					<ul>
						<LI><a href="<%=path %>/qiantai/ly.jsp" class="xz">签写留言</a></LI>


					</ul>
				</div>
			</div>
			<div class="ab-left-bm">
				<a href="https://www.amap.com/"><img
					src="<%=path %>/qiantai/images/leftlx_01.jpg" width="206"
					height="60" /></a> <a
					href="${pageContext.request.contextPath}/LyServlet?flag=1"><img
					src="<%=path %>/qiantai/images/leftlx_02.jpg" width="206"
					height="56" /></a> <a href="<%=path %>/qiantai/lxwm.jsp"><img
					src="<%=path %>/qiantai/images/leftlx_03.jpg" width="206"
					height="54" /></a>

			</div>
		</div>

		<div class="ab-right r clearfix">
			<div class="ab-right-t">在线留言</div>
			<div class="ab-right-t2">
				当前位置 <a
					href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500">首页</a>
				-&gt; 在线留言-&gt; 签写留言
			</div>
			<div class="ab-right-nr clearfix">
				<div class="jj">
					<div class="me_top">
						感谢您对我们的关注与支持，如果您对我们有任何的意见或建议，请在这里给我们留言，我们将在第一时间处理您的反馈。</div>
					<div style="text-align: center; height: 40px;"></div>

					<div style="margin-left: 32px; font-size: 12PX;">
						<form id="form" name="form"
							action="${pageContext.request.contextPath}/AddLyServlet"
							method="post">
							<table width="646" height="85">
								<tr>
									<td width="57" height="42"><span>您的姓名</span>
										<div></div></td>
									<td width="256"><input  name="name" type="text" required class="bgs"
										id="name" size="20" placeholder="建议输入您的真实姓名" />&nbsp;<span
										class="red">*</span></td>
									<td width="87"><span>您的电子邮件</span>
										<div></div></td>
									<td width="226"><input  name="email" type="text" required id="email"
										class="bgs" size="20" placeholder="请输入有效的电子邮件地址" />&nbsp;<span
										class="red">*</span></td>
								</tr>
								<tr>
									<td><span>您的电话</span>
									<div></div></td>
									<td><input  name="tel" id="tel" type="text" required class="bgs"
										size="20" placeholder="请输入真实的电话号码" />&nbsp;<span class="red">*</span></td>
								</tr>
							</table>
							<table height="154">
								<tr>
									<td width="58" height="86"><span>留言内容</span></td>
									<td width="580"><textarea  name="content" id="content"
											required class="note_textarea"
											style="resize: none; line-height: 24PX; font-size: 12px; width: 502PX; height: 164PX; padding-left: 4PX;"
											placeholder="请输入您要提出的建议或留言..."></textarea>&nbsp;<span
										class="red">*</span></td>
								</tr>
								<tr>
									<td height="60"><div style="padding-left: 5px;">&nbsp;&nbsp;</div>
									</td>
									<td height="60"><div class="fd">
											<input  name="yzm" type="text" class="yz" id="yzm" size="4"
												required maxlength="4" hidden />
										</div>
										<div class="cd1"></div>
										<div class="ms">
											<ul style="list-style-type: none;">
												<li><img src="<%=path %>/qiantai/images/bdbg_12.jpg"
													id="tj" style="cursor: pointer;" /></li>
												<li><img src="<%=path %>/qiantai/images/bdbg_10.jpg"
													id="ct" style="cursor: pointer;" /></li>
											</ul>
										</div></td>
								</tr>
							</table>
						</form>
					</div>


				</div>


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
					| <a href="<%=path %>/qiantai/lxwm.jsp">联系我们</a>
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
<script>
	$(function(){
		$("#tj").click(function(){
			if($("#name").val() == "") {
				alert("表单内容不能为空");
			}else {
			$("form").submit();
			}
		});
		$("#ct").click(function(){
			$("form")[0].reset();
		});
	});
</script>
</html>
