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
        url: $("#PageContext").val()+"/DelUserServlet",
        type: "POST",
        data: jsondata,
        success: function (data, stutas) {
            console.log(data);
            if (data == "1") {
                $("#table_list_2").trigger("reloadGrid");
                successalert("", "删除用户完成");
            } else {
                errorsalert("", "删除用户失败");
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
        url: $("#PageContext").val()+"/UpdateUserServlet",
        type: "POST",
        data: $("#changefrom").serialize(),
        success: function (data) {
            if (data == 1) {
                successalert("", "用户信息修改完成");
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


function resetpassworkdialog(id) {

    updatealert("", "确定要重置此用户密码吗？", function () {
        resetpasswork(id)
    });
}

function resetpasswork(id) {

    var jsondata = {"id": id};
    $.ajax({
        url: "/resetpassword",
        type: "POST",
        data: jsondata,
        success: function (data, stutas) {
            console.log(data);
            successalert("", "用户密码重置完成");
            if (data == "1") {
                successalert("", "用户密码重置完成");
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
    var datas = $("#table_list_2").jqGrid("getRowData", id);
    $("#changeid").attr("value", id);
    $("#changeusername").val(datas.username);
    $("#password").val(datas.password);
    $("#sex").val(datas.sex);
    $("#name").val(datas.name);
    $("#changedialog").show(speed = "slow");
}

function buildgrid() {
    $("#table_list_2").jqGrid(
        {
//        	获取绝对路径
            url: $("#PageContext").val()+"/LyServlet",
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
            colNames: ['姓名','邮箱', '电话', '内容', '留言日期'],
            colModel: [
                {
                    name: 'name',
                    index: 'name',
                    width: 90

                },
                {
                    name: 'email',
                    index: 'email',
                    width: 90

                },
                {
                	name: 'tel',
                	index: 'tel',
                	width: 90
                	
                },
                {
                    name: 'content',
                    index: 'content',
                    width: 120,

                },
                {
                    name: 'createtime',
                    index: 'createtime',
                    width: 90
                },                              
            ],
            pager: "#pager_list_2",
            viewrecords: true,
            caption: "留言列表",
            add: false,
            edit: false,
            editurl: $("#PageContext").val()+"/AddUserServlet",
            hidegrid: false,           
        });

    // Setup buttons
    $("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
        edit: false,
        add: false,
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

