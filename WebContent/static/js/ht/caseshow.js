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
        url: $("#PageContext").val()+"/DelCaseShowServlet",
        type: "POST",
        data: jsondata,
        success: function (data, stutas) {
            console.log(data);
            if (data == "1") {
                $("#table_list_2").trigger("reloadGrid");
                successalert("", "删除案例分类成功");
            } else {
                errorsalert("", "删除案例分类失败");
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
        url: $("#PageContext").val()+"/UpdateCaseShowServlet",
        type: "POST",
        data: $("#changefrom").serialize(),
        success: function (data) {
            if (data == 1) {
                successalert("", "案例分类修改成功");
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
    var datas = $("#table_list_2").jqGrid("getRowData", id);
    $("#changeid").attr("value", id);
    $("#name").val(datas.name);
    $("#changedialog").show(speed = "slow");
}

function buildgrid() {
    $("#table_list_2").jqGrid(
        {
            url: $("#PageContext").val()+"/CaseShowServlet",
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
            colNames: ['案例分类名称', '操作'],
            colModel: [
                {
                    name: 'name',
                    index: 'name',
                    editable: true,
                    editrules:{edithidden:true, required:true},

                    width: 90
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
            caption: "案例分类列表",
            add: true,
            edit: false,
            addtext: 'Add',
            editurl: $("#PageContext").val()+"/AddCaseShowServlet",
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



