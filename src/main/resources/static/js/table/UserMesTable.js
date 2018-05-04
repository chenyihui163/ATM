/**
 * 
 */
$('#UserMessage').bootstrapTable({
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
        columns: [{
        	checkbox:true
        },{
            field: 'username',
            title: '姓名',
            align: 'center',
            editable: {
                type: 'text',
                title: '姓名',
                validate: function (v) {
                    if (!v) return '姓名不能为空';

                }
            }
        }, {
            field: 'sex',
            title: '性别',
            align: 'center',
            editable: {
                type: 'text',
                title: '性别',
                validate: function (v) {
                    if (!v) return '性别不能为空';

                }
            }
        }, {
            field: 'birthday',
            title: '出生日期',
            align: 'center',
            editable: {
                type: 'date',
                format: 'yyyy-mm-dd',    
                viewformat: 'yyyy-mm-dd',    
                datepicker: {
                    weekStart: 1
                }
            }
        }, {
            field: 'identityType',
            title: '身份类型',
            align: 'center',
            editable: {
                type: 'text',
                title: '身份类型',
                validate: function (v) {
                    if (!v) return '性别不能为空';

                }
            }
            
        },{
            field: 'phone',
            title: '电话号码',
            align: 'center',
            editable: {
                type: 'text',
                title: '电话号码',
                validate: function (v) {
                    if (!v) return '电话号码不能为空';

                }
            }
            
        },{
            field: 'address',
            title: '地址',
            align: 'center',
            editable: {
                type: 'text',
                title: '地址',
                validate: function (v) {
                    if (!v) return '地址不能为空';

                }
            }
            
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