<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="shortcut icon" href="static/favicon.ico" />
<link href="<%=path%>/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet" />
<link href="<%=path%>/static/css/font-awesome.css?v=4.4.0" rel="stylesheet" />
<link href="<%=path%>/static/css/animate.css" rel="stylesheet" />
<link href="<%=path%>/static/css/style.css?v=4.1.0" rel="stylesheet" />
</head>

<body>
	<!--<img src="<%=path%>/static/img/welcome.png" width="1145px" height="494px"/>	-->
	<img src="<%=path%>/static/img/welcome.png" width="100%" height="100%"/>
	
</body>
</html>
