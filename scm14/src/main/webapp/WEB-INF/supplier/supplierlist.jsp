<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/common.jsp" %>
<html>
<head>
    <title>供应商列表</title>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                url: '${proPath}/supplier/selectPage.action',
                toolbar: [{
                    iconCls: 'icon-add',
                    text: '新增',
                    handler: function () {
                        //由于id为win的div是在父窗口上面的,所以需要
                        parent.$("#win").window({
                            width: 600,
                            height: 400,
                            // 定义是否将窗体显示为模式化窗口。
                            modal: true,
                            content: "<iframe src='${proPath}/base/goURL/supplier/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                        });
                    }
                }, '-', {
                    iconCls: 'icon-edit',
                    text: '修改',
                    handler: function () {
                        alert("修改按钮");
                        var array = $("#dg").datagrid("getSelections");
                        if (array.length == 1) {
                            alert(array.length)
                            parent.$('#win').window({
                                title: '修改页面',
                                width: 600,
                                height: 400,
                                modal: true,
                                content: "<iframe src='${proPath}/base/goURL/supplier/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                            });
                        } else {
                            alert(array.length)
                            $.messager.show({
                                title: '操作提示',
                                msg: "请只选择一条需要修改的记录。"
                            });
                        }
                    }
                }, '-', {
                    iconCls: 'icon-remove',
                    text: '删除',
                    handler: function () {
                        var array = $('#dg').datagrid("getSelections");
                        var ids = new Array();
                        for (var i = 0; i < array.length; i++) {
                            ids[i] = array[i].supId;
                            alert(ids[i]);
                        }
                        parent.$.messager.confirm("删除对话框", "您确定要删除吗？", function (isDelete) {
                            if (isDelete) {
                                alert("确定");
                                //通过ajax发送请求
                                $.ajax({
                                    url: "${proPath}/supplier/deleteList.action",
                                    type: "post",
                                    //设置为传统方式传送参数
                                    traditional: true,
                                    data: {pks: ids},
                                    success: function (html) {
                                        alert("成功时返回的数据：" + html);
                                        if (html > 0) {
                                            //重新刷新页面
                                            $("#dg").datagrid("reload");
                                            //删除后请清除所有勾选的行，否则会保存在easyui中，当第二次删除的时候又会删除第一次勾选的item
                                            $("#dg").datagrid("clearSelections");
                                        }
                                    },
                                    error: function (html) {
                                        alert("失败时返回的数据：" + html)
                                    },
                                    dataType: "json"
                                })


                            } else {
                                alert("取消")
                            }
                        });

                    }
                }, '-', {
                    /*这个不是一个真正的搜索框，需要用easyui来设置*/
                    text: "地址:<input type='text' id='supAddress' name='supAddress'/>"
                }, '-', {
                    text: "名称:<input type='text' id='supName' name='supName'/>"
                }
                ],
                columns: [[
                    {
                        checkbox: true //申明一个checkbox，用作全选
                    },
                    {field: 'supId', title: '供应商编号', width: 100},
                    {field: 'supName', title: '供应商名称', width: 100},
                    {field: 'supLinkman', title: '联系人', width: 100},
                    {field: 'supPhone', title: '联系电话', width: 100},
                    {field: 'supPay', title: '期初应付(元)', width: 100},
                    // 这一列需要特殊处理,使用格式化标签
                    {
                        field: 'supType',
                        title: '供应商类型',
                        width: 100,
                        formatter: function (value, row, index) {
                            if (value == 1) {
                                return "一级供应商";
                            } else if (value == 2) {
                                return "二级供应商";
                            } else if (value == 3) {
                                return "三级供应商";
                            }
                        }
                    },
                    {field: 'supAddress', title: '供应商地址', width: 100},
                    {field: 'supRemark', title: '备注', width: 100, align: 'right'}
                ]],
                fitColumns: true,
                nowrap: true,
                rownumbers: true,
                pagination: true,
                pageSize: 5,
                pageList: [3, 5, 10, 20],
                //添加查询条件,这里使用%%表示，如果没有查询条件，参数则默认是%%
                queryParams: {
                    supName: "%%",
                    supAddress: "%%"
                }
            });
            //注意这个写的位置
            $("#supName").searchbox({
                searcher: function (value, name) {
                    var supAddress = $("#supAddress").val();
                    alert("supAddress:" + supAddress);
                    var supName = value;
                    //异步请求服务器
                    $("#dg").datagrid("load", {
                        supName: '%' + supName + '%',
                        supAddress: '%' + supAddress + '%'
                    });
                },
                prompt: "请输入供应商名称"
            });
        });
    </script>
</head>

<body>
<%--创建dategrid--%>
<table id="dg"></table>
</body>
</html>