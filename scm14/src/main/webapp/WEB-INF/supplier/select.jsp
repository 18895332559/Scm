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
                },  '-', {
                    /*这个不是一个真正的搜索框，需要用easyui来设置*/
                    text: "地址:<input type='text' id='supAddress' name='supAddress'/>"
                }, '-', {
                    text: "名称:<input type='text' id='supName' name='supName'/>"
                }
                ],
                columns: [[
                    {
                        checkbox: true //申明一个checkbox
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
                queryParams: {
                    supName: "%%",
                    supAddress: "%%"
                }

            });
            //注意这个写的位置
            $("#supName").searchbox({
                searcher: function (value, name) {
                    var supAddress = $("#supAddress").val();
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