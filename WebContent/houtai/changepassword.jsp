<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<title>修改密码</title>


<link rel="shortcut icon" href="<%=path%>/static/favicon.ico" />
<link href="<%=path%>/static/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet" />
<link href="<%=path%>/static/css/font-awesome.css?v=4.4.0"
	rel="stylesheet" />

<link href="<%=path%>/static/css/animate.css" rel="stylesheet" />
<link href="<%=path%>/static/css/style.css?v=4.1.0" rel="stylesheet" />
<script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
<script src="<%=path%>/static/js/ht/jquery-1.3.1.js"></script>
<script src="<%=path%>/static/js/ht/changepassword.js"></script>
</head>

<body class="gray-bg">

	<div class="lock-word animated fadeInDown"></div>
	<div class="middle-box text-center lockscreen animated fadeInDown">
		<div>
			<div class="m-b-md">
				<img alt="image" class="img-circle circle-border"
					src="<%=path%>/static/img/${sessionScope.user.sex==0?'girl1':'boy1'}.jpg" />
			</div>
			<h3>${sessionScope.user.name}</h3>
			<form id="changefrom" class="m-t" role="form">
				<input hidden value="${sessionScope.user.username}" name="username" />
				<input hidden value="${sessionScope.user.id}" name="id" />
				<div class="form-group">
					<p>输入原密码</p>
					<input type="password" id="oldpassword" name="oldpassword"
						class="form-control" placeholder="******" required="" />
					<p>输入新密码</p>
					<input type="password" id="password" name="password"
						class="form-control" placeholder="******" required="" />
					<p>再次输入密码</p>
					<input type="password" id="repassword" name="repassword"
						class="form-control" placeholder="******" required="" />
				</div>
			</form>
			<button type="submit" class="btn btn-primary block full-width"
				onclick="submit1()">确定</button>
		</div>
	</div>
	<input id="PageContext" type="hidden"
		value="${pageContext.request.contextPath}" />
	<!-- 全局js -->
	<script src="<%=path%>/static/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path%>/static/js/bootstrap.min.js?v=3.3.6"></script>


</body>

</html>
