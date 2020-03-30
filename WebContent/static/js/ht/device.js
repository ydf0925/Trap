$(function () {
    $("#loading").show();
    $("#changesubmit").click(function () {
        modify();
    });


    console.log("hello");
    $.jgrid.defaults.styleUI = 'Bootstrap';
    buildgrid();
    


});

function deldialog(id) {
    deletealert("", "确定要删除吗？", function () {
        del(id)
    });
}


function del(id) {

    var jsondata = {"id": id};
    $.ajax({
        url: $("#PageContext").val()+"/DelDeviceServlet",
        type: "POST",
        data: jsondata,
        success: function (data, stutas) {
            console.log(data);
            if (data == "1") {
                $("#table_list_2").trigger("reloadGrid");
                successalert("", "删除设备成功");
            } else {
                errorsalert("", "删除设备失败");
            }
        },
        error: function () {
            errorsalert("", "出现错误，请重试");
        }
    });


}

function modify() {


    console.log($("#changefrom").serialize());

    $.ajax({
        url: $("#PageContext").val()+"/UpdateDeviceServlet",
        type: "POST",
        data: $("#changefrom").serialize(),
        success: function (data) {
            if (data == 1) {
                successalert("", "设备修改成功");
                $("#table_list_2").trigger("reloadGrid");
                changedialogdismiss();
            } else {
                errorsalert("", "出现错误，请重试");
            }

        },
        error: function () {
            errorsalert("", "出现错误，请重试");
        }
    });
}





function changedialogdismiss() {
    $("#changedialog").hide(speed = "slow");
}

function changedialogshow(id) {
    console.log("changedialogshow" + id);
    $.ajax({
        url: $("#PageContext").val()+"/DeviceShowServlet",
        type: "POST",
        data:{"page":1,"rows":500},
        beforeSend: function () {

        },
        success: function (data) {
        	 var datas = $("#table_list_2").jqGrid("getRowData", id);
        	 $("#cid").empty();
        	 var list=JSON.parse(data);
        	    $("#changeid").attr("value", id);
        	    $("#title").val(datas.title);
				for (var i in list.rows) {
					$("#cid").append("<option value='"+list.rows[i].id+"'>"+list.rows[i].name+"</option>");
				}
        	    $("#content").val(datas.content);
        	    $("#changedialog").show(speed = "slow");
        },
        error: function () {
            console.log("error");
        },
        complete: function () {
            $("#loading").hide();
        }
    });
   
}

function buildgrid() {
    $("#table_list_2").jqGrid(
        {
            url: $("#PageContext").val()+"/DeviceServlet",
            datatype: "json",
            mtype: "POST",
            height: "100%",
            autowidth: true,
            rownumbers: true,
            jsonReader: {              
            	repeatitems : false 
            },
            rowNum: 10,
            rowList: [10, 20, 30],
            colNames: ['设备名称','分类名称','设备介绍', '图片预览','操作'],
            colModel: [
                {
                    name: 'title',
                    index: 'title',
                    editable: true,
                    editrules:{edithidden:true, required:true},

                    width: 90

                },               
                {
                	name: 'cname',
                	index: 'cname',
                	editable: true,
                	 edittype: 'select',//数据要在后台转换为select形式的string字符串
                     editoptions: {dataUrl: $("#PageContext").val()+'/DeviceShowServlet?page=1&rows=500&flag=1'},
                     formatter: function (value, options, row) {
                         // 自定义单元格展示内容
                         return row.cname;
                     },
                	width: 90
                	
                },
                
                {
                	name: 'content',
                	index: 'content',
                	editable: true,
                	edittype:'textarea',
                	editoptions:{rows:10},
                	width: 90
                },
                {
                	name:'imgname',
                	index:'imgname',
                	width: 90,
                	formatter: function (value, options, row) {
                        // 自定义单元格展示内容
                        return "<img src='/imagespath/"+row.imgname+"' width='190px' height='100px'/>";
                    }
                },             
                {
                    name: 'handle',
                    index: 'handle',
                    width: 100,
                    sortable: false
                }
            ],
            pager: "#pager_list_2",
            viewrecords: true,
            caption: "设备列表",
            add: true,
            edit: false,
            addtext: 'Add',
            editurl: $("#PageContext").val()+"/AddDeviceServlet",
            hidegrid: false,
            gridComplete: function () {
                console.log("grid Complete");
                var ids = $("#table_list_2").jqGrid("getDataIDs");
                for (var int = 0; int < ids.length; int++) {
                    var id = ids[int];
                    console.log("ff" + id);
                    var modify = "<a href='#' style='color:#f60' onclick='changedialogshow(" + id + ")'>修改</a>";  //这里的onclick就是调用了上面的javascript函数 Modify(id)
                    var del = "<a href='#'  style='color:#f60' onclick='deldialog(" + id + ")' >删除</a>";
                    var result = $("#table_list_2").jqGrid("setRowData", id, {handle: modify + "&nbsp &nbsp" + del + "&nbsp &nbsp" });
                }
            }
        });

    // Setup buttons
    $("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
        edit: false,
        add: true,
        del: false,
        search: false
    }, {
        height: 300,
        reloadAfterSubmit: true
    });


    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_list_2').setGridWidth(width);
    });

}

function getdeptlistforuseradd(roledata) {
    $.ajax({
        url: "/deptlistforadd",
        type: "POST",
        beforeSend: function () {

        },
        success: function (data) {
            console.log(data);
            buildgrid(data, roledata);
        },
        error: function () {
            console.log("error");
        },
        complete: function () {
            $("#loading").hide();
        }
    });
}

