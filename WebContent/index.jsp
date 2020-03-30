<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="renderer" content="webkit"/>

    <title>Trap后台 - 主页</title>


    <link rel="shortcut icon" href="static/favicon.ico"/>
    <link href="<%=path%>/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet"/>
    <link href="<%=path%>/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet"/>
    <link href="<%=path%>/static/css/animate.css" rel="stylesheet"/>
    <link href="<%=path%>/static/css/style.css?v=4.1.0" rel="stylesheet"/>
 
</head>

<body class="fixed-sidebar full-height-layout gray-bg"
      style="overflow:hidden">


<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
            <i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
							<span><img alt="image" class="img-circle"
                                       src="<%=path%>/static/img/${sessionScope.user.sex==0?'girl':'boy'}.jpg"/></span> <a
                            data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
                            class="clear"> <span class="block m-t-xs"><strong
                            class="font-bold" >${sessionScope.user.name}</strong></span> <span
                            class="text-muted text-xs block"><b
                            class="caret"></b></span>
							</span>
                    </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="houtai/changepassword.jsp">修改密码</a></li>


                            <li class="divider"></li>
                            <li><a href="LogoutServlet">安全退出</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">Trap</div>
                </li>
                  <li><a class="J_menuItem" href="houtai/welcome.jsp">
                  <i class="fa fa-home"></i> <span class="nav-label" id="index">主页</span></a></li>  
			<li><a class="J_menuItem" href="houtai/usergrid.jsp"><i
                                        class="fa fa-columns"></i> <span class="nav-label">管理员信息管理</span></a></li>
                                         <li><a class="J_menuItem" href="houtai/about.jsp"><i
                                        class="fa fa-clone"></i> <span class="nav-label">公司简介管理</span></a></li>
                                <li><a class="J_menuItem" href="houtai/newscategory.jsp"><i
                                        class="fa fa-clone"></i> <span class="nav-label">新闻分类管理</span></a></li>

                                <li><a class="J_menuItem" href="houtai/news.jsp"><i
                                        class="fa fa-share"></i> <span class="nav-label">新闻管理</span></a></li>
								 <li><a class="J_menuItem" href="houtai/fwxm.jsp"><i
                                        class="fa fa-clone"></i> <span class="nav-label">服务项目管理</span></a></li>
                                 <li><a href="houtai/show.jsp"> <i class="fa fa-tags"></i> <span
                                        class="nav-label">展示管理</span> <span class="fa arrow"></span>
                                </a>
                                    <ul class="nav nav-second-level">
                                        <li><a class="J_menuItem" href="houtai/caseshow.jsp">案例展示分类</a></li>
                                        <li><a class="J_menuItem" href="houtai/case.jsp">案例展示</a></li>
                                        
                                        <li><a class="J_menuItem" href="houtai/deviceshow.jsp">设备展示分类</a></li>
                                        <li><a class="J_menuItem" href="houtai/device.jsp">设备展示</a></li>
                                    </ul></li> 
	
                                <li><a class="J_menuItem" href="houtai/ly.jsp"> <i
                                        class="fa fa-sticky-note"></i> <span class="nav-label">留言管理</span>
                                </a></li>
               <%--  <li th:each="menu:${menulist}">
                    <a class="J_menuItem" th:href="${menu.url}">
                        <i class="fa" th:attrappend="class=${' ' + menu.icon}"></i> <span
                            class="nav-label" th:text="${menu.name}">我的便签</span>
                    </a>
                </li>--%>


                <li><a class="J_menuItem" href="houtai/link.jsp"> <i
                        class="fa fa-bug"></i> <span class="nav-label">友情链接</span>
                </a></li> 


            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation"
                 style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
                       href="#"><i class="fa fa-bars"></i> </a>

                </div>
                <ul class="nav navbar-top-links navbar-right">


                    <li class="dropdown hidden-xs"><a
                            class="right-sidebar-toggle" aria-expanded="false"> <i
                            class="fa fa-tasks"></i> 菜单
                    </a></li>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft">
                <i class="fa fa-backward"></i>
            </button>
   
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="${pageContext.request.contextPath}/IndexServlet?page=1&rows=500" class="active J_menuTab"
                       target="_blank" data-id="index_v1.html">网站首页</a>
                </div>
            </nav> 
            <button class="roll-nav roll-right J_tabRight">
                <i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">
                    关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a></li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
                </ul>
            </div>
            <a id="logouta" class="roll-nav roll-right J_tabExit"
               onclick="window.location='LogoutServlet'"><i
                    class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%"
                    th:src="@{/welcome}" frameborder="0"></iframe>
        </div>
        <div class="footer"></div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-2">

                <li class="active"><a data-toggle="tab" href="#tab-1"> <i
                        class="fa fa-gear"></i> 主题
                </a></li>
               <!--  <li class=""><a data-toggle="tab" href="#tab-2"> 通知 </a></li> -->

            </ul>

            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3>
                            <i class="fa fa-comments-o"></i> 主题设置
                        </h3>
                        <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式。</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">主题设置</div>
                        <div class="setings-item">
                            <span>收起左侧菜单</span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu"
                                           class="onoffswitch-checkbox" id="collapsemenu"/> <label
                                        class="onoffswitch-label" for="collapsemenu"> <span
                                        class="onoffswitch-inner"></span> <span
                                        class="onoffswitch-switch"></span>
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定顶部</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar"
                                           class="onoffswitch-checkbox" id="fixednavbar"/> <label
                                        class="onoffswitch-label" for="fixednavbar"> <span
                                        class="onoffswitch-inner"></span> <span
                                        class="onoffswitch-switch"></span>
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span> 固定宽度 </span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout"
                                           class="onoffswitch-checkbox" id="boxedlayout"/> <label
                                        class="onoffswitch-label" for="boxedlayout"> <span
                                        class="onoffswitch-inner"></span> <span
                                        class="onoffswitch-switch"></span>
                                </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">皮肤选择</div>
                        <div class="setings-item default-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-0">
										默认皮肤 </a>
								</span>
                        </div>
                        <div class="setings-item blue-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-1">
										蓝色主题 </a>
								</span>
                        </div>
                        <div class="setings-item yellow-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-3">
										黄色/紫色主题 </a>
								</span>
                        </div>
                    </div>
                </div>
               <!--  <div id="tab-2" class="tab-pane"> -->

               <!--       <div class="sidebar-title">
                        <h3>
                            <i class="fa fa-comments-o"></i> 最新通知
                        </h3>

                    </div>

                    <div>

                        <div class="sidebar-message" th:each="notice:${noticelist}">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar"
                                         th:src="@{'img/'+ ${notice.avatar}+ '.jpg'}"/>
                                    <div class="m-t-xs" th:text="${notice.sendUsername}"></div>
                                </div>
                                <div class="media-body" th:utext="${notice.message}"></div>

                            </a>
                        </div>

                    </div>  -->

                </div>

            </div>

        </div>
    </div>
    <!--右侧边栏结束-->



<!-- 全局js -->
<script src="<%=path%>/static/js/jquery.min.js"></script>
<script src="<%=path%>/static/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=path%>/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=path%>/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=path%>/static/js/plugins/layer/layer.min.js"></script>

<%-- <script src="<%=path%>/static/js/ht/index.js"></script> --%>

<!-- 自定义js -->
<script src="<%=path%>/static/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=path%>/static/js/contabs.js"></script>

<!-- 第三方插件 -->
<script src="<%=path%>/static/js/plugins/pace/pace.min.js"></script>
<script>
$(function() {
	$("#index").trigger("click");
})
</script>
</body>

</html>
