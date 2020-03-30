<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Trap后台登陆错误！</title>

<link rel="shortcut icon" href="static/favicon.ico" />
<link href="<%=path%>/static/css/404.css" rel="stylesheet" />
<script src="<%=path%>/static/js/jquery-3.1.0.min.js"></script>

</head>
<body>
	<div class="auto">
		<div class="container">
			<div class="settings">
				<i class="icon"></i>
				<h4>很抱歉！账号或密码！没有找到您要访问的页面！</h4>
				<p>
					<span id="num">5</span> 秒后将自动跳转到首页
				</p>
				<div>
					<a href="<%=path%>/login.jsp" title="返回首页">返回首页</a> <a
						href="javascript:;" title="上一步" id="reload-btn">上一步</a>
				</div>
			</div>
		</div>
	</div>

	<script>
	//倒计时跳转到首页的js代码
	var $_num=$("#num");
	var num=parseInt($_num.html());
	var numId=setInterval(function(){
		num--;
		$_num.html(num);
		if(num===0){
			//跳转地址写在这里
			window.location.href="<%=path%>/login.jsp";
			}
		}, 1000);
		//返回按钮单击事件
		var reloadPage = $("#reload-btn");
		reloadPage.click(function(e) {
			window.history.back();
		});
	</script>

</body>
</html>