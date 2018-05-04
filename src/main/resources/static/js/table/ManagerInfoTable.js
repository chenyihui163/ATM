/**
 * 
 */
$('#ManagerInfo').bootstrapTable({
		url: '#',
		toolbar: '#tab-toolbar',
	    toolbarAlign: 'left',
        method:'post',
        dataType:'json',
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        search: false,
        striped: true,//是否显示行间隔色
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
	    queryParamsType : "",
	    queryParams : getParams,
        showColumns:true,
        showPaginationSwitch: true,
        pagination:true,
        showToggle: true,
        showPaginationSwitch: true,
        minimumCountColumns:2,
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 15, 20, 25],        //可供选择的每页的行数（*）
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        
        onEditableSave: function (field, row, oldValue, $el) {
                $.ajax({
                    type: "post",
                    url: "#",
                    data: row,
                    dataType: 'JSON',
                    success: function (data, status) {
                        if (status == "success") {
                            alert('提交数据成功');
                        }
                    },
                    error: function () {
                        alert('编辑失败');
                    },
                    complete: function () {

                    }

                });
        },
        data: [{
        	mid: 123,
        	mName: '爱仕达',
        	mPassword: 12433,
        	mRole: '管理员',
        	state: '正常',
        }],
        columns: [{
        	checkbox: true
        },{
            field: 'mid',
            title: '管理员ID',
            align: 'center',
        },{
            field: 'mName',
            title: '管理员姓名',
            align: 'center',
        },{
            field: 'mPassword',
            title: '密码',
            align: 'center',
        },{
            field: 'mRole',
            title: '角色',
            align: 'center',
        },{
        	field: 'state',
            title: '状态',
            align: 'center',
            editable: {
                type: 'select',
                pk: 1,
                source: [
                    {value: 1, text: '正常'},
                    {value: 2, text: '冻结'},
                ]
            }
        }]
    });
function getParams(params) {
    var temp = { 
        pageSize : params.pageSize, 
        pageNumber : params.pageNumber
    };
    return temp;
}