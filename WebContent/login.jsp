<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <title> 登录</title>
    <link rel="shortcut icon" href="<%=path%>/static/favicon.ico"/>
    <link href="<%=path%>/static/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%=path%>/static/css/font-awesome.css?v=4.4.0" rel="stylesheet"/>
    <link href="<%=path%>/static/css/animate.css" rel="stylesheet"/>
    <link href="<%=path%>/static/css/style.css" rel="stylesheet"/>
    <link href="<%=path%>/static/css/login.css" rel="stylesheet"/>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>[ Trap ]</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>Trap公司官网后台</strong></h4>


            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" action="LoginServlet">
                <h4 class="no-margins" style="color: #8B8378">登录：</h4>
                <p class="m-t-md" style="color: #8B8378">登录到Trap后台</p>
                <input type="text" class="form-control uname" name="username" required placeholder="用户名"/>
                <input type="password" class="form-control pword m-b" name="password" required placeholder="密码"/>
                <%-- <input th:if="${kaptcha} == true" type="text" class="form-control" style="color: #000000" name="kaptcha"
                       placeholder="验证码"/>

                <img th:if="${kaptcha} == true" src="/static/kaptcha.jpg" width="200" id="kaptchaImage" alt="验证码加载中"
                     title="看不清，点击换一张"/> --%>
                <!--    <a href="">忘记密码了？</a>-->
                <button class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
        </div>
    </div>
</div>
</body>
<script src="<%=path%>/static/js/jquery.min.js"></script>
<script type="text/javascript">
   /*  $(function () {
        $('#kaptchaImage').click(function () {
            $(this).attr('src', '/static/kaptcha.jpg?' + Math.floor(Math.random() * 100));
        });
    }); */
</script>

</html>
