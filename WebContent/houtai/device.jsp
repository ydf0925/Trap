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


<title>jqGird</title>

<link rel="shortcut icon" href="static/favicon.ico" />

<link href="<%=path%>/static/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet" />
<link href="<%=path%>/static/css/font-awesome.css?v=4.4.0"
	rel="stylesheet" />
<link href="<%=path%>/static/css/animate.css" rel="stylesheet" />
<link href="<%=path%>/static/css/style.css?v=4.1.0" rel="stylesheet" />

<link href="<%=path%>/static/css/jquery-ui.css" rel="stylesheet" />
<!-- jqgrid-->
<link href="<%=path%>/static/css/plugins/jqgrid/ui.jqgrid.css?0820"
	rel="stylesheet" />
<!-- layui -->
<link href="<%=path%>/static/layui/css/layui.css"
	rel="stylesheet" />
<script src="<%=path%>/static/layui/layui.js"></script>
<!-- 全局js -->
<script src="<%=path%>/static/js/jquery.min.js?v=2.1.4"></script>

<script src="<%=path%>/static/js/bootstrap.min.js?v=3.3.6"></script>


<!-- jqGrid -->
<script
	src="<%=path%>/static/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
<script
	src="<%=path%>/static/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>

<script src="<%=path%>/static/js/jquery-ui-1.10.4.min.js"></script>
<script src="<%=path%>/static/js/jquery-ui.custom.min.js"></script>
<script src="<%=path%>/static/js/ht/dialog.js"></script>
<script src="<%=path%>/static/js/ht/device.js"></script>

<!-- 自定义js -->
<script src="<%=path%>/static/js/content.js?v=1.0.0"></script>

<!-- Sweet alert -->
<link href="<%=path%>/static/css/plugins/sweetalert/sweetalert.css"
	rel="stylesheet" />
<script src="<%=path%>/static/js/plugins/sweetalert/sweetalert.min.js"></script>

<style>
/* Additional style to fix warning dialog position */
#alertmod_table_list_2 {
	top: 900px !important;
}

.EditTable td textarea {
	width: 404px;
	height: 260px;
	resize: none;
}
</style>

</head>

<body class="gray-bg">

	<!-- 修改弹窗  -->
	<div class="ui-jqdialog modal-content jqmID1" id="changedialog"
		dir="ltr"
		style="width: auto; height: auto; z-index: 950; overflow: hidden; top: 24px; left: 24px; display: none;"
		tabindex="-1" role="dialog" aria-labelledby="edithdtable_list_2"
		aria-hidden="false">
		<div class="ui-jqdialog-titlebar modal-header" id="edithdtable_list_2"
			style="cursor: move;">
			<span class="ui-jqdialog-title添加新记录" style="float: left;">修改信息</span>
		</div>
		<div class="ui-jqdialog-content modal-body" id="editcnttable_list_2">
			<div>
				<form name="FormPost" id="changefrom" class="FormGrid"
					onsubmit="return false;" style="width: auto; height: auto;">
					<div class="FormError bg-danger" style="display: none;"></div>
					<div class="tinfo topinfo"></div>
					<table id="TblGrid_table_list_2" class="EditTable ui-common-table">
						<tbody>
							<tr rowpos="1" class="FormData" id="tr_username">
								<td class="CaptionTD"><label for="username">设备名称</label></td>
								<td class="DataTD">&nbsp;
									<div class="col-sm-12">
										<input id="title" name="title" class="form-control"
											type="text" />
									</div>
								</td>
							</tr>
							<tr rowpos="2" class="FormData" id="tr_sex">
								<td class="CaptionTD"><label for="role">设备类别</label></td>
								<td class="DataTD">
									<div class="col-sm-12">
										<select class="form-control" name="cid" id="cid">
										</select>
									</div>
								</td>
							</tr>

							<tr rowpos="3" class="FormData" id="tr_password">
								<td class="CaptionTD"><label for="username">设备介绍</label></td>
								<td class="DataTD">&nbsp;
									<div class="col-sm-12">
										<textarea id="content" name="content" class="form-control"
											type="text"></textarea>
									</div>
								</td>
							</tr>
							<tr rowpos="3" class="FormData" id="tr_password">
								<td class="CaptionTD"><label for="username">图片</label></td>
								<td class="DataTD">&nbsp;
									<div class="col-sm-12">
										<div>
											<button type="button" class="layui-btn" id="test2">
  												<i class="layui-icon">&#xe67c;</i>上传图片
											</button>
										</div>
										<input id="img2" name="img2" class="form-control"
											type="text"/>
									</div>
								</td>
							</tr>
							<tr class="FormData" style="display: none">
								<td class="CaptionTD"></td>
								<td colspan="1" class="DataTD"><input class="FormElement"
									id="changeid" name="id" type="text" /></td>
							</tr>
						</tbody>
					</table>
					<div class="binfo topinfo bottominfo"></div>
				</form>
				<table style="height: auto" class="EditTable ui-common-table"
					id="TblGrid_table_list_2_2">
					<tbody>
						<tr>
							<td colspan="2">
								<hr class="" style="margin: 1px" />
							</td>
						</tr>
						<tr id="Act_Buttons">
							<td class="navButton"><a id="pData"
								class="fm-button btn btn-default" style="display: none;"><span
									class="glyphicon glyphicon-step-backward"></span></a><a id="nData"
								class="fm-button btn btn-default" style="display: none;"><span
									class="glyphicon glyphicon-step-forward"></span></a></td>
							<td class="EditButton"><a id="changesubmit"
								class="fm-button btn btn-default fm-button-icon-left">提交<span
									class="glyphicon glyphicon-save"></span></a><a id="cDataa"
								class="fm-button btn btn-default fm-button-icon-left"
								onclick="changedialogdismiss()">取消<span
									class="glyphicon glyphicon-remove-circle"></span></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>


	<%-- <div id="loading" style="text-align: center;">
    <img alt="alt" src="<%=path%>/static/img/loading.gif"/>
</div> --%>


	<!-- 主体 -->
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="jqGrid_wrapper">
					<table id="table_list_2"></table>
					<div id="pager_list_2"></div>
				</div>
			</div>
		</div>
	</div>

	<input id="PageContext" type="hidden"
		value="${pageContext.request.contextPath}" />
		
<script type="text/javascript">
layui.use('upload', function(){
	  var upload = layui.upload;
	   
	  //执行实例
	  var uploadInst = upload.render({
	    	elem: '#test2', //绑定元素
	    	url: $('#PageContext').val()+'/UploadImgServlet', //上传接口
	        done: function (res) {
	        	//如果上传失败
                if (res.code == 1) {
                    return layer.msg('上传失败');
                }
                //上传成功
                $("#img2").val(res.filename);
                layer.msg("上传成功", {time: 1500});
                setTimeout(upload, 1500);     
	        },
	        error: function () {
	                //演示失败状态，并实现重传
	                var demoText = $('#demoText');
	                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	                demoText.find('.demo-reload').on('click', function () {
	                    uploadInst.upload();
	                });
	        }

	  });
	});
</script>	
</body>

</html>
